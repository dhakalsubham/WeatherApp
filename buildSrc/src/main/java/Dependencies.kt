
/**
//   MyWeatherApp
//   Created by Subham Dhakal on 6/1/23.
 */

object Version{
    const val core = "1.7.0"
    const val compose_version = "1.4.0"
    const val lifecycle_runtime = "2.3.1"
    const val activity_compose = "1.3.1"
    const val junit = "4.13.2"
    const val ext_junit = "1.1.5"
    const val espresso = "3.5.1"
    const val retrofit = "2.9.0"
    const val okhttp = "4.9.1"
    const val gson = "2.9.0"
    const val androidAppcompat = "1.6.1"
    const val hilt = "2.44"
    const val androidXHilt = "1.0.0"
    const val composeNavigation = "2.5.0"
    const val gmsLocation = "21.0.1"
    const val accompanistPermission = "0.31.1-alpha"
    const val coil = "2.4.0"

}

object Deps{
    const val core = "androidx.core:core-ktx:${Version.core}"
}
object JetpackCompose{
    const val composeUI = "androidx.compose.ui:ui:${Version.compose_version}"
    const val composeMaterial = "androidx.compose.material:material:${Version.compose_version}"
    const val composeUITooling = "androidx.compose.ui:ui-tooling-preview:${Version.compose_version}"
    const val lifeCycleRuntimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${Version.lifecycle_runtime}"
    const val activityCompose = "androidx.activity:activity-compose:${Version.activity_compose}"
    const val composeNavigation = "androidx.navigation:navigation-compose:${Version.composeNavigation}"

}
object ImageLibrary{
    const val coil = "io.coil-kt:coil-compose:${Version.coil})"
    const val coilCompose = "io.coil-kt:coil-compose:2.4.0"
}
object GMS{
    const val playServicesLocation = "com.google.android.gms:play-services-location:${Version.gmsLocation}"
}
object Permissions {
    const val accompanistPermission = "com.google.accompanist:accompanist-permissions:${Version.accompanistPermission}"

}

object TestImplementation{
    const val junit = "junit:junit:${Version.junit}"
}
object AndroidTestImplementation{
    const val junit = "androidx.test.ext:junit:${Version.ext_junit}"
    const val espresso = "androidx.test.espresso:espresso-core:${Version.espresso}"
}
object ComposeAndroidTestImplementation{
    const val composeUITest = "androidx.compose.ui:ui-test-junit4:${Version.compose_version}"
}
object ComposeDebugImplementation{
    const val toolingUI = "androidx.compose.ui:ui-tooling:${Version.compose_version}"
    const val manifestTest = "androidx.compose.ui:ui-test-manifest:${Version.compose_version}"
}

object DaggerHilt {
    const val hilt = "com.google.dagger:hilt-android:${Version.hilt}"
    const val hiltCompiler = "com.google.dagger:hilt-android-compiler:${Version.hilt}"
    const val androidXHiltCompilerKapt = "androidx.hilt:hilt-compiler:${Version.androidXHilt}"
    const val hiltNavigation = "androidx.hilt:hilt-navigation-compose:${Version.androidXHilt}"


}

object AndroidX{
    const val appCompat = "androidx.appcompat:appcompat:${Version.androidAppcompat}"
    const val googleMaterial = "com.google.android.material:material:${Version.core}"


}

object Network {
    const val retrofit = "com.squareup.retrofit2:retrofit:${Version.retrofit}"
    const val okHttp = "com.squareup.okhttp3:okhttp"
    const val okhttpInterceptor = "com.squareup.okhttp3:logging-interceptor"
    const val okhttpBom = "com.squareup.okhttp3:okhttp-bom:${Version.okhttp}"
    const val gsonConvertor = "com.squareup.retrofit2:converter-gson:${Version.gson}"


}