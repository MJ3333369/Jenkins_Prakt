def runTests(envTag) {
    echo "Instalē Node.js bibliotēkas testēšanai..."
    bat 'npm install'

    echo "Veic testus pret vidi: ${envTag}..."
    bat "npm run greetings ${envTag}"
}

return this
