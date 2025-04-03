def deploy(envName, port) {
    echo ">>> Using deploy.groovy for environment: ${envName}"
    dir('.') {
        bat("""C:\\Users\\Dell\\AppData\\Roaming\\npm\\pm2.cmd delete greetings-app-${envName} || exit 0""")
        bat("""C:\\Users\\Dell\\AppData\\Roaming\\npm\\pm2.cmd start app.py --name greetings-app-${envName} --interpreter C:\\Users\\Dell\\AppData\\Local\\Programs\\Python\\Python313\\python.exe -- --port ${port}""")
        bat("""C:\\Users\\Dell\\AppData\\Roaming\\npm\\pm2.cmd list""")
    }
}
return this
