package com.codionics.spark.graphex

import org.apache.spark.sql.SparkSession

object GraphEx {

  val nodesFile = "src/main/resources/transport-nodes.csv"
  val edgesFile = "src/main/resources/transport-relationships.csv"

  def main(args: Array[String]) {

    val spark = SparkSession.builder
      .appName("Simple GraphX Application")
      .config("spark.master", "local")
      .getOrCreate()

    val nodesData = spark.read
      .format("csv")
      .option("header", "true")
      .load(nodesFile)
    nodesData.show()

    val edgesData = spark.read
      .format("csv")
      .option("header", "true")
      .load(edgesFile)
    edgesData.show()

    // val logFile = "YOUR_SPARK_HOME/README.md" // Should be some file on your system
    // val logData = spark.read.textFile(logFile).cache()
    // val numAs = logData.filter(line => line.contains("a")).count()
    // val numBs = logData.filter(line => line.contains("b")).count()
    // println(s"Lines with a: $numAs, Lines with b: $numBs")
    spark.stop()
  }
}
