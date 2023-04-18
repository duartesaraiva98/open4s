ThisBuild / name := "open4s"
ThisBuild / organization := "com.github.duartesaraiva98"

ThisBuild / scalaVersion := "2.13.8"

ThisBuild / libraryDependencies += "io.netty" % "netty-all" % "4.1.91.Final"
ThisBuild / libraryDependencies += "io.circe" %% "circe-core" % "0.14.5"
ThisBuild / libraryDependencies += "io.circe" %% "circe-generic-extras" % "0.14.3"
ThisBuild / libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.15" % "test"
ThisBuild / libraryDependencies += "org.scala-lang" % "scala-reflect" % "2.13.10"

val `open4s-core` = project
