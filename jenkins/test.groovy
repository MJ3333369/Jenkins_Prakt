def runTests(envTag) {
    echo "Installing Node.js dependencies..."
    bat 'npm install'

    echo "Running tests against environment: ${envTag}..."
    bat "npm run greetings ${envTag}"
}
return this
