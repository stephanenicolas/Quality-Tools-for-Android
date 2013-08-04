To setup such a project: 

* robolectric: add src/test/resources/org.robolectric.Config.properties 

manifest:../android-sample/AndroidManifest.xml

* maven: add pom with config pointing to project under test manifest, assets and res

* eclipse: add res, assets and AndroidManifest LINKS to project under tests
