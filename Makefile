.Phony: app run test clean app_deploy

app:
	bazel build app

app_deploy:
	bazel build app_deploy.jar

run:
	bazel run app

test:
	bazel run tests

clean:
	bazel clean
