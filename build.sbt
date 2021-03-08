name := "scala-tutorial"
organization := "com.gavin"
version := "1.0"
scalaVersion := "2.13.5"

val catsVersion       = "2.4.2"
val catsEffectVersion = "2.3.3"
val catsMtlVersion    = "0.7.1"

libraryDependencies ++= Seq(
  "org.typelevel" %% "cats-core"     % catsVersion,
  "org.typelevel" %% "cats-effect"   % catsEffectVersion,
  "org.typelevel" %% "cats-mtl-core" % catsMtlVersion,
)
