plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.serialization)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.compose.multiplatform)
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }

    jvm("desktop")

    sourceSets {
        sourceSets["commonMain"].dependencies {
            implementation(libs.androidx.datastore)
            implementation(libs.androidx.datastore.preferences.core)

            implementation(compose.animation)
            implementation(compose.foundation)
            implementation(compose.animation)
            implementation(compose.material)
            implementation(compose.components.resources)
            implementation(compose.materialIconsExtended)

            api(libs.koin.core)
            implementation(libs.kotlin.coroutines.core)
            implementation(libs.kotlinx.serialization.json)
            implementation(libs.koin.composeVM)
            implementation(libs.ktor.client.auth)
            implementation(libs.ktor.client.content.negotiation)
            implementation(libs.ktor.client.core)
            implementation(libs.ktor.client.cio)
            implementation(libs.ktor.client.logging)
            implementation(libs.ktor.client.json)
            implementation(libs.ktor.serialization.kotlinx.json)

            implementation(libs.material3.window.size)
            implementation(libs.material.icons.extended.desktop)
            implementation(libs.navigation.compose)

            implementation(libs.napier)

            implementation(libs.paging.common)
            implementation(libs.paging.compose.common)

            implementation(libs.slf4j.api)

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
            implementation(libs.kotlin.coroutines.core)
            implementation(libs.kotlinx.coroutines.swing)
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
