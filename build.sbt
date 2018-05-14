import Dependencies._

organization in ThisBuild := "fpmortals"
scalaVersion in ThisBuild := "2.12.6"
version in ThisBuild := "0.0.1-SNAPSHOT"
name in ThisBuild := "fpmortals"

scalacOptions in ThisBuild ++= Seq(
  "-language:_",
  "-Ypartial-unification",
  "-Xfatal-warnings"
)
libraryDependencies ++= Seq(
  "com.github.mpilquist" %% "simulacrum" % "0.12.0",
  "com.chuusai"          %% "shapeless" % "2.3.3" ,
  "org.scalaz"           %% "scalaz-core" % "7.2.21",
  scalaTest
)

addCompilerPlugin("org.spire-math" %% "kind-projector" % "0.9.6")
addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.1" cross CrossVersion.full)

initialCommands in console := "import scalaz._, Scalaz._, algebra.ConsoleIo._"
