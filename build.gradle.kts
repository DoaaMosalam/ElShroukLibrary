plugins {
    kotlin("jvm") version "1.9.23"
    kotlin("kapt") version "1.9.23"
}

group = "doaa.mosallam.book"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    google()
}

dependencies {
//    implementation("androidx.room:room-runtime:2.6.1")
//    kapt("androidx.room:room-compiler:2.6.1")
//    implementation("androidx.room:room-common:2.6.1")
//    implementation("androidx.room:room-ktx:2.6.1")
//
//    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.6.0-m1")


    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}