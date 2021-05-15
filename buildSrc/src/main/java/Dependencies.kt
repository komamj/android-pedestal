import org.gradle.api.artifacts.dsl.DependencyHandler

/*
 * Copyright 2021 komamj
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

object Dependencies {
    // kotlin
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
    const val coroutines_core =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val coroutines_android =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    const val coroutines_test =
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"

    // jetpack
    const val biometric = "androidx.biometric:biometric:${Versions.biometric}"
    const val annotation = "androidx.annotation:annotation:${Versions.annotation}"
    const val multidex = "androidx.multidex:multidex:${Versions.multidex}"

    // lifecycle
    const val lifecycle_runtime =
        "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
    val lifecycle_common_java8 =
        "androidx.lifecycle:lifecycle-common-java8:${Versions.lifecycle}"
    const val lifecycle_livedata =
        "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
    const val lifecycle_viewmodel =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val lifecycle_viewmodel_savedstate =
        "androidx.lifecycle:lifecycle-viewmodel-savedstate::${Versions.lifecycle}"
    const val lifecycle_service =
        "androidx.lifecycle:lifecycle-service:${Versions.lifecycle}"
    const val lifecycle_process =
        "androidx.lifecycle:lifecycle-process:${Versions.lifecycle}"
    const val arch_core_testing = "androidx.arch.core:core-testing:${Versions.arch_core_testing}"
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val fragment = "androidx.fragment:fragment-ktx:${Versions.fragment}"
    const val constraint_layout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraint_layout}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val viewpager2 = "androidx.viewpager2:viewpager2:${Versions.viewpager2}"

    // webkit
    const val webkit = "androidx.webkit:webkit:${Versions.webkit}"

    // room
    const val room_runtime = "androidx.room:room-runtime:${Versions.room}"
    const val room_compiler = "androidx.room:room-compiler:${Versions.room}"
    const val room_testing = "androidx.room:room-testing:${Versions.room}"

    // navigation
    const val navigation_fragment =
        "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navigation_ui =
        "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"

    // work
    const val work = "androidx.work:work-runtime-ktx:${Versions.work}"

    //startup
    const val startup = "androidx.startup:startup-runtime:${Versions.startup}"

    // paging
    const val paging = "androidx.paging:paging-runtime:${Versions.paging}"

    // datastore
    const val datastore =
        "androidx.datastore:datastore-preferences:${Versions.datastore}"

    // sqlite
    const val sqlite = "androidx.sqlite:sqlite:${Versions.sqlite}"

    // sqlcipher
    const val sqlcipher = "net.zetetic:android-database-sqlcipher:${Versions.sqlcipher}"

    // permission
    const val permission = "pub.devrel:easypermissions:${Versions.permission}"

    // arouter
    const val arouter_api = "com.alibaba:arouter-api:${Versions.arouter_api}"
    const val arouter_compiler =
        "com.alibaba:arouter-compiler:${Versions.arouter_compiler}"

    // timber
    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"

    //glide
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val glide_compiler = "com.github.bumptech.glide:compiler:${Versions.glide}"
    const val glide_okhttp_integration =
        "com.github.bumptech.glide:okhttp3-integration:${Versions.glide}"

    //gson
    const val gson = "com.google.code.gson:gson:${Versions.gson}"

    // retrofit
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofit_converter_gson =
        "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"

    // okhttp
    const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"
    const val okhttp_mockwebserver = "com.squareup.okhttp3:mockwebserver:${Versions.okhttp}"
    const val okhttp_logging_interceptor =
        "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp_logging_interceptor}"
    const val okio = "com.squareup.okio:okio:${Versions.okio}"

    // lottie
    const val lottie = "com.airbnb.android:lottie:${Versions.lottie}"

    const val leakcanary_android =
        "com.squareup.leakcanary:leakcanary-android:${Versions.leakcanary}"
}

fun DependencyHandler.base() {
    implementation(Dependencies.kotlin)
    implementation(Dependencies.fragment)
    implementation(Dependencies.appcompat)
    implementation(Dependencies.constraint_layout)
    implementation(Dependencies.material)
}

fun DependencyHandler.coroutines() {
    implementation(Dependencies.coroutines_core)
    implementation(Dependencies.coroutines_android)
    testImplementation(Dependencies.coroutines_test)
}

fun DependencyHandler.lifecycle() {
    implementation(Dependencies.lifecycle_runtime)
    implementation(Dependencies.lifecycle_livedata)
    implementation(Dependencies.lifecycle_common_java8)
    testImplementation(Dependencies.arch_core_testing)
}

fun DependencyHandler.navigation() {
    implementation(Dependencies.navigation_fragment)
    implementation(Dependencies.navigation_ui)
}

fun DependencyHandler.room() {
    implementation(Dependencies.room_runtime)
    kapt(Dependencies.room_compiler)
    testImplementation(Dependencies.room_testing)
}

fun DependencyHandler.network() {
    implementation(Dependencies.retrofit)
    implementation(Dependencies.retrofit_converter_gson)
    implementation(Dependencies.okhttp)
    implementation(Dependencies.okhttp_logging_interceptor)
    testImplementation(Dependencies.okhttp_logging_interceptor)
}

private fun DependencyHandler.implementation(depName: String) {
    add("implementation", depName)
}

private fun DependencyHandler.kapt(depName: String) {
    add("kapt", depName)
}

private fun DependencyHandler.compileOnly(depName: String) {
    add("compileOnly", depName)
}

private fun DependencyHandler.debugImplementation(depName: String) {
    add("debugImplementation", depName)
}

private fun DependencyHandler.testImplementation(depName: String) {
    add("testImplementation", depName)
}

private fun DependencyHandler.androidTestImplementation(depName: String) {
    add("androidTestImplementation", depName)
}

private fun DependencyHandler.kaptAndroidTest(depName: String) {
    add("kaptAndroidTest", depName)
}

private fun DependencyHandler.kaptTest(depName: String) {
    add("kaptTest", depName)
}