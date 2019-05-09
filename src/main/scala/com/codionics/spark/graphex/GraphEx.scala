package com.codionics.spark.graphex

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.graphx._
import org.apache.spark.sql.{DataFrame, SQLContext, SparkSession}

object GraphEx {

  def main(args: Array[String]) {
    println(System.getProperty("user.dir"))
    val master = "local[*]"
    val appName = "Simple GraphX Application"

    val nodesFile = "./data/transport-nodes.csv"
    val edgesFile = "./data/transport-relationships.csv"

    val conf = new SparkConf().setAppName(appName).setMaster(master)
    val sc = new SparkContext(conf)

    val sparkSession = SparkSession.builder().appName(appName).master(master).getOrCreate()

    val nodesData: DataFrame = readFile(sparkSession, nodesFile)
    val edgesData: DataFrame = readFile(sparkSession, edgesFile)

    // val logFile = "YOUR_SPARK_HOME/README.md" // Should be some file on your system
    // val logData = spark.read.textFile(logFile).cache()
    // val numAs = logData.filter(line => line.contains("a")).count()
    // val numBs = logData.filter(line => line.contains("b")).count()
    // println(s"Lines with a: $numAs, Lines with b: $numBs")
//    spark.stop()

    sparkSession.stop()
    sc.stop()
  }

  def readFile(sparkSession: SparkSession, path: String): DataFrame = {
    sparkSession.read.format("csv").option("header", "true").load(path).cache()
  }
}
