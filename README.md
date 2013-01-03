Sample-Android-Project-for-Sonar
================================

This is a sample Android project that will be used to work on a Sonar Android branch.
It follows up [a discussion with some Sonar commiters in July 2012](http://comments.gmane.org/gmane.comp.java.sonar.devel/10411)...

The idea is that Android programming is still in its infancy compared to the Java world. 
The Android community needs more robustness in Android apps and it looks like a good idea to build on the Java world experience and use its best tools for Quality Analysis.

Thanks to [Sonar Source](http://www.sonarsource.org/) for supporting this effort.
Thanks to [OCTO Technology](http://www.octo.com/en) to provide us with free time to work on that project.

Usage
=====

To build the sample project and run the sample app on a plugged device / running emulator : 

```bash
cd sonar-android-sample
mvn clean install android:deploy android:run
```

To run the tests and get code coverage and tests results on a plugged rooted device / running emulator : 

```bash
cd sonar-android-sample-test
 mvn clean install android:pull
```

you will get tests results in : target/surefire-reports/.
you will get tests coverage in : target/emma/.
