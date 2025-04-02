def call(String workingDir, String envName, String port) {
    dir(workingDir) {
        echo "Deploying to ${envName} on port ${port}..."
        bat "pm2 delete greetings-app-${envName} || exit 0"
        bat "set PORT=${port} && pm2 start app.py --name greetings-app-${envName} --interpreter python"
    }
}
