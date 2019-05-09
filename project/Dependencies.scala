import sbt._

object Dependencies {
  val sparkVersion = "2.4.3"
  lazy val spark = "org.apache.spark" %% "spark-core" % sparkVersion
  lazy val sparkSql = "org.apache.spark" %% "spark-sql" % sparkVersion
  lazy val sparkGraph = "org.apache.spark" %% "spark-graphx" % sparkVersion
  lazy val sparkMlLib = "org.apache.spark" %% "spark-mllib" % sparkVersion

  lazy val scalaTest = "org.scalatest" %% "scalatest" % "3.0.5"
}
