lazy val commonSettings = Seq(
    test in assembly := {},
    mainClass in assembly := Some("dpla.data_source")
)

lazy val root = (project in file("."))
//  .configs(IntegrationTest)
  .settings(
    name := "dpla-data-source",
    version := "0.1.0",
    scalaVersion := "2.11.8",
    resolvers += "micronautics/scala on bintray" at "http://dl.bintray.com/micronautics/scala",
    libraryDependencies ++= Seq(
      "org.json4s" %% "json4s-core" % "3.2.11",
      "org.json4s" %% "json4s-jackson" % "3.2.11",
      "org.apache.spark" %% "spark-core" % "2.1.0" % "provided" exclude("org.scalatest", "scalatest_2.11"),
      "org.apache.spark" %% "spark-sql" % "2.1.0" % "provided" exclude("org.scalatest", "scalatest_2.11"),
      "com.micronautics" %% "awslib_scala" % "1.1.12"
    )
)
