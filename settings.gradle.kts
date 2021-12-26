pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }

}
rootProject.name = "LucManager"

include(":data")
include("common")
include("domain")
include("presentation")
include("ui")
