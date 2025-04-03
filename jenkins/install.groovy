def call(String repoUrl) {
    bat "echo Current directory: %CD%"
    bat "git clone ${repoUrl}"
    bat "\"${env.PYTHON_PATH}\" -m pip install -r python-greetings/requirements.txt"
}
