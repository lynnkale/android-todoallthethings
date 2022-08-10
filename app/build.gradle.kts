plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.kapt")
    id("dagger.hilt.android.plugin")
    id("androidx.navigation.safeargs")
    id("org.jlleitschuh.gradle.ktlint")
    id("kotlin-kapt")
}

android {
    compileSdk = 32

    defaultConfig {
        applicationId = "com.lynnkale.todoallthethings"
        minSdk = 27
        targetSdk = 32
        versionCode = 1
        versionName = "0.1"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }

        javaCompileOptions {
            annotationProcessorOptions {
                arguments += mapOf("room.schemaLocation" to "$projectDir/schemas")
            }
        }
    }

    buildTypes {
        debug {
            isMinifyEnabled = false
            isShrinkResources = false
            isDefault = true
        }

        release {
            isMinifyEnabled = true
            isShrinkResources = true
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
    composeOptions {
        kotlinCompilerExtensionVersion = "1.2.0"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
        kotlinOptions.freeCompilerArgs += "-opt-in=kotlin.RequiresOptIn"
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.8.0")
    implementation("androidx.compose.ui:ui:1.3.0-alpha02")
    implementation("androidx.compose.material3:material3:1.0.0-alpha15")
    implementation("androidx.compose.ui:ui-tooling-preview:1.3.0-alpha02")
    implementation("androidx.compose.material3:material3-window-size-class:1.0.0-alpha15")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.5.1")
    implementation("androidx.activity:activity-compose:1.5.1")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.3.0-alpha02")
    debugImplementation("androidx.compose.ui:ui-tooling:1.3.0-alpha02")
    debugImplementation("androidx.compose.ui:ui-test-manifest:1.3.0-alpha02")
    implementation("androidx.compose.compiler:compiler:1.2.0")

    implementation("androidx.navigation:navigation-compose:2.5.1")
    implementation("com.google.accompanist:accompanist-systemuicontroller:0.17.0")

    // room
    implementation("androidx.room:room-runtime:2.4.3")
    kapt("androidx.room:room-compiler:2.4.3")
    implementation("androidx.room:room-ktx:2.4.3")
    implementation("androidx.room:room-paging:2.4.3")
    testImplementation("androidx.room:room-testing:2.4.3")
    implementation("androidx.paging:paging-compose:1.0.0-alpha15")

    implementation("com.google.dagger:hilt-android:2.43.2")
    kapt("com.google.dagger:hilt-android-compiler:2.43.2")
    kapt("androidx.hilt:hilt-compiler:1.0.0")
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")
    // Not a processor, but forces Dagger to use newer metadata lib
    kapt("org.jetbrains.kotlinx:kotlinx-metadata-jvm:0.5.0")
}
