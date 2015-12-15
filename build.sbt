name := "teamthing"

version := "1.0"

scalaVersion := "2.11.7"

scalacOptions ++= Seq(
  "-deprecation",
  "-feature",
  "-language:reflectiveCalls",
  "-Xlint",
  "-Xfatal-warnings"
)

libraryDependencies ++= Seq(
  "org.scalatest" % "scalatest_2.11" % "2.2.4" % "test"
)
