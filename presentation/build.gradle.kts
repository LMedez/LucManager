plugins {
    kotlin("jvm")
}

group = "com.luc"
version = "1.0"

repositories {
    mavenCentral()
}


dependencies {
    implementation(project(":domain"))

    implementation(kotlin("stdlib"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}