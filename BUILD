load("@rules_java//java:defs.bzl", "java_binary", "java_library", "java_test")

package(default_visibility = ["//visibility:public"])

java_library(
    name = "lib",
    srcs = glob(["src/main/java/moe/zaun/prismriver/minor/**/*.java"]),
    deps = [
            "@maven//:com_google_guava_guava",
            "@maven//:com_google_inject_guice",
            "@maven//:org_jboss_resteasy_resteasy_jaxrs",
            "@maven//:org_jboss_resteasy_resteasy_guice",
            "@maven//:org_jboss_spec_javax_ws_rs_jboss_jaxrs_api_2_1_spec",
            "@maven//:org_eclipse_jetty_jetty_server",
            "@maven//:org_eclipse_jetty_jetty_servlet",
            "@maven//:javax_servlet_javax_servlet_api",
            "@maven//:com_auth0_java_jwt",
            "@maven//:org_bouncycastle_bcprov_jdk15on"
    ],
)

java_binary(
    name = "app",
    main_class = "moe.zaun.prismriver.minor.App",
    runtime_deps = [":lib"],
    resources = [
            "src/main/resources/WEB-INF/web.xml"
    ]
)

java_test(
    name = "tests",
    srcs = glob(["src/test/java/moe/zaun/prismriver/minor/**/*.java"]),
    test_class = "moe.zaun.prismriver.minor.TestApp",
    deps = [
        ":lib",
        "@maven//:com_google_guava_guava",
        "@maven//:junit_junit",
    ],
)
