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

    implementation ("com.google.firebase:firebase-admin:8.1.0")
    implementation ("org.jetbrains.kotlin:kotlin-stdlib")
    testImplementation ("org.junit.jupiter:junit-jupiter-api:5.7.0")
    testRuntimeOnly ("org.junit.jupiter:junit-jupiter-engine:5.7.0")
}

