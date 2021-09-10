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
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"
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
    const val lifecycle_common_java8 =
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
    const val activity = "androidx.activity:activity-ktx:${Versions.activity}"
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

    // compose
    const val compose_ui = "androidx.compose.ui:ui:${Versions.compose}"
    const val compose_material = "androidx.compose.material:material:${Versions.compose}"
    const val compose_preview = "androidx.compose.ui:ui-tooling-preview:${Versions.compose}"
    const val activity_compose = "androidx.activity:activity-compose:${Versions.compose}"
    const val compose_ui_tooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
    const val compose_ui_test_junit4 = "androidx.compose.ui:ui-test-junit4:${Versions.compose}"

    // navigation
    const val navigation_fragment =
        "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navigation_ui =
        "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    const val navigation_testing = "androidx.navigation:navigation-testing:${Versions.navigation}"

    // work
    const val work = "androidx.work:work-runtime-ktx:${Versions.work}"

    //startup
    const val startup = "androidx.startup:startup-runtime:${Versions.startup}"

    // dagger
    const val hilt_android = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val hilt_compiler = "com.google.dagger:hilt-compiler:${Versions.hilt}"
    const val hilt_android_testing = "com.google.dagger:hilt-android-testing:${Versions.hilt}"
    const val hilt_navigation_fragment =
        "androidx.hilt:hilt-navigation-fragment:${Versions.hilt_androidx}"
    const val hilt_work = "androidx.hilt:hilt-work:${Versions.hilt_androidx}"
    const val hilt_androidx_compiler = "androidx.hilt:hilt-compiler:${Versions.hilt_androidx}"

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

    // glide
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val glide_compiler = "com.github.bumptech.glide:compiler:${Versions.glide}"
    const val glide_okhttp_integration =
        "com.github.bumptech.glide:okhttp3-integration:${Versions.glide}"

    // gson
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

    // leakcanary
    const val leakcanary_android =
        "com.squareup.leakcanary:leakcanary-android:${Versions.leakcanary}"

    // test
    const val junit = "junit:junit:${Versions.junit}"
    const val test_core = "androidx.test:core:${Versions.test}"
    const val test_rules = "androidx.test:runner:${Versions.test}"
    const val test_runner = "androidx.test:runner:${Versions.test}"
    const val test_junit = "androidx.test.ext:junit:${Versions.test_junit}"
    const val test_truth = "androidx.test.ext:truth:${Versions.test}"
    const val google_truth = "com.google.truth:truth:${Versions.truth}"
    const val espresso_core = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    const val espresso_contrib = "androidx.test.espresso:espresso-contrib:${Versions.espresso}"
    const val espresso_intents = "androidx.test.espresso:espresso-intents:${Versions.espresso}"
    const val espresso_accessibility =
        "androidx.test.espresso:espresso-accessibility:${Versions.espresso}"
    const val espresso_web = "androidx.test.espresso:espresso-web:${Versions.espresso}"
    const val espresso_idling_concurrent =
        "androidx.test.espresso:idling:idling-concurrent:${Versions.espresso}"
    const val espresso_idling_resource =
        "androidx.test.espresso:espresso-idling-resource:${Versions.espresso}"
    const val robolectric = "org.robolectric:robolectric:${Versions.robolectric}"
    const val mockito_core = "org.mockito:mockito-core:${Versions.mockito}"
    const val mockito_android = "org.mockito:mockito-android:${Versions.mockito}"
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

fun DependencyHandler.compose() {
    implementation(Dependencies.compose_ui)
    implementation(Dependencies.compose_material)
    implementation(Dependencies.compose_preview)
    implementation(Dependencies.activity_compose)
    debugImplementation(Dependencies.compose_ui_tooling)
    androidTestImplementation(Dependencies.compose_ui_test_junit4)
}

fun DependencyHandler.navigation() {
    implementation(Dependencies.navigation_fragment)
    implementation(Dependencies.navigation_ui)
    androidTestImplementation(Dependencies.navigation_testing)
}

fun DependencyHandler.arouter() {
    implementation(Dependencies.arouter_api)
    kapt(Dependencies.arouter_compiler)
}

fun DependencyHandler.dagger() {
    implementation(Dependencies.hilt_android)
    kapt(Dependencies.hilt_compiler)
}

fun DependencyHandler.daggerAndroidX() {
    implementation(Dependencies.hilt_navigation_fragment)
    implementation(Dependencies.hilt_work)
    kapt(Dependencies.hilt_androidx_compiler)
    testImplementation(Dependencies.hilt_android_testing)
    androidTestImplementation(Dependencies.hilt_android_testing)
}

fun DependencyHandler.room() {
    implementation(Dependencies.room_runtime)
    kapt(Dependencies.room_compiler)
    testImplementation(Dependencies.room_testing)
}

fun DependencyHandler.network() {
    implementation(Dependencies.retrofit)
    implementation(Dependencies.retrofit_converter_gson)
    implementation(Dependencies.gson)
    implementation(Dependencies.okhttp)
    implementation(Dependencies.okhttp_logging_interceptor)
    testImplementation(Dependencies.okhttp_logging_interceptor)
}

fun DependencyHandler.test() {
    testImplementation(Dependencies.junit)
    testImplementation(Dependencies.google_truth)
    testImplementation(Dependencies.robolectric)
    testImplementation(Dependencies.mockito_core)
}

fun DependencyHandler.androidTest() {
    androidTestImplementation(Dependencies.test_core)
    androidTestImplementation(Dependencies.test_runner)
    androidTestImplementation(Dependencies.test_rules)
    androidTestImplementation(Dependencies.test_junit)
    androidTestImplementation(Dependencies.test_truth)
    androidTestImplementation(Dependencies.google_truth)
    androidTestImplementation(Dependencies.espresso_core)
    androidTestImplementation(Dependencies.espresso_contrib)
    androidTestImplementation(Dependencies.espresso_intents)
    androidTestImplementation(Dependencies.espresso_accessibility)
    androidTestImplementation(Dependencies.espresso_web)
    androidTestImplementation(Dependencies.espresso_idling_concurrent)
    androidTestImplementation(Dependencies.espresso_idling_resource)
    androidTestImplementation(Dependencies.mockito_android)
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