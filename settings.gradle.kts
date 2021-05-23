rootProject.name = "android-pedestal"
include(":app")
include(":log")
include(":network")
project(":log").projectDir = file("platform/log")
project(":network").projectDir = file("platform/network")