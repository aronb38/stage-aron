plugins {
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.convention.library.jacoco)
    alias(libs.plugins.convention.library.sonar)
}

android {
    namespace = "com.orange.archhelloworld.designsystem"
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
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }
}

sonar {
    properties {
        property(
            "sonar.coverage.exclusions",
            "**/*.*"
        )
    }
}

dependencies {
    testImplementation(project(":coretesting"))
    androidTestImplementation(project(":coretesting"))
    // Compose
    api(libs.bundles.compose.ui)
    api(libs.bundles.compose.material)
}