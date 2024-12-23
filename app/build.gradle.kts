plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.example.aplicacionfinal"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.aplicacionfinal"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        compose = true
    }
}

dependencies {
    // Dependencias de Hilt
    implementation("com.google.dagger:hilt-android:2.44")

    // Dependencias de Compose
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)

    // Dependencias para Retrofit (API de The Movie DB)
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    // Coroutines (para Retrofit y otros procesos asincrónicos)
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.0")

    // Dependencias de Room (Base de datos local)
    implementation("androidx.room:room-runtime:2.4.3")
    implementation("androidx.room:room-ktx:2.4.3")


    // Test Dependencies
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)

    // Debugging dependencies
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)


    // Retrofit - Networking
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")

// Coroutines - para manejo de hilos de forma eficiente
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.0")

// OkHttp - Interceptor para hacer log de las peticiones
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.0")

// Compose
    implementation("androidx.navigation:navigation-compose:2.6.0")

 // Constraint
    implementation("androidx.constraintlayout:constraintlayout:2.2.0")
    implementation("androidx.constraintlayout:constraintlayout-compose:1.1.0")

    // otro

    implementation("io.coil-kt:coil-compose:2.4.0")
}
