def runTests(envTag) {
    echo ">>> Using test.groovy for: ${envTag}"
    dir('test-framework') {
        bat 'npm install'
        bat "npm run greetings ${envTag}"
    }
}
return this
