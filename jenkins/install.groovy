def install(String repoUrl) {
    bat "git clone ${repoUrl}"
    bat "dir python-greetings"
    bat "\"${env.PYTHON_PATH}\" -m pip install -r python-greetings/requirements.txt"
}
