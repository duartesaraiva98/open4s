name := "open4s"
organization := "com.github.duartesaraiva98"

scalaVersion := "2.13.8"

libraryDependencies += "io.netty" % "netty-all" % "4.1.91.Final"
libraryDependencies += "io.circe" %% "circe-core" % "0.14.5"
libraryDependencies += "io.circe" %% "circe-generic-extras" % "0.14.3"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.15" % "test"
libraryDependencies += "org.scala-lang" % "scala-reflect" % "2.13.10"

val `macro` = project
val `open4s-core` = project.dependsOn(`macro`)
