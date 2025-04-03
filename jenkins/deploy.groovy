def deploy(envName, pm2Path, pythonPath, port) {
    bat """
        git clone https://github.com/mtararujs/python-greetings .
        ${pm2Path} delete greetings-app-${envName} || exit 0
        ${pm2Path} start app.py --name greetings-app-${envName} --interpreter ${pythonPath} -- --port ${port}
        ${pm2Path} list
    """
}
return this
