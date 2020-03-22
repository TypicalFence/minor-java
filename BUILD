load("@rules_java//java:defs.bzl", "java_binary", "java_library", "java_test")

package(default_visibility = ["//visibility:public"])

java_library(
    name = "lib",
    srcs = glob(["src/main/java/moe/zaun/prismriver/minor/**/*.java"]),
    deps = [
        "@maven//:com_amazonaws_aws_java_sdk_dynamodb",
        "@maven//:com_auth0_java_jwt",
        "@maven//:com_fasterxml_jackson_core_jackson_annotations",
        "@maven//:com_google_guava_guava",
        "@maven//:com_google_inject_guice",
        "@maven//:javax_servlet_javax_servlet_api",
        "@maven//:org_apache_commons_commons_lang3",
        "@maven//:org_bouncycastle_bcprov_jdk15on",
        "@maven//:org_eclipse_jetty_jetty_server",
        "@maven//:org_eclipse_jetty_jetty_servlet",
        "@maven//:org_jboss_resteasy_resteasy_guice",
        "@maven//:org_jboss_resteasy_resteasy_jackson2_provider",
        "@maven//:org_jboss_resteasy_resteasy_jaxrs",
        "@maven//:org_jboss_spec_javax_ws_rs_jboss_jaxrs_api_2_1_spec",
    ],
)

java_binary(
    name = "app",
    main_class = "moe.zaun.prismriver.minor.App",
    resources = [
        "src/main/resources/WEB-INF/web.xml",
    ],
    runtime_deps = [":lib"],
)

java_test(
    name = "tests",
    srcs = glob(["src/test/java/moe/zaun/prismriver/minor/**/*.java"]),
    test_class = "moe.zaun.prismriver.minor.AllTests",
    deps = [
        ":lib",
        "@maven//:com_google_guava_guava",
        "@maven//:junit_junit",
    ],
)
