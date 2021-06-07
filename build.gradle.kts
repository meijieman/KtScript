// Top-level build file where you can add configuration options common to all sub-projects/modules.
import dependencies.Dep

buildscript {

    repositories {
        google()
        mavenCentral()
    }

    val kotlinVersion = "1.5.0"
    dependencies {
        classpath("com.android.tools.build:gradle:4.0.1")
//        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Dep.Kotlin.version}")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        jcenter() // Warning: this repository is going to shut down soon
    }
}

//tasks.register<Delete>("clean") {
//    delete(rootProject.buildDir)
//}

tasks.register("clean") {
    delete(rootProject.buildDir)
}