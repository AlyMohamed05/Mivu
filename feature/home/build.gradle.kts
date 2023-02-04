plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.silverbullet.feature.home"
    compileSdk = 33

    defaultConfig {
        minSdk = 21
        targetSdk = 33

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
    buildFeatures{
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Compose.composeCompilerVersion
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(project(Modules.coreUi))
    implementation(project(Modules.coreModel))
    implementation(project(Modules.coreData))

    implementation(Compose.activity)
    implementation(Compose.ui)
    implementation(Compose.uiToolingPreview)
    implementation(Compose.navigation)
    implementation(Compose.material)
    implementation(Compose.hiltNavigationCompose)

    implementation(Accompanist.pager)

    implementation(DaggerHilt.hiltAndroid)
    kapt(DaggerHilt.hiltCompiler)

    debugImplementation(Compose.debugTooling)

    testImplementation(Testing.junit4)

    androidTestImplementation(Testing.composeUiTest)
    androidTestImplementation(Testing.junitAndroidExt)
}