def runTests(envName) {
    bat """
        git clone https://github.com/mtararujs/course-js-api-framework .
        cd course-js-api-framework
        npm install
        npm run greetings greetings_${envName}
    """
}
return this
