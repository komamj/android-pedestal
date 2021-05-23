rootProject.name = "android-pedestal"
include(":app")
include(":launcher")
include(":common")
include(":log")
include(":network")

project(":launcher").projectDir = file("business/launcher")
project(":common").projectDir = file("business/common")
project(":log").projectDir = file("platform/log")
project(":network").projectDir = file("platform/network")