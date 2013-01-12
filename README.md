Sample-Android-Project
======================

This is a sample Android project that will be used to work on various project to increase the quality of Android Projects.

The idea is that Android programming is still in its infancy compared to the Java world. 
The Android community needs more robustness in Android apps and it looks like a good idea to build on the Java world experience and use its best tools for Quality Analysis.

Thanks to
 * [OCTO Technology](http://www.octo.com/en) to provide us with free time to work on that project.
 * Henri Trebmaly from [OCTO Technology](http://www.octo.com/en) for having ported [EasyMock](http://www.easymock.org/) to Android.
 * Thanks to [Jayway](http://www.jayway.com/blog) for their [Android Maven Plugin](http://code.google.com/p/maven-android-plugin/).
 * Thanks to [Sonar Source](http://www.sonarsource.org/) for supporting this effort.


Usage
=====

To build the sample project and run the sample app on a plugged rooted device / running emulator : 

```bash
# in parent folder
mvn clean install -Pemma
mvn sonar:sonar 
```

you will get tests results in : target/surefire-reports/.
you will get tests coverage in : target/emma/.


You may need to restart adb as root to be able to pull the emma coverage file. Type in a terminal :
```bash
adb root
```
