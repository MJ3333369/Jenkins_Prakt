def call(String workingDir) {
    echo ">>> Using install.groovy"
    dir(workingDir) {
        bat 'echo Current directory: %cd%'
        bat 'pip install -r requirements.txt'
    }
}
return this
