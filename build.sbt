enablePlugins(ScalaJSPlugin)

name := "scala-js-pointer-events-polyfill"

version := "0.1-SNAPSHOT"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "org.scala-js" %%% "scalajs-dom" % "0.9.0"
)

jsDependencies += ProvidedJS / "pep-0.4.1.js"
