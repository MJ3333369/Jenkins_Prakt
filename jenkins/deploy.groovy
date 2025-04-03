def deploy(String envName, int port) {
    def repo = "https://github.com/mtararujs/python-greetings"
    bat "git clone ${repo}"
    bat "${env.PM2_PATH} delete greetings-app-${envName} & EXIT /B 0"
    bat "${env.PM2_PATH} start python-greetings/app.py --name greetings-app-${envName} --interpreter ${env.PYTHON_PATH} -- --port ${port}"
}
