plugins { java }

group = "com.chandler"
description = "puzzles"
version = "1.0"
java.sourceCompatibility = JavaVersion.VERSION_25

repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    implementation("com.google.guava:guava:33.5.0-jre")
    implementation("commons-cli:commons-cli:1.11.0")
    implementation("io.github.cdimascio:dotenv-java:3.2.0")
    implementation("org.jgrapht:jgrapht-core:1.5.2")
}
