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
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}