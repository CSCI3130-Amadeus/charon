
#!/usr/bin/env bash

# This was taken from https://github.com/Artur-/testbench-travis/blob/master/.travis.script.sh
# This is to allow travis to use our vaadin developer license.

if [ "$TRAVIS_PULL_REQUEST" != "false" ] && [ "${TRAVIS_BRANCH}" == "master" ] && [ "$TRAVIS_SECURE_ENV_VARS" == "true" ]
then
	# Pull request for master with secure variables available
	mvn -B -e -V -Dvaadin.testbench.developer.license=$TESTBENCH_LICENSE clean verify
else
	# Something else than a pull request inside the repository
	mvn -B -e -V -Dvaadin.testbench.developer.license=$TESTBENCH_LICENSE clean verify
fi
