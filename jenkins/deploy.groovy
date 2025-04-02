def call(String envName, String port) {
    stage("Deploy to ${envName}") {
        echo "Stopping existing PM2 process for ${envName}..."
        bat "pm2 delete greetings-app-${envName} || exit 0"

        echo "Starting greetings-app-${envName} on port ${port}..."
        dir('greetings') {
            bat """
                set PORT=${port}
                pm2 start app.py --name greetings-app-${envName} --interpreter python
            """
        }
    }
}
