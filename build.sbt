version := "1.0.0"

enablePlugins(GatlingPlugin)

scalaVersion := "2.12.6"

scalacOptions := Seq(
  "-encoding", "UTF-8", "-target:jvm-1.8", "-deprecation",
  "-feature", "-unchecked", "-language:implicitConversions", "-language:postfixOps")

javaOptions in Gatling := overrideDefaultJavaOptions("-server", "-Xms1024m", "-Xmx2048m",
  "-XX:NewRatio=1", "-XX:MetaspaceSize=512M", "-XX:MaxMetaspaceSize=512M")

packageOptions in (Compile, packageBin) +=
  Package.ManifestAttributes("Main-Class" -> "gatling.test")

libraryDependencies += "io.gatling.highcharts" % "gatling-charts-highcharts" % "2.3.0" % "test"
libraryDependencies += "io.gatling"            % "gatling-test-framework"    % "2.3.0" % "test"
