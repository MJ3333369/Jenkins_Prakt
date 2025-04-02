def deploy(envName, port) {
    echo "Stopping existing PM2 process (if any)..."
    bat "pm2 delete greetings-app-${envName} || exit 0"

    echo "Starting app with PM2..."
    bat """
    set PORT=${port}
    pm2 start app.py --name greetings-app-${envName} --interpreter python
    """
    bat "pm2 list"
}
return this
