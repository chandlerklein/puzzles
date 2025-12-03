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
    implementation(libs.com.google.guava.guava)
    implementation(libs.commons.cli.commons.cli)
    implementation(libs.io.github.cdimascio.dotenv.java)
}
