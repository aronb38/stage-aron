plugins {
    alias(libs.plugins.convention.library.jacoco)
    alias(libs.plugins.convention.library.sonar)
    alias(libs.plugins.dagger.hilt.android)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.orange.archhelloworld.featureplaceholder"
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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
    }
    packaging {
        resources {
            excludes.add("META-INF/LICENSE-notice.md")
            excludes.add("META-INF/LICENSE.md")
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }
    testOptions {
        unitTests.all {
            it.useJUnitPlatform()
        }
    }
}

dependencies {
    implementation(project(":data"))
    implementation(project(":designsystem"))
    androidTestImplementation(project(":coretesting"))
    testImplementation(project(":coretesting"))
    // Timber
    api(libs.timber)
    // Dagger
    implementation(libs.dagger.hilt)
    ksp(libs.dagger.hilt.compiler)
    // Base Android UI / Presentation
    implementation(libs.bundles.lifecycle)
    // Navigation
    implementation(libs.bundles.navigation)
}