name := "gatling-sbt"

version := "1.0.0"

organization := "org.sample"

scalaVersion := "2.12.6"

scalacOptions := Seq(
  "-encoding", "UTF-8", "-target:jvm-1.8", "-deprecation",
  "-feature", "-unchecked", "-language:implicitConversions", "-language:postfixOps")

javaOptions in Gatling := overrideDefaultJavaOptions("-server", "-Xms1024m", "-Xmx2048m",
  "-XX:NewRatio=1", "-XX:MetaspaceSize=512M", "-XX:MaxMetaspaceSize=512M")

enablePlugins(GatlingPlugin)

crossPaths := false
logLevel := Level.Warn

libraryDependencies ++= Seq(
  "io.gatling.highcharts" % "gatling-charts-highcharts" % "2.3.0" % "test",
  "io.gatling"            % "gatling-test-framework"    % "2.3.0" % "test"
)

packageOptions in (Compile, packageBin) +=
  Package.ManifestAttributes("Main-Class" -> "org.sample.test")

mainClass in Compile := Some("org.sample.Test")
