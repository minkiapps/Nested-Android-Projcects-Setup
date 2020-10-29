# Multi Gradle Projects Example

This project demonstrate a practise how to setup an Android Gradle project with nested projects, so you can tame the **Gradle files chaos**. This is quite useful if you want to demonstrate multiple use cases in form of different apps for a certain SDK.

### Structure
Root project 'MultiProjects'<br/> 
--- Project ':project1'<br/> 
------ Module ':project1:app'<br/>
--- Project ':project2'<br/>
------ Module ':project2:app'<br/>
--- Project ':project3'<br/> 
------ Module ':project3:app'<br/>
------ Module ':project3:modulelibrary'<br/> 
--- Project ':projectlibrary'<br/>

The `settings.gradle` is defined in the root folder and nowhere else, the advantage of this is you can open all projects at once and execute every sub project indivudually.
```
include ':projectlibrary'
include ':project1:app'
include ':project2:app'
include ':project3:app'
include ':project3:modulelibrary'
rootProject.name = "MultiProjects"
```

In the root build gradle file you define plugin dependency classpaths which should apply for all sub projects, like android-gradle plugin or kotlin:
```
buildscript {
    ext.kotlin_version = "1.4.10"
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath "com.android.tools.build:gradle:4.1.0"
        classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version"
    }
}
```
In each nested project you can define a `build.gradle` file with individual plugin dependency classpath, like [dexcount plugin](https://keepsafe.github.io/dexcount-gradle-plugin/) in project2:
```
buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath 'com.getkeepsafe.dexcount:dexcount-gradle-plugin:2.0.0'
    }
}
```

### Depend on project or module libraries

To depend on a shared project library, like **project1:app** on **projectlibrary**, add this in the app module build.gradle file: `implementation project (':projectlibrary')`

To depend on a module library, like **project3:app** on **project3:modulelibrary**, add this in the app module build.gradle file: `implementation project (':project3:modulelibrary')`

### Execute Multi-Project Builds

 If you want to execute for example countDebugDexMethods in project2, you can execute this in terminal from root folder: `./gradlew clean :project2:app:countDebugDexMethods`

Check also from Gradle official website [site](https://docs.gradle.org/current/userguide/intro_multi_project_builds.html).
