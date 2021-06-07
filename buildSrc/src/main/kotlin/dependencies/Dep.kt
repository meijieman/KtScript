package dependencies

object Dep {

    object Plugin {
        val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Kotlin.version}"
    }

    object Kotlin {
        const val version = "1.5.0"
        val stdlibJdk = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$version"
    }

    object AndroidX {
        val appCompat = "androidx.appcompat:appcompat:1.1.0"
        val coreKtx = "androidx.core:core-ktx:1.2.0-rc01"
        val constraint = "androidx.constraintlayout:constraintlayout:2.0.0-beta2"
    }
}