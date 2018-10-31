object Versions {

    //=============================================
    //               APP VERSIONS
    //=============================================

    const val versionCode = 1
    const val compileSdkVersion = 28
    const val minSdkVersion = 15
    const val targetSdkVersion = 28

    //______________________________

    const val kotlinVersion = "1.2.20"

    //classpath dependencies
    const val supportCompatPluginVersion = "3.0.1"

    //google
    const val supportLibrary = "27.0.2"
    const val archComponents = "1.0.0"
    const val archPagingVersion = "1.0.1"

    //dagger
    const val daggerVersion = "2.15"

    //Rx
    const val rxJavaVersion = "2.1.10"
    const val rxAndroidVersion = "2.0.2"

    //OkHttp
    const val okHttpVersion = "3.10.0"
    const val gsonVersion = "2.8.2"

    //Retrofit
    const val retrofitVersion = "2.3.0"

    //Commons
    const val picassoVersion = "2.71828"
    const val toastyVersion = "1.2.8"
    const val constraintLayoutVersion = "1.1.3"
    const val glideVersion = "4.8.0"

    //Testing
    const val testingSupportVersion = "1.0.1"
    const val assertjAndroid = "1.1.1"
    const val jUnit = "4.12"
    const val mockito = "2.10.0"
    const val assertj = "2.9.0"
    const val espresso = "3.0.1"

    //=============================================
    //               TEST VERSIONS
    //=============================================
}

object ClasspathxDependencies {

    const val gradle = "com.android.tools.build:gradle:${Versions.supportCompatPluginVersion}"
    const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinVersion}"
}

object Dependencies {

    //=============================================
    //             APP DEPENDENCIES
    //=============================================

    //kotlin
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jre7:${Versions.kotlinVersion}"
    const val kotlinPlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinVersion}"

    //support
    const val supportCompat = "com.android.support:appcompat-v7:${Versions.supportLibrary}"
    const val supportDesign = "com.android.support:design:${Versions.supportLibrary}"
    const val supportAnnotations = "com.android.support:support-annotations:${Versions.supportLibrary}"

    //Architecture components
    const val archRuntime = "android.arch.lifecycle:runtime:${Versions.archComponents}"
    const val archExtensions = "android.arch.lifecycle:extensions:${Versions.archComponents}"
    const val archCompiler = "android.arch.lifecycle:compiler:${Versions.archComponents}"
    const val archPagingRuntime = "android.arch.paging:runtime:${Versions.archPagingVersion}"
    const val archPagingRxjava2 = "android.arch.paging:rxjava2:${Versions.archPagingVersion}"

    //dagger
    const val dagger = "com.google.dagger:dagger:${Versions.daggerVersion}"
    const val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.daggerVersion}"
    const val daggerAndroid = "com.google.dagger:dagger-android:${Versions.daggerVersion}"
    const val daggerAndroidSupport = "com.google.dagger:dagger-android-support:${Versions.daggerVersion}"
    const val daggerAndroidCompiler = "com.google.dagger:dagger-android-processor:${Versions.daggerVersion}"

    //rxJava
    const val rxandroid = "io.reactivex.rxjava2:rxandroid:${Versions.rxAndroidVersion}"
    const val rxjava = "io.reactivex.rxjava2:rxjava:${Versions.rxJavaVersion}"

    //okHttp
    const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okHttpVersion}"
    const val okhttpLogging = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttpVersion}"
    const val gson = "com.google.code.gson:gson:${Versions.gsonVersion}"

    //retrofit
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
    const val retrofitGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofitVersion}"
    const val retrofitRxJavaAdapter = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofitVersion}"

    //common
    const val picasso = "com.squareup.picasso:picasso:${Versions.picassoVersion}"
    const val toasty = "com.github.GrenderG:Toasty:${Versions.toastyVersion}"
    const val cardView = "com.android.support:cardview-v7:${Versions.supportLibrary}"
    const val constraintLayout = "com.android.support.constraint:constraint-layout:${Versions.constraintLayoutVersion}"
    const val glide = "com.github.bumptech.glide:glide:${Versions.glideVersion}"

    //=============================================
    //             TEST DEPENDENCIES
    //=============================================

    //kotlin
    const val kotlinTest = "org.jetbrains.kotlin:kotlin-test-junit:${Versions.kotlinVersion}"

    // Unit testing
    const val junit = "junit:junit:${Versions.jUnit}"
    const val assertJ = "org.assertj:assertj-core:${Versions.assertj}"

    // Espresso UI Testing dependencies
    const val espressoCore = "com.android.support.test.espresso:espresso-core:${Versions.espresso}"
    const val espressoContrib = "com.android.support.test.espresso:espresso-contrib:${Versions.espresso}"
    const val espressoIntents = "com.android.support.test.espresso:espresso-intents:${Versions.espresso}"
    const val espressoIdlingResource = "com.android.support.test.espresso:espresso-idling-resource:${Versions.espresso}"
    const val espressoIdlingConcurrent = "com.android.support.test.espresso.idling:idling-concurrent:${Versions.espresso}"
    const val espressoIdlingNet = "com.android.support.test.espresso.idling:idling-net:${Versions.espresso}"

    // Android Testing Support Library's runner and rules
    const val testRunner = "com.android.support.test:runner:${Versions.testingSupportVersion}"
    const val testRules = "com.android.support.test:rules:${Versions.testingSupportVersion}"

    // Arch Components testing
    const val archCoreTesting = "android.arch.core:core-testing:${Versions.archComponents}"
    const val mockito = "org.mockito:mockito-inline:${Versions.mockito}"
    const val assertjAndroid = "com.squareup.assertj:assertj-android:${Versions.assertjAndroid}"
}