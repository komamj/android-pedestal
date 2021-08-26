rootProject.name = "android-pedestal"
include(":app")
// 业务层
include(":launcher")
project(":launcher").projectDir = file("business/launcher")
include(":common")
project(":common").projectDir = file("business/common")
// 中台层
include(":auth")
project(":auth").projectDir = file("zhongtai/auth")
include(":auth_api")
project(":auth_api").projectDir = file("zhongtai/auth_api")
// platform 层
include(":log")
project(":log").projectDir = file("platform/log")
include(":network")
project(":network").projectDir = file("platform/network")
