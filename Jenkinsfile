pipeline {
    agent any

    environment {
        PYTHON_PATH = "C:\\Users\\Dell\\AppData\\Local\\Programs\\Python\\Python313\\python.exe"
        PM2_PATH = "C:\\Users\\Dell\\AppData\\Roaming\\npm\\pm2.cmd"
    }

    stages {
        stage('prepare-scripts') {
            steps {
                script {
                    echo ">>> Loading deploy, install and test scripts"
                    deployScript = load 'jenkins/deploy.groovy'
                    installScript = load 'jenkins/install.groovy'
                    testScript = load 'jenkins/test.groovy'
                }
            }
        }

        stage('install-pip-deps') {
            steps {
                script {
                    echo ">>> Stage: Install dependencies"
                    installScript.install('https://github.com/mtararujs/python-greetings')
                }
            }
        }

        stage('deploy-to-dev') {
            steps {
                script {
                    echo ">>> Deploying to dev"
                    deployScript.deploy('dev', 7001)
                }
            }
        }

        stage('tests-on-dev') {
            steps {
                script {
                    echo ">>> Running tests on dev"
                    testScript.runTests('dev')
                }
            }
        }

        stage('deploy-to-staging') {
            steps {
                script {
                    echo ">>> Deploying to staging"
                    deployScript.deploy('staging', 7002)
                }
            }
        }

        stage('tests-on-staging') {
            steps {
                script {
                    echo ">>> Running tests on staging"
                    testScript.runTests('staging')
                }
            }
        }

        stage('deploy-to-preprod') {
            steps {
                script {
                    echo ">>> Deploying to preprod"
                    deployScript.deploy('preprod', 7003)
                }
            }
        }

        stage('tests-on-preprod') {
            steps {
                script {
                    echo ">>> Running tests on preprod"
                    testScript.runTests('preprod')
                }
            }
        }

        stage('deploy-to-prod') {
            steps {
                script {
                    echo ">>> Deploying to prod"
                    deployScript.deploy('prod', 7004)
                }
            }
        }

        stage('tests-on-prod') {
            steps {
                script {
                    echo ">>> Running tests on prod"
                    testScript.runTests('prod')
                }
            }
        }
    }
}
