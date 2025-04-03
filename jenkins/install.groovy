def call(String workingDir) {
    echo ">>> Using install.groovy"
    dir(workingDir) {
        bat 'echo Current directory: %cd%'
        bat '"C:\\Users\\Dell\\AppData\\Local\\Programs\\Python\\Python313\\Scripts\\pip.exe" install -r requirements.txt'
    }
}
return this
