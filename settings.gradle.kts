pluginManagement {
    repositories {
        // Other dependencies
        mavenLocal()
        maven {
            url = uri("https://multirepo-oab.si.fr.intraorange/maven-PRACTICE_ANDROID_MDS-releases")
            name = "obsReleaseArtifactory"
            credentials(HttpHeaderCredentials::class)
            authentication {
                create<HttpHeaderAuthentication>("header")
            }
        }
        maven {
            url = uri("https://multirepo-oab.si.fr.intraorange/maven-PRACTICE_ANDROID_MDS-snapshots")
            name = "obsSnapshotsArtifactory"
            // Not working with Gradle 8, credentials are as of now put directly in the credential block
            credentials(HttpHeaderCredentials::class)
            authentication {
                create<HttpHeaderAuthentication>("header")
            }
        }
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "ArchHelloWorld"
include(":app")
include(":coretesting")
include(":data")
include(":designsystem")
include(":featureplaceholder")
