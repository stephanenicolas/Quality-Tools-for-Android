# Sample-Android-Project


This is an Android sample app + tests that will be used to work on various project to increase the quality of the Android platform.

The idea is that Android programming is still in its infancy compared to the Java world. 
The Android community needs more robustness in Android apps and it looks like a good idea to build on the Java world experience and use its best tools for Quality Analysis.

We want to provide a full featured industrial development environment that can be used to create more
robust projects on Android, by using any of the most interesting and popular technologies.

# Already integrated :

* Standard Android testing framework and code coverage using emma, reported in Sonar. That also covers robotium, easy mock and mockito technologies.
* Robolectric testing framework and code coverage using Cobertura, reported in Sonar.

# What is missing (TODO/INTEGRATE) : 

* UIAutomator through Maven, get the results in Sonar (maybe using [this testrunner](https://github.com/dpreussler/automator-log-converter)), and test coverage in Sonar
* get monkey through Maven, [using this technique](http://stackoverflow.com/questions/3968064/ideas-for-automating-android-monkey-runs) get the results in Sonar
* get Lint integration via Maven, get the results in Sonar
* get pmd, findbugs, checkstyle integration via Maven and share config with Sonar
* get alls test running in jenkins, reported in a sonar
* get android maven lint integration (the android pom parser)
* get aggregated tests and code coverage

# Usage

This section describes how to build & test the project using those different testing technologies.

## Standard Android testing APIs and code coverage using emma

To build the sample project and run the sample app on a plugged rooted device / running emulator : 

```bash
# in parent folder
mvn clean install -Pemma
mvn sonar:sonar -Pemma
```

you will get tests results in : target/surefire-reports/.
you will get tests coverage in : target/emma/.

Here is the result in sonar : 
<img src="https://raw.github.com/stephanenicolas/Sample-Android-Project/master/gfx/screenshot-sonar-emma-config.png" width=450px/>

You may need to restart adb as root to be able to pull the emma coverage file. Type in a terminal :
```bash
adb root
```

## Robolectric and code coverage using cobertura

```bash
# in parent folder
mvn clean cobertura:cobertura -Probolectric
mvn sonar:sonar -Probolectric
```

Here is the result in sonar : 
<img src="https://raw.github.com/stephanenicolas/Sample-Android-Project/master/gfx/screenshot-sonar-robolectric-config.png" width=450px/>


# Thanks to
 * [OCTO Technology](http://www.octo.com/en) to provide us with free time to work on that project.
 * Henri Trebmaly from [OCTO Technology](http://www.octo.com/en) for having ported [EasyMock](http://www.easymock.org/) to Android.
 * Thanks to [Jayway](http://www.jayway.com/blog) for their [Android Maven Plugin](http://code.google.com/p/maven-android-plugin/).
 * Thanks to [Sonar Source](http://www.sonarsource.org/) for supporting this effort, especially for this [project's configuration](https://github.com/SonarSource/sonar-examples/tree/master/projects/android).
