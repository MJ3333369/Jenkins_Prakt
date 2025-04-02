def call(String workingDir) {
    echo ">>> IZMANTOJAM install.groovy"
    echo ">>> workingDir = ${workingDir}"
    dir(workingDir) {
        bat 'echo DEBUG: pašreizējais ceļš = %cd%'
        bat 'powershell -Command "& \\"C:\\Users\\Dell\\AppData\\Local\\Programs\\Python\\Python313\\Scripts\\pip.exe\\" install -r requirements.txt"'
    }
}
return this
