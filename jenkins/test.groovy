def run(String env) {
    echo ">>> Using test.groovy for environment: ${env}"

    def repo = "https://github.com/mtararujs/course-js-api-framework"

    // Nodrosina, ka katrs posms sak ar tiru mapi
    bat "rmdir /s /q test-framework || exit 0"

    // Klone testesanas framework repozitoriju
    bat "git clone ${repo} test-framework"

    dir("test-framework") {
        bat "npm install"
        bat "npm run greetings greetings_${env == 'staging' ? 'stg' : env}"
    }
}
return this
