buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:${Versions.android_build_tools}")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}")
        classpath("com.alibaba:arouter-register:${Versions.arouter_register}")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigation_safe_args_plugin}")
        classpath("com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}")
    }
}

plugins {
    id("com.diffplug.spotless") version Versions.spotless apply false
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

subprojects {
    apply(plugin = "com.diffplug.spotless")
    configure<com.diffplug.gradle.spotless.SpotlessExtension> {
        kotlin {
            target("**/*.kt")
            ktlint(Versions.ktlint).userData(
                mapOf(
                    "disabled_rules" to "no-wildcard-imports",
                    "max_line_length" to "120"
                )
            )
            licenseHeaderFile(rootProject.file("copyright.kt"))
        }
        kotlinGradle {
            target("**/*.gradle.kts")
            ktlint(Versions.ktlint)
        }
    }
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
        kotlinOptions {
            // Treat all Kotlin warnings as errors
            allWarningsAsErrors = true
        }
    }
}

tasks.register<Exec>("installHooks") {
    commandLine("sh", "scripts/install-hooks.sh")
}

/*
tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}*/
