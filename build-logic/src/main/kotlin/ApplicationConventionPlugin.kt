import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import com.locamos.example.configureBuildType
import com.locamos.example.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class ApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {5
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
            }
            extensions.configure<BaseAppModuleExtension>() {
                configureKotlinAndroid(this)
                configureBuildType(this)
                buildFeatures {
                    buildConfig = true
                }
            }
        }
    }
}