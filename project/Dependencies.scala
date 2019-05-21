import sbt._

object Dependencies {
  val sparkVersion = "2.4.3"

  lazy val spark = "org.apache.spark" % "spark-core_2.11" % sparkVersion
  lazy val sparkSql = "org.apache.spark" % "spark-sql_2.11" % sparkVersion
  lazy val sparkGraph = "org.apache.spark" % "spark-graphx_2.11" % sparkVersion
  lazy val sparkMlLib = "org.apache.spark" % "spark-mllib_2.11" % sparkVersion

  lazy val log4j = "org.apache.logging.log4j" % "log4j_2.11" % "2.11.2"

  lazy val scalaTest = "org.scalatest" % "scalatest_2.11" % "3.0.7"
}
