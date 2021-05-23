plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdkVersion(Versions.compileSdk)
    buildToolsVersion(Versions.buildTools)

    defaultConfig {
        minSdkVersion(Versions.minSdk)
        targetSdkVersion(Versions.targetSdk)
        versionCode = 1
        versionName = "1"
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

    lintOptions {
        isAbortOnError = true
        isIgnoreWarnings = true
        lintConfig = rootProject.file("lint.xml")
    }
}

dependencies {
    implementation(Dependencies.kotlin)
    coroutines()
    implementation(Dependencies.timber)

    api(Dependencies.retrofit)
    api(Dependencies.gson)
    implementation(Dependencies.okhttp)
    implementation(Dependencies.retrofit_converter_gson)
    implementation(Dependencies.okhttp_logging_interceptor)

    dagger()

    test()
    testImplementation(Dependencies.okhttp_logging_interceptor)
}
