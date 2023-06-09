plugins {
    id("com.android.library")
    id("kotlin-android")
}

android {
    compileSdk = 33
    defaultConfig {
        minSdk = 26
        targetSdk = 33
    }
    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.7.0")
}
