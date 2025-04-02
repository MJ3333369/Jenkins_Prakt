def call(String workingDir, String envTag) {
    dir(workingDir) {
        echo "Installing Node.js dependencies..."
        bat 'npm install'
        echo "Running tests against environment ${envTag}..."
        bat "npm run greetings ${envTag}"
    }
}
