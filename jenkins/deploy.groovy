def deploy(envName, port) {
    echo ">>> Using deploy.groovy for environment: ${envName}"
    dir('greetings') {
        bat "pm2 delete greetings-app-${envName} || exit 0"
        bat "pm2 start app.py --name greetings-app-${envName} --interpreter python -- --port ${port}"
        bat "pm2 list"
    }
}
return this
