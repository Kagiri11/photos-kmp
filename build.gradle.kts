buildscript {
    configurations.all {
        resolutionStrategy {
            force("com.google.guava:guava:30.1.1-jre")
        }
    }

    dependencies {
        classpath("com.google.gms:google-services:4.4.2")
    }
}


plugins {
    //trick: for the same plugin versions in all sub-modules
    alias(libs.plugins.androidApplication).apply(false)
    alias(libs.plugins.androidLibrary).apply(false)
    alias(libs.plugins.kotlinAndroid).apply(false)
    alias(libs.plugins.kotlinMultiplatform).apply(false)
//    alias(libs.plugins.compose.compiler).apply(false)
    alias(libs.plugins.compose.multiplatform).apply(false)
}
