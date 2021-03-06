organization := Common.Organization

name := "root"

scalaVersion := Common.ScalaVersion

crossScalaVersions := Common.CrossScalaVersions

version := Common.Version

parallelExecution in Test := Common.ParallelExecutionInTest

scalacOptions ++= Common.ScalaCOptions

publishLocal := {}

publish := {}

publishArtifact := false

lazy val root = (
  project in file(".")
    aggregate(akkaPersistenceMongoCommon, akkaPersistenceMongoCasbah, akkaPersistenceMongoCommandSourcingExampleApp,
      akkaPersistenceMongoEventSourcingExampleApp)
  )

lazy val akkaPersistenceMongoCommon =
  project in file(Common.NameCommon)

lazy val akkaPersistenceMongoCasbah = (
  project in file(Common.NameCasbah)
    dependsOn(akkaPersistenceMongoCommon % Common.TestCompile)
  )

lazy val akkaPersistenceMongoCommandSourcingExampleApp =
  project in file(Common.NameCommandSourcingExampleApp)

lazy val akkaPersistenceMongoEventSourcingExampleApp =
  project in file(Common.NameEventSourcingExampleApp)
