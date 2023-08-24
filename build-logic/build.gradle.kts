plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}


dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
}


gradlePlugin {
    plugins {
        register("applicationConventionPlugin") {
            id = "locamos-android-application"
            implementationClass = "ApplicationConventionPlugin"
        }
        register("libraryConventionPlugin") {
            id = "locamos-android-library"
            implementationClass = "LibraryConventionPlugin"
        }
        register("hiltConventionPlugin") {
            id = "locamos-hilt"
            implementationClass = "HiltConventionPlugin"
        }
    }
}

