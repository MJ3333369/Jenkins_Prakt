def deploy(String env, int port, String workingDir) {
    echo ">>> Using deploy.groovy for environment: ${env}"

    dir(workingDir) {
        // PM2 stop
        bat "C:\\Users\\Dell\\AppData\\Roaming\\npm\\pm2.cmd delete greetings-app-${env} || exit 0"

        // PM2 start
        bat "C:\\Users\\Dell\\AppData\\Roaming\\npm\\pm2.cmd start app.py --name greetings-app-${env} --interpreter C:\\Users\\Dell\\AppData\\Local\\Programs\\Python\\Python313\\python.exe -- --port ${port}"

        // Show PM2 processes
        bat "C:\\Users\\Dell\\AppData\\Roaming\\npm\\pm2.cmd list"
    }
}
return this
