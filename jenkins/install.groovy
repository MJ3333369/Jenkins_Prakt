def call(String workingDir) {
    dir(workingDir) {
        echo "Installing Python dependencies from ${workingDir}..."
        bat 'pip install -r requirements.txt'
    }
}

return this
