Run options

sbt run

or to test

sbt test

Works in Intellij with version community 2019.2 and scala plugin 2019.2.14

Early versions with scala plugin results in following error during test

Exception in thread "ScalaTest-dispatcher" java.lang.NoSuchMethodError: scala.collection.JavaConverters.seqAsJavaListConverter(Lscala/collection/Seq;)Lscala/collection/convert/Decorators$AsJava;
	at org.jetbrains.plugins.scala.testingSupport.scalaTest.treeBuilder.ParallelTreeBuilder.getOrdinalList(ParallelTreeBuilder.java:21)
	at org.jetbrains.plugins.scala.testingSupport.scalaTest.treeBuilder.ParallelTreeBuilder$SuiteTree.<init>(ParallelTreeBuilder.java:92)
	at org.jetbrains.plugins.scala.testingSupport.scalaTest.treeBuilder.ParallelTreeBuilder.initRun(ParallelTreeBuilder.java:261)
	at org.jetbrains.plugins.scala.testingSupport.scalaTest.ScalaTestReporterWithLocation.apply(ScalaTestReporterWithLocation.java:59)
	at org.scalatest.DispatchReporter$Propagator.$anonfun$run$10(DispatchReporter.scala:249)
	at org.scalatest.DispatchReporter$Propagator.$anonfun$run$10$adapted(DispatchReporter.scala:248)
	at scala.collection.immutable.List.foreach(List.scala:312)
	at org.scalatest.DispatchReporter$Propagator.run(DispatchReporter.scala:248)
	at java.lang.Thread.run(Thread.java:748)