plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinSerialization)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.ksp)
    alias(libs.plugins.room)
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

            implementation(libs.bundles.coil)

            implementation(compose.animation)
//            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.materialIconsExtended)
            implementation(compose.components.resources)

            implementation(libs.room.runtime)
            implementation(libs.sqlite.bundled)

            api(libs.koin.core)
            implementation(libs.kotlin.coroutines.core)
            implementation(libs.kotlinx.serialization.json)
            implementation(libs.koin.composeVM)

            implementation(libs.bundles.compottie)
            implementation(libs.bundles.ktor)

            implementation(libs.ktor.serialization.kotlinx.json)
            implementation(libs.material3.window.size)
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
            implementation(compose.desktop.currentOs)
        }
    }
}

kotlin.sourceSets.all {
    val libs = listOf(
        "org.koin.core.annotation.KoinExperimentalAPI",
        "androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi",
        "coil3.annotation.ExperimentalCoilApi",
        "androidx.compose.foundation.ExperimentalFoundationApi"
    )

    libs.forEach {
        languageSettings.optIn(it)
    }
}

room {
    schemaDirectory("$projectDir/schemas")
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

dependencies {
    ksp(libs.room.compiler)
    ksp(libs.koin.ksp.compiler)
}