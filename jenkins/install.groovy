def call() {
    stage('Install Dependencies') {
        echo 'Installing Python dependencies...'

        dir('greetings') {
            bat 'pip install -r requirements.txt'
        }
    }
}
