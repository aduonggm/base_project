import com.android.build.api.dsl.LibraryExtension
import com.locamos.example.configureBuildType
import com.locamos.example.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class LibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
            }
            extensions.configure<LibraryExtension> {
                configureKotlinAndroid(this)
                configureBuildType(this)
                buildFeatures {
                    buildConfig = true
                }
            }
        }
    }
}