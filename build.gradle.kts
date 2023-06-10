plugins {
    java
    `maven-publish`
    kotlin("jvm") version "1.8.21"
    id("net.nemerosa.versioning") version "3.0.0"
}

group = "fe.cached-urls"
version = versioning.info.tag ?: versioning.info.full

repositories {
    mavenCentral()
    maven(url = "https://jitpack.io")
}

dependencies {
    api("com.gitlab.grrfe:GSONKtExtensions:2.1.2")
    api("com.google.code.gson:gson:2.10.1")
    testImplementation(kotlin("test"))
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = project.group.toString()
            version = project.version.toString()

            from(components["java"])
        }
    }
}

tasks.withType<Jar> {
    exclude("dump_table.sh", "venv", "update_json.py")
}

tasks.test {
    useJUnitPlatform()
}
