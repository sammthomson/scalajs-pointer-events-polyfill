enablePlugins(ScalaJSPlugin)

name := "scalajs-pointer-events-polyfill"

organization := "org.samthomson"

version := "0.2-SNAPSHOT"

scalaVersion := "2.11.8"

crossScalaVersions := Seq("2.11.8", "2.10.6")

licenses += ("MIT License", url("http://www.opensource.org/licenses/mit-license.php"))

libraryDependencies ++= Seq(
  "org.scala-js" %%% "scalajs-dom" % "0.9.0"
)

jsDependencies += ProvidedJS / "pep-0.4.1.js"

bintrayReleaseOnPublish in ThisBuild := false
