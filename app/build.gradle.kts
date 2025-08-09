plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "fpoly.sonhaph40315_20_6.duan_prostore"
    compileSdk = 36

    defaultConfig {
        applicationId = "fpoly.sonhaph40315_20_6.duan_prostore"
        minSdk = 28
        targetSdk = 36
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
}

dependencies {
    // Fix lỗi CoreComponentFactory
    implementation("androidx.core:core:1.13.1")

    // UI components
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.recyclerview:recyclerview:1.3.1")

    // Google login
    implementation("com.google.android.gms:play-services-auth:21.0.0")

    // Glide (dùng thư viện alias từ libs.versions.toml)
    implementation(libs.glide)
    implementation(libs.activity)
    annotationProcessor(libs.glide.compiler)

    // Unit testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}
