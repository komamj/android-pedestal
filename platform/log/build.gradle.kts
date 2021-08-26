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
    implementation(Dependencies.kotlin)
    coroutines()

    api(Dependencies.timber)

    test()
}
