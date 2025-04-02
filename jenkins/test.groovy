def call(String envTag) {
    stage("Run Tests on ${envTag}") {
        dir('test-framework') {
            echo 'Installing Node.js dependencies...'
            bat 'npm install'

            echo "Running tests against ${envTag}..."
            bat "npm run greetings ${envTag}"
        }
    }
}
