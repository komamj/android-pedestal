plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    id("kotlin-android")
}

kapt {
    correctErrorTypes = true
    useBuildCache = true
    arguments {
        arg("AROUTER_MODULE_NAME", project.name)
        arg("AROUTER_GENERATE_DOC", "enable")
    }
}

android {
    compileSdk = Versions.compileSdk
    buildToolsVersion = Versions.buildTools

    defaultConfig {
        minSdk = Versions.minSdk
        targetSdk = Versions.targetSdk
        resourcePrefix("common_")

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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

    lint {
        isAbortOnError = true
        isIgnoreWarnings = true
        lintConfig = rootProject.file("lint.xml")
    }
}

dependencies {
    api(Dependencies.kotlin)
    // coroutines
    api(Dependencies.coroutines_core)
    api(Dependencies.coroutines_android)
    testApi(Dependencies.coroutines_test)
    // lifecycle
    api(Dependencies.lifecycle_runtime)
    api(Dependencies.lifecycle_livedata)
    api(Dependencies.lifecycle_common_java8)
    testApi(Dependencies.arch_core_testing)

    api(Dependencies.appcompat)
    api(Dependencies.constraint_layout)
    api(Dependencies.material)

    // navigation
    api(Dependencies.navigation_fragment)
    api(Dependencies.navigation_ui)

    arouter()
    dagger()
    daggerAndroidX()
    rxjava3()
    // platform
    api(project(":network"))
    api(project(":log"))

    // test
    testApi(Dependencies.junit)
    testApi(Dependencies.google_truth)
    testApi(Dependencies.robolectric)
    testApi(Dependencies.mockito_core)
}
