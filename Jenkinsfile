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
                    installScript('https://github.com/mtararujs/python-greetings')
                }
            }
        }

        stage('deploy-to-dev') {
            steps {
                script {
                    echo ">>> Using deploy.groovy for environment: dev"
                    deployScript.deploy('dev', 7001)
                }
            }
        }

        stage('tests-on-dev') {
            steps {
                script {
                    echo ">>> Running tests for dev"
                    testScript.runTests('dev')
                }
            }
        }

        stage('deploy-to-staging') {
            steps {
                script {
                    echo ">>> Using deploy.groovy for environment: staging"
                    deployScript.deploy('staging', 7002)
                }
            }
        }

        stage('tests-on-staging') {
            steps {
                script {
                    echo ">>> Running tests for staging"
                    testScript.runTests('staging')
                }
            }
        }

        stage('deploy-to-preprod') {
            steps {
                script {
                    echo ">>> Using deploy.groovy for environment: preprod"
                    deployScript.deploy('preprod', 7003)
                }
            }
        }

        stage('tests-on-preprod') {
            steps {
                script {
                    echo ">>> Running tests for preprod"
                    testScript.runTests('preprod')
                }
            }
        }

        stage('deploy-to-prod') {
            steps {
                script {
                    echo ">>> Using deploy.groovy for environment: prod"
                    deployScript.deploy('prod', 7004)
                }
            }
        }

        stage('tests-on-prod') {
            steps {
                script {
                    echo ">>> Running tests for prod"
                    testScript.runTests('prod')
                }
            }
        }
    }
}
