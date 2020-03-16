load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

RULES_JVM_EXTERNAL_TAG = "2.5"

RULES_JVM_EXTERNAL_SHA = "249e8129914be6d987ca57754516be35a14ea866c616041ff0cd32ea94d2f3a1"

http_archive(
    name = "rules_jvm_external",
    sha256 = RULES_JVM_EXTERNAL_SHA,
    strip_prefix = "rules_jvm_external-%s" % RULES_JVM_EXTERNAL_TAG,
    url = "https://github.com/bazelbuild/rules_jvm_external/archive/%s.zip" % RULES_JVM_EXTERNAL_TAG,
)

load("@rules_jvm_external//:defs.bzl", "maven_install")

maven_install(
    artifacts = [
        "junit:junit:4.12",
        "com.google.guava:guava:28.0-jre",
        "com.google.inject:guice:4.2.2",
        "org.jboss.resteasy:resteasy-jaxrs:4.0.0.Beta5",
        "org.jboss.resteasy:resteasy-guice:4.0.0.Beta5",
        "org.jboss.resteasy:resteasy-jackson2-provider:4.0.0.Beta5",
        "org.eclipse.jetty:jetty-server:9.4.18.v20190429",
        "org.eclipse.jetty:jetty-servlet:9.4.18.v20190429",
        "com.auth0:java-jwt:3.10.0",
        "org.bouncycastle:bcprov-jdk15on:1.59",
        "org.apache.commons:commons-lang3:3.9",
        "com.amazonaws:aws-java-sdk-dynamodb:1.11.745"
    ],
    fetch_sources = True,
    repositories = [
        "https://jcenter.bintray.com/",
        "https://repo1.maven.org/maven2/",
    ],
)
