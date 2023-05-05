lazy val `open4s-core` = project

lazy val root = (project in file("."))
  .settings(
    ThisBuild / name := "open4s",
    ThisBuild / organization := "com.github.duartesaraiva98",
    ThisBuild / scalaVersion := "2.13.8",
    ThisBuild / libraryDependencies ++= Seq(
      "io.netty" % "netty-all" % "4.1.91.Final",
      "io.circe" %% "circe-core" % "0.14.5",
      "io.circe" %% "circe-generic-extras" % "0.14.3",
      "org.scalatest" %% "scalatest" % "3.2.15" % "test",
      "org.scala-lang" % "scala-reflect" % "2.13.10"
    ),
    publish / skip := true
  )
  .aggregate(`open4s-core`)
