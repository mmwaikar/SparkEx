package com.codionics.spark.graphex

import org.apache.spark.sql.{DataFrame, SparkSession}
import org.graphframes._

object GraphEx {

  val nodesFile = "src/main/resources/transport-nodes.csv"
  val edgesFile = "src/main/resources/transport-relationships.csv"

  def main(args: Array[String]) {

    val spark = SparkSession.builder
      .appName("Simple GraphX Application")
      .config("spark.master", "local")
      .getOrCreate()

    try {

      val nodes: DataFrame = spark.read
        .format("csv")
        .option("header", "true")
        .load(nodesFile)
      nodes.show()

      val edges: DataFrame = spark.read
        .format("csv")
        .option("header", "true")
        .load(edgesFile)
      // val edges = spark.read.csv(edgesFile, "header = true")
      edges.show()

      val reversed_edges = edges
        .withColumn("newSrc", edges.col("dst"))
        .withColumn("newDst", edges.col("src"))
        .drop("dst", "src")
        .withColumnRenamed("newSrc", "src")
        .withColumnRenamed("newDst", "dst")
        .select("src", "dst", "relationship", "cost")

      val relationships = edges.union(reversed_edges)
      relationships.show()

      val g = GraphFrame(nodes, relationships)

      // using BFS
      println("using BFS")
      g.vertices
        .filter("population > 100000 and population < 3000000")
        .sort("population")
        .show()

    } finally {
      spark.stop()
    }

  }
}
