
plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.serialization)
    alias(libs.plugins.compose.compiler)
    id("org.jetbrains.compose")
}

kotlin {
    androidTarget()

    jvm()

    sourceSets {
        sourceSets["commonMain"].dependencies {
            implementation(compose.animation)
            implementation(compose.foundation)
            implementation(compose.animation)
            implementation(compose.material)
            implementation(libs.kamel.image)
            implementation(libs.paging.common)
            implementation(libs.paging.compose.common)
            //put your multiplatform dependencies here
            implementation(libs.kotlinx.serialization.json)
            implementation(libs.kotlin.coroutines.core)
            api(libs.koin.core)
            implementation(libs.koin.composeVM)
            implementation(libs.ktor.client.auth)
            implementation(libs.ktor.client.content.negotiation)
            implementation(libs.ktor.client.core)
            implementation(libs.ktor.client.cio)
            implementation(libs.ktor.client.logging)
            implementation(libs.ktor.client.json)
            implementation(libs.ktor.serialization.kotlinx.json)
            implementation("io.github.aakira:napier:2.7.1")
            implementation(libs.androidx.datastore)
            implementation("androidx.datastore:datastore-preferences-core:1.1.0")
            implementation("org.jetbrains.androidx.navigation:navigation-compose:2.7.0-alpha07")
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
        sourceSets["jvmMain"].dependencies {
            implementation(libs.kotlin.coroutines.core)
            implementation("org.jetbrains.kotlinx:kotlinx-coroutines-swing:1.9.0-RC")
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
