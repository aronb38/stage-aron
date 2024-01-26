plugins {
    alias(libs.plugins.convention.library.jacoco)
    alias(libs.plugins.convention.library.sonar)
    alias(libs.plugins.dagger.hilt.android)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.orange.archhelloworld.coretesting"
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
}

dependencies {
    // Timber
    api(libs.timber)
    // Dagger
    implementation(libs.dagger.hilt)
    ksp(libs.dagger.hilt.compiler)
    api(libs.bundles.coroutines)
    api(libs.bundles.test)

    // Test
    api(libs.bundles.androidtest)
}