import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
    application
    checkstyle
    id("io.freefair.lombok") version "8.4"
    id("com.github.johnrengelman.shadow") version "8.1.1"
    jacoco
}

application {
    mainClass.set("hexlet.code.App")
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    //implementation("com.h2database:h2:2.2.224")
    implementation("com.h2database:h2:2.2.220")
    implementation("org.postgresql:postgresql:42.7.1")

    implementation("com.zaxxer:HikariCP:5.1.0")

    implementation("io.javalin:javalin:6.1.3")
    implementation("io.javalin:javalin-testtools:6.1.6")
    implementation("io.javalin:javalin-rendering:6.1.3")


    implementation("org.slf4j:slf4j-simple:2.0.7")

    //шаблон

    implementation("gg.jte:jte:3.1.9")

    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")


    testImplementation("org.assertj:assertj-core:3.25.3")

}

tasks.test {
    useJUnitPlatform()
    testLogging {
        exceptionFormat = TestExceptionFormat.FULL
        events = mutableSetOf(TestLogEvent.FAILED, TestLogEvent.PASSED, TestLogEvent.SKIPPED)
        // showStackTraces = true
        // showCauses = true
        showStandardStreams = true
    }
    finalizedBy(tasks.jacocoTestReport)

}

tasks.jacocoTestReport {
    dependsOn(tasks.test)// tests are required to run before generating the report
            reports {
                xml.required = true
            }
}
