name := "scalatest-example"

scalaVersion := "2.13.0"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.8" % Test

mainClass in (Compile, run) := Some("billing.Restaurant")