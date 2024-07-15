plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.serialization)
}

kotlin {
    android()

    jvm("desktop")

    /*listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            isStatic = true
        }
    }*/

    sourceSets {
        sourceSets["commonMain"].dependencies {
            //put your multiplatform dependencies here
            implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.1")
            implementation(libs.kotlin.coroutines.core)
            implementation(libs.koin.core)
            implementation("androidx.paging:paging-runtime:3.3.0")
            implementation(libs.ktor.client.auth)
            implementation(libs.ktor.client.content.negotiation)
            implementation(libs.ktor.serialization)
            implementation(libs.ktor.client.core)
            implementation(libs.ktor.client.cio)
            implementation(libs.ktor.client.logging)
            implementation ("io.github.aakira:napier:2.7.1")
            implementation(libs.androidx.datastore)
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
    defaultConfig {
        minSdk = 24
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}
