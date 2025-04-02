def call(String workingDir) {
    dir(workingDir) {
        echo "Instalē Python bibliotēkas..."
        bat 'powershell -Command "& \\"C:\\Users\\Dell\\AppData\\Local\\Programs\\Python\\Python313\\Scripts\\pip.exe\\" install -r requirements.txt"'
    }
}

return this
