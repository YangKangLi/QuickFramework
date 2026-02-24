plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.mavenPublish)
}

android {
    namespace = "com.yangkl.quick.library"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    //noinspection UseTomlInstead
    implementation("com.tencent:mmkv:2.3.0")
    //noinspection UseTomlInstead
    implementation("com.blankj:utilcodex:1.31.1")
    //noinspection UseTomlInstead
    implementation("com.github.kongzue.DialogX:DialogX:0.0.49")
}

group = "com.github.yangkangli"
version = "1.0.0"
afterEvaluate {
    publishing {
        publications {
            // 创建名为 "release" 的发布项
            create<MavenPublication>("release") {
                // 从 release 组件中获取 AAR
                from(components["release"])

                // 配置 groupId, artifactId, version
                groupId = group.toString()
                artifactId = "library" // 通常与 module 名一致
                version = version          // 与将要创建的 Git tag 一致
            }
        }
    }
}