plugins {
    alias(libs.plugins.convention.library.jacoco)
    alias(libs.plugins.convention.library.sonar)
    alias(libs.plugins.dagger.hilt.android)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.orange.archhelloworld.data"
    compileSdk = 34

    defaultConfig {
        minSdk = 28

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
    testOptions {
        unitTests.all {
            it.useJUnitPlatform()
        }
    }
}

dependencies {
    testImplementation(project(":coretesting"))
    androidTestImplementation(project(":coretesting"))
    // Timber
    api(libs.timber)
    // Dagger
    implementation(libs.dagger.hilt)
    ksp(libs.dagger.hilt.compiler)
}