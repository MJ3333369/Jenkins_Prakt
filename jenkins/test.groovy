def run(String env) {
    echo ">>> Using test.groovy for environment: ${env}"

    def repo = "https://github.com/mtararujs/course-js-api-framework"

    // Nodrošina, ka katrā posmā sāk ar tīru mapi
    bat "rmdir /s /q test-framework || exit 0"

    // Klonē testēšanas framework repozitoriju
    bat "git clone ${repo} test-framework"

    dir("test-framework") {
        bat "npm install"
        bat "npm run greetings greetings_${env}"
    }
}
return this
