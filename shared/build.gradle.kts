plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.serialization)
    id("org.jetbrains.compose")
}

kotlin {
    android()

    jvm("desktop")

    sourceSets {
        sourceSets["commonMain"].dependencies {
            implementation(compose.animation)
            implementation(compose.foundation)
            implementation(compose.animation)
            implementation(compose.material)
            implementation(libs.paging.compose.common)
            implementation("media.kamel:kamel-image:0.9.1")
            implementation("androidx.paging:paging-common:3.3.0")
            implementation("androidx.paging:paging-compose-android:3.3.0")
            //put your multiplatform dependencies here
            implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.1")
            implementation(libs.kotlin.coroutines.core)
            implementation(libs.koin.core)
            implementation(libs.koin.android1)
            implementation(libs.koin.composeVM)
            implementation("androidx.paging:paging-runtime:3.3.0")
            implementation(libs.ktor.client.auth)
            implementation(libs.ktor.client.content.negotiation)
            implementation(libs.ktor.serialization)
            implementation(libs.ktor.client.core)
            implementation(libs.ktor.client.cio)
            implementation(libs.ktor.client.logging)
            implementation ("io.github.aakira:napier:2.7.1")
            implementation(libs.androidx.datastore)
            implementation("androidx.datastore:datastore-preferences-core:1.1.0")
            implementation("androidx.lifecycle:lifecycle-viewmodel:2.8.0-alpha03")
        }
        sourceSets["commonTest"].dependencies {
            implementation(libs.kotlin.test)
        }

        sourceSets["androidMain"].dependencies {
        }
        sourceSets["androidUnitTest"].dependencies {
        }
        sourceSets["androidInstrumentedTest"].dependencies {
        }

        sourceSets["desktopMain"].dependencies {
        }
        sourceSets["desktopTest"].dependencies {
        }
    }
}

android {
    namespace = "com.cmaina.photos"
    compileSdk = 34
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = 24
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}
