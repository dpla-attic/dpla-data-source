licenses := Seq("MIT" -> url("https://opensource.org/licenses/MIT"))
homepage := Some(url("https://github.com/dpla/dpla-data-source"))
scmInfo := Some(
  ScmInfo(
    url("https://github.com/dpla/dpla-data-source"),
    "scm:git@github.com:dpla/dpla-data-source.git"
  )
)
developers := List(
  Developer(
    id    = "AudreyAltman",
    name  = "Audrey Altman",
    email = "audrey@dp.la",
    url = url("https://dp.la")
  ),
  Developer(
    id    = "markbreedlove",
    name  = "Mark Breedlove",
    email = "mb@dp.la",
    url = url("https://dp.la")
  ),
  Developer(
    id    = "mdellabitta",
    name  = "Michael Della Bitta",
    email = "michael@dp.la",
    url = url("https://dp.la")
  ),
  Developer(
    id    = "mgiraldo",
    name  = "Mauricio Giraldo",
    email = "mauricio@dp.la",
    url = url("https://dp.la")
  ),
  Developer(
    id    = "moltude",
    name  = "Scott Williams",
    email = "scott@dp.la",
    url = url("https://dp.la")
  )
)

publishMavenStyle := true
publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}

lazy val root = (project in file("."))
  .settings(

  organization := "la.dp",
    name := "dpla-data-source",
    version := "0.1.0",
    scalaVersion := "2.11.8",
    libraryDependencies ++= Seq(
      "org.apache.spark" %% "spark-core" % "2.1.0" % "provided",
      "org.apache.spark" %% "spark-sql" % "2.1.0" % "provided" exclude("org.scalatest", "scalatest_2.11"),
      "com.amazonaws" % "aws-java-sdk" % "1.7.4" % "provided"
    )
)
