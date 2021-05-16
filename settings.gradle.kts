rootProject.name = "android-pedestal"
include(":app")
include(":log")

project(":log").projectDir = file("platform/log")
