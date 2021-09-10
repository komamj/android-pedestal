plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    compileSdk = Versions.compileSdk
    buildToolsVersion = Versions.buildTools

    defaultConfig {
        minSdk = Versions.minSdk
        targetSdk = Versions.targetSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    lint {
        isAbortOnError = true
        isIgnoreWarnings = true
        lintConfig = rootProject.file("lint.xml")
    }
}

dependencies {
    api(Dependencies.kotlin)
    api(Dependencies.appcompat)

    api(Dependencies.coroutines_core)
    api(Dependencies.coroutines_android)

    testApi(Dependencies.junit)
    testApi(Dependencies.google_truth)
    testApi(Dependencies.robolectric)
    testApi(Dependencies.mockito_core)
    testApi(Dependencies.coroutines_test)

    androidTestApi(Dependencies.junit)
    androidTestApi(Dependencies.google_truth)
    androidTestApi(Dependencies.robolectric)
    androidTestApi(Dependencies.mockito_core)
    androidTestApi(Dependencies.coroutines_test)
}
