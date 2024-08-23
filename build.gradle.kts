buildscript {
    configurations.all {
        resolutionStrategy {
            force("com.google.guava:guava:30.1.1-jre")
        }
    }

    dependencies {
        classpath("com.google.gms:google-services:4.4.2")
        classpath("dev.icerock.moko:resources-generator:0.24.1")
    }
}


plugins {
    alias(libs.plugins.androidApplication).apply(false)
    alias(libs.plugins.androidLibrary).apply(false)
    alias(libs.plugins.kotlinAndroid).apply(false)
    alias(libs.plugins.kotlinMultiplatform).apply(false)
    alias(libs.plugins.composeCompiler) apply false
    alias(libs.plugins.composeMultiplatform) apply false
}
