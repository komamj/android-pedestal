plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("androidx.navigation.safeargs.kotlin")
    id("dagger.hilt.android.plugin")
    id("com.alibaba.arouter")
    id("kotlin-parcelize")
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
        applicationId = "com.komamj.pedestal.demo"
        minSdk = Versions.minSdk
        targetSdk = Versions.targetSdk
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
        lintConfig = rootProject.file("lint.xml")
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
    dagger()

    implementation(project(":launcher"))
    implementation(project(":common"))

    debugImplementation(Dependencies.leakcanary_android)
}
