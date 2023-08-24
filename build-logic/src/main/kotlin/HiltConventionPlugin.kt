import com.locamos.example.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class HiltConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                // trong hướng dẫn của google sẽ là "kotlin("kapt")"
                // về cơ bản kotlin("") là 1 extension function
                // fun PluginDependenciesSpec.kotlin(module: String): PluginDependencySpec =
                // id("org.jetbrains.kotlin.$module")
                // nên ở đây sẽ thêm phần đầu còn thiếu thay vì kotlin("")
                apply("org.jetbrains.kotlin.kapt")
                apply("com.google.dagger.hilt.android")
            }

            dependencies {
                add("implementation", libs.findLibrary("hilt.android").get())
                add("kapt", libs.findLibrary("hilt.android.compiler").get())
            }
        }
    }
}