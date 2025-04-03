def runTests(String envName) {
    def repo = "https://github.com/mtararujs/course-js-api-framework"
    bat "git clone ${repo}"
    bat "cd course-js-api-framework && npm install"
    bat "cd course-js-api-framework && npm run greetings greetings_${envName}"
}
