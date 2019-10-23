**Test run**

To run the tests, you need to define a suite (executable test suite)

example command: `mvn clean test -Dsuite=run_test`

**Report generation**

command: `mvn site` it will generate an allure report based on the results of the test run (result is here target/site/allure-maven-plugin/index.html)