plugins {
    kotlin("jvm")
}

group = "com.luc"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    api(project(":common"))

    val koinVersion = "3.1.3"
    api( "io.insert-koin:koin-core:$koinVersion")
    api ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2")

    implementation(kotlin("stdlib"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}