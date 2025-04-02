def call(String workingDir) {
    dir(workingDir) {
        echo "Instalē Python bibliotēkas..."
        bat 'pip install -r requirements.txt'
    }
}

return this
