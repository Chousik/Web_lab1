plugins {
    id("java")
    application
}

group = "org.chousik"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(files("src/main/resources/libs/fastCGI.jar"))
    implementation("com.google.code.gson:gson:2.11.0")
}
tasks {
    val fatJar =
        register<Jar>("fatJar") {
            dependsOn.addAll(listOf("compileJava", "processResources"))
            archiveClassifier.set("standalone")
            duplicatesStrategy = DuplicatesStrategy.EXCLUDE
            manifest { attributes(mapOf("Main-Class" to "org.chousik.Main")) }
            val sourcesMain = sourceSets.main.get()
            val contents =
                configurations.runtimeClasspath.get()
                    .map { if (it.isDirectory) it else zipTree(it) } +
                        sourcesMain.output
            from(contents)
        }
    build {
        dependsOn(fatJar)
    }
}
