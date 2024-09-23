plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.composeMultiplatform)
}

android {
    namespace = "com.cmaina.photos.android"
    compileSdk = 34
    defaultConfig {
        applicationId = "com.cmaina.photos.android"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(projects.shared)

    implementation(libs.androidx.activity.compose)

    implementation(compose.foundation)
    implementation(compose.ui)
    implementation(compose.material3)
    implementation(libs.compose.ui.tooling.preview)

    implementation(libs.koin.core)
    implementation(libs.koin.android1)
    implementation(libs.koin.androidx.compose)
}