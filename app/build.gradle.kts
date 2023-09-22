plugins {
    application
}

group = "site.lifix"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.google.code.gson:gson:2.10.1")
    implementation("com.google.code.findbugs:jsr305:3.0.2")
    implementation("io.github.spair:imgui-java-app:1.86.10")
    implementation("org.java-websocket:Java-WebSocket:1.5.4")
    implementation("org.lwjgl:lwjgl-stb:3.3.1")
    implementation("org.lwjgl:lwjgl-stb:3.3.1:natives-linux")
    implementation("org.lwjgl:lwjgl-stb:3.3.1:natives-macos")
    implementation("org.lwjgl:lwjgl-stb:3.3.1:natives-windows")
    implementation("org.projectlombok:lombok:1.18.28")
    annotationProcessor("org.projectlombok:lombok:1.18.28")
}

application {
    // Define the main class for the application.
    mainClass.set("site.lifix.jiscord.Main")
}
