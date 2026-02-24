pluginManagement {
    repositories {
        maven {
            url = uri("https://www.jitpack.io")
        }
        maven {
            url = uri("https://maven.aliyun.com/repository/public") // 阿里云公共仓库
        }
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
dependencyResolutionManagement {

    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        maven {
            url = uri("https://www.jitpack.io")
        }
        maven {
            url = uri("https://maven.aliyun.com/repository/public") // 阿里云公共仓库
        }
        google()
        mavenCentral()
    }
}

rootProject.name = "QuickFramework"
include(":app")
include(":library")
