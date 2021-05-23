rootProject.name = "android-pedestal"
include(":app")
include(":launcher")
include(":log")
include(":network")
project(":launcher").projectDir = file("business/launcher")
project(":log").projectDir = file("platform/log")
project(":network").projectDir = file("platform/network")