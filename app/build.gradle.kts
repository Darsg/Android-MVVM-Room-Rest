plugins {
    alias(libs.plugins.android.application)
    id("org.jetbrains.kotlin.android") version "1.9.0"
    id("com.google.devtools.ksp")
    id("com.google.dagger.hilt.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.example.android_mvvm_room_rest"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.android_mvvm_room_rest"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {

    // Core Android libraries
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)


    // Networking libraries
    implementation(libs.retrofit)  // Retrofit for API calls
    implementation(libs.converter.gson)  // Converter for Gson

    // Room for local database
    implementation(libs.androidx.room.runtime)  // Room runtime library
    implementation(libs.androidx.room.ktx)  // Room Kotlin extensions
    ksp(libs.androidx.room.compiler)  // Annotation processing for Room

    // Coroutines for async programming
    implementation(libs.kotlinx.coroutines.android)

    // Image loading library
    implementation(libs.glide)  // Glide for image loading

    // Testing libraries
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // Coroutine
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)

    //RichEditor
    implementation(libs.richeditor.android)

    //Color picker
    implementation(libs.ambilwarna)

    // Hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)  // Use kapt for Hilt instead of annotationProcessor

    // Use for print Log of every request and response of API
    implementation(libs.logging.interceptor)
}
