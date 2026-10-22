// Fix for AGP AndroidLocationsException when both ANDROID_PREFS_ROOT and ANDROID_USER_HOME are set in system environment
try {
    val processEnv = Class.forName("java.lang.ProcessEnvironment")
    val peField = processEnv.getDeclaredField("theEnvironment").apply { isAccessible = true }
    @Suppress("UNCHECKED_CAST")
    val envMap = peField.get(null) as? MutableMap<String, String>
    envMap?.remove("ANDROID_PREFS_ROOT")

    val ciEnvField = processEnv.getDeclaredField("theCaseInsensitiveEnvironment").apply { isAccessible = true }
    @Suppress("UNCHECKED_CAST")
    val ciEnvMap = ciEnvField.get(null) as? MutableMap<String, String>
    ciEnvMap?.remove("ANDROID_PREFS_ROOT")
} catch (_: Throwable) {
}

pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Tenant Management Sytem"
include(":app")
 