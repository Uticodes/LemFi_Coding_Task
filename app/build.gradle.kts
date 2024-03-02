import java.util.Properties

@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.kotlin.parcelize)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt)
}

android {
    namespace = "com.example.studentlist"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.studentlist"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    val localProperties = Properties()
    val localPropertiesFile = rootProject.file("local.properties")
    if (localPropertiesFile.exists()) {
        localProperties.load(localPropertiesFile.inputStream())
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            buildConfigField(
                "String",
                "BASE_URL",
                "\"${localProperties.getProperty("BASE_URL", "http://default.url/")}\""
            )
        }
        debug {
            buildConfigField(
                "String",
                "BASE_URL",
                "\"${localProperties.getProperty("BASE_URL", "http://default.url/")}\""
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    testOptions {
        unitTests.isIncludeAndroidResources = true
        unitTests.isReturnDefaultValues = true
    }
}

dependencies {

    implementation(libs.coreKtx)
    implementation(libs.lifecycle.runtime.ktx)
    implementation(libs.activity.compose)
    implementation(platform(libs.compose.bom))
    implementation(libs.ui)
    implementation(libs.ui.graphics)
    implementation(libs.ui.tooling.preview)
    implementation(libs.material3)

    implementation(libs.timber)
    implementation(libs.coil)
    implementation(libs.okHttp3)
    implementation(libs.okHttp3Logging)
    implementation(libs.lifecycleViewmodel)
    implementation(libs.lifecycleLivedata)
    implementation(libs.retrofit)
    implementation(libs.retrofitMoshiConverter)
    implementation(libs.moshi)
    implementation(libs.moshiCodegen)
    implementation(libs.roomKtx)
    implementation(libs.roomRuntime)
    implementation(libs.hiltAndroid)
    implementation(libs.hiltNavigation)
    implementation(libs.androidx.junit.ktx)

    ksp(libs.moshiCodegen)
    ksp(libs.hiltCompiler)
    ksp(libs.roomCompiler)


    testImplementation(libs.junit)
    testImplementation(libs.androidCore)
    testImplementation(libs.mockk)
    testImplementation(libs.coroutinesTest)
    testImplementation(libs.roomTesting)
    testImplementation(libs.kotlinTest)
    testImplementation(libs.androidxCoreKtx)
    testImplementation(libs.testRunnerVersion)
    testImplementation(libs.robolectric)
    testImplementation(libs.turbine)

    androidTestImplementation(libs.junit)
    androidTestImplementation(libs.androidxCoreKtx)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espressoCore)
    androidTestImplementation(libs.roomTesting)
//    androidTestImplementation(libs.androidCore)
    androidTestImplementation(platform(libs.compose.bom))
    androidTestImplementation(libs.ui.test.junit4)
    androidTestImplementation(libs.mockkAndroid)
//    androidTestImplementation(libs.testRunnerVersion)
    androidTestImplementation(libs.ui.test.manifest)

    debugImplementation(libs.ui.tooling)
    debugImplementation(libs.ui.test.manifest)
}