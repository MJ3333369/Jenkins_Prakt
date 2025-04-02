def deploy(envName, port) {
    echo "Aptur esošo PM2 procesu, ja tāds eksistē..."
    bat "pm2 delete greetings-app-${envName} || exit 0"

    echo "Startē aplikāciju ar PM2..."
    bat """
    set PORT=${port}
    pm2 start app.py --name greetings-app-${envName} --interpreter python
    """

    bat "pm2 list"
}

return this
