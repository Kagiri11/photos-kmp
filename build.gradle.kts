import java.util.Properties

buildscript {
    configurations.all {
        resolutionStrategy {
            force("com.google.guava:guava:30.1.1-jre")
        }
    }

    dependencies {
        classpath("com.google.gms:google-services:4.4.2")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:2.1.0")
        classpath("com.codingfeline.buildkonfig:buildkonfig-gradle-plugin:0.17.1")
    }
}


plugins {
    alias(libs.plugins.androidApplication).apply(false)
    alias(libs.plugins.androidLibrary).apply(false)
    alias(libs.plugins.kotlinAndroid).apply(false)
    alias(libs.plugins.kotlinMultiplatform).apply(false)
    alias(libs.plugins.composeCompiler) apply false
    alias(libs.plugins.composeMultiplatform) apply false
//    id("com.codingfeline.buildkonfig") apply false
}