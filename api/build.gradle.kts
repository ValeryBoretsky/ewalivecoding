plugins {
    id("com.android.library")
    id("kotlin-android")
}

android {
    buildToolsVersion = BuildVersions.buildToolsVersion
    compileSdk = BuildVersions.targetSdkVersion
    defaultConfig {
        minSdk = BuildVersions.minSdkVersion
        targetSdk = BuildVersions.targetSdkVersion
    }
    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }
}

dependencies {
    implementation(libs.kotlinStdlib)
}
