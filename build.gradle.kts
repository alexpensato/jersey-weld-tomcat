// For Jdk 10+, use at least Jersey v2.27
val jerseyVersion = "2.33" // Dec 2020
val weldVersion = "3.1.6.Final" // Jan 2021

plugins {
	id("java")
    war
}

group = "org.pensatocode.sample"
version = "0.1.0"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    // Jersey libs
    implementation("org.glassfish.jersey.containers:jersey-container-servlet:${jerseyVersion}")
    implementation("org.glassfish.jersey.inject:jersey-hk2:${jerseyVersion}")
    implementation("org.glassfish.jersey.media:jersey-media-json-jackson:${jerseyVersion}")
    implementation("org.glassfish.jersey.ext.cdi:jersey-cdi1x-servlet:${jerseyVersion}")

    // Weld Uber Jar
    implementation("org.jboss.weld.servlet:weld-servlet-shaded:${weldVersion}")
}

tasks.war {
    from("src/main/resources/index.html")
    metaInf { from("src/main/resources/META-INF/context.xml") }
    archiveFileName.set("jersey-weld.war")
}