buildscript {
    repositories {
        google()
        mavenCentral()
        jcenter()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:${Versions.android_build_tools}")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}")
        classpath("com.alibaba:arouter-register:${Versions.arouter_register}")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigation_safe_args_plugin}")
        classpath("com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}")
        classpath("com.github.ben-manes:gradle-versions-plugin:${Versions.gradle_versions_plugin}")
    }
}

plugins {
    id("com.github.ben-manes.versions") version Versions.gradle_versions_plugin
    id("com.diffplug.spotless") version Versions.spotless apply false
}

allprojects {
    repositories {
        google()
        mavenCentral()
        jcenter()
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

            licenseHeaderFile(file("${rootDir.absolutePath}/copyright.kt"))
        }
        kotlinGradle {
            target("**/*.gradle.kts")
            ktlint(Versions.ktlint)
        }
    }
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
        kotlinOptions {
            allWarningsAsErrors = false
        }
    }
}

fun isNonStable(version: String): Boolean {
    val stableKeyword = listOf("RELEASE", "FINAL", "GA").any { version.toUpperCase().contains(it) }
    val regex = "^[0-9,.v-]+(-r)?$".toRegex()
    val isStable = stableKeyword || regex.matches(version)
    return isStable.not()
}

tasks.withType<com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask> {
    resolutionStrategy {
        componentSelection {
            all {
                if (isNonStable(candidate.version) && !isNonStable(currentVersion)) {
                    reject("Release candidate")
                }
            }
        }
    }
}

tasks.register<Exec>("installHooks") {
    commandLine("sh", "scripts/install-hooks.sh")
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
