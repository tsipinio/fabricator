import sbt.Keys._

scalaVersion := "2.13.11"

crossScalaVersions := Seq("2.12.18", "2.13.11", "3.3.0")

scalacOptions += "-target:jvm-1.8"

name := "fabricator"

version := "2.2.0"

organization := "com.github.azakordonets"

licenses += ("Apache-2.0", url("http://www.apache.org/licenses/LICENSE-2.0.html"))

homepage := Some(url("https://github.com/azakordonets/fabricator"))

organizationHomepage := Some(url("https://biercoff.com"))

publishMavenStyle := true

publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases" at nexus + "service/local/staging/deploy/maven2")
}

credentials += Credentials(
  "Sonatype Nexus Repository Manager",
  "oss.sonatype.org",
  sys.props.getOrElse("SONATYPE_USERNAME", default = "biercoff"),
  sys.props.getOrElse("SONATYPE_PASSWORD", default = "not_found")
)

Test / publishArtifact := false

pomIncludeRepository := { _ => false }

Compile / unmanagedResourceDirectories += {
  baseDirectory.value / "src/main/resources"
}

Test / fork := true

pomExtra :=
  <developers>
    <developer>
      <id>azakordonets</id>
      <name>Andrew Zakordonets</name>
      <url>http://biercoff.com</url>
    </developer>
  </developers>

coverageMinimumStmtTotal := 70

coverageFailOnMinimum := true

resolvers += "Typesafe Simple Repository" at "https://repo.typesafe.com/typesafe/simple/maven-releases/"

resolvers += "Typesafe repository" at "https://repo.typesafe.com/typesafe/releases/"

resolvers += "JCenter" at "https://dl.bintray.com/"

resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"

resolvers += Classpaths.sbtPluginReleases

resolvers += Resolver.typesafeRepo("releases")

libraryDependencies ++= Seq(
  "com.typesafe.play"          %% "play-json"         % "2.10.0-RC9",
  "org.scalatestplus"          %% "testng-7-5"        % "3.2.16.0" % "test",
  "com.github.nscala-time"     %% "nscala-time"       % "2.32.0",
  "com.typesafe.scala-logging" %% "scala-logging"     % "3.9.4",
  "org.reflections"             % "reflections"       % "0.9.12",
  "ch.qos.logback"              % "logback-classic"   % "1.2.3",
  "org.assertj"                 % "assertj-core"      % "3.19.0",
  "com.spatial4j"               % "spatial4j"         % "0.5",
  "org.iban4j"                  % "iban4j"            % "3.2.2-RELEASE",
  "commons-validator"           % "commons-validator" % "1.7",
  "com.google.inject"           % "guice"             % "5.0.1",
  "com.github.tototoshi"       %% "scala-csv"         % "1.3.10",
  "com.google.zxing"            % "core"              % "3.4.1",
  "io.github.classgraph"        % "classgraph"        % "4.8.102"
)
