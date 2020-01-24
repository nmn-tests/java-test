export PROJECTNAME=$(shell basename "$(PWD)")

.SILENT: ;               # no need for @

test: ## Clean, Compile, Test and Generate Coverage Report
	./mvnw clean compile test

report: test ## Opens coverage report
	open target/jacoco-ut/index.html

run: ## Runs the application
	./mvnw -q clean compile exec:java -Dexec.mainClass="io.github.namuan.App"

.PHONY: help
.DEFAULT_GOAL := help

help: Makefile
	echo
	echo " Choose a command run in "$(PROJECTNAME)":"
	echo
	@grep -E '^[a-zA-Z_-]+:.*?## .*$$' $(MAKEFILE_LIST) | sort | awk 'BEGIN {FS = ":.*?## "}; {printf "\033[36m%-30s\033[0m %s\n", $$1, $$2}'
	echo