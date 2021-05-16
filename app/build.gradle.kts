plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("kotlin-parcelize")
}

android {
    compileSdkVersion(Versions.compileSdk)
    buildToolsVersion(Versions.buildTools)

    defaultConfig {
        applicationId = "com.komamj.host.demo"
        minSdkVersion(Versions.minSdk)
        targetSdkVersion(Versions.targetSdk)
        versionCode = 1
        versionName = "1"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    signingConfigs {
        create("release") {
        }
    }

    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
        }
    }

    buildFeatures {
        dataBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    lintOptions {
        isAbortOnError = true
        isIgnoreWarnings = true
    }

    applicationVariants.all {
        outputs.all {
            // Since we're using date for versionCode, manifest will change each time we compile and
            // so we won't be able to use "Apply codee changes" features as it doesn't work when
            // manifest is modified. To avoid that we force a versionCode to 1 for debug build.
            val outputImpl = this as com.android.build.gradle.internal.api.ApkVariantOutputImpl
            if (name.contains("debug")) outputImpl.versionCodeOverride = 1
        }
    }
}

dependencies {
    base()
}