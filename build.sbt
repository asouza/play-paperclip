name := "play-paperclip"

version := "1.0-SNAPSHOT"

resolvers += Resolver.sonatypeRepo("releases")

organization := "com.github.asouza.play"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  "org.imgscalr" % "imgscalr-lib" % "4.2",
  "commons-io" % "commons-io" % "2.2"
)     

play.Project.playJavaSettings
