pipeline {
    agent any

    environment {
        PM2 = "C:\\Users\\Dell\\AppData\\Roaming\\npm\\pm2.cmd"
        PYTHON = "C:\\Users\\Dell\\AppData\\Local\\Programs\\Python\\Python313\\python.exe"
        PIP = "C:\\Users\\Dell\\AppData\\Local\\Programs\\Python\\Python313\\Scripts\\pip.exe"
    }

    stages {
        stage('prepare-scripts') {
            steps {
                script {
                    echo '>>> Loading deploy, install and test scripts'
                    deployScript = load 'jenkins/deploy.groovy'
                    installScript = load 'jenkins/install.groovy'
                    testScript = load 'jenkins/test.groovy'
                }
            }
        }

        stage('install-pip-deps') {
            steps {
                script {
                    echo '>>> Stage: Install dependencies'
                    installScript.install(PIP)
                }
            }
        }

        stage('deploy-to-dev') {
            steps {
                script {
                    echo '>>> Stage: Deploy to DEV'
                    deployScript.deploy("dev", PM2, PYTHON, 7001)
                }
            }
        }

        stage('tests-on-dev') {
            steps {
                script {
                    echo '>>> Stage: Test on DEV'
                    testScript.runTests("dev")
                }
            }
        }

        stage('deploy-to-staging') {
            steps {
                script {
                    echo '>>> Stage: Deploy to STAGING'
                    deployScript.deploy("staging", PM2, PYTHON, 7002)
                }
            }
        }

        stage('tests-on-staging') {
            steps {
                script {
                    echo '>>> Stage: Test on STAGING'
                    testScript.runTests("staging")
                }
            }
        }

        stage('deploy-to-preprod') {
            steps {
                script {
                    echo '>>> Stage: Deploy to PREPROD'
                    deployScript.deploy("preprod", PM2, PYTHON, 7003)
                }
            }
        }

        stage('tests-on-preprod') {
            steps {
                script {
                    echo '>>> Stage: Test on PREPROD'
                    testScript.runTests("preprod")
                }
            }
        }

        stage('deploy-to-prod') {
            steps {
                script {
                    echo '>>> Stage: Deploy to PROD'
                    deployScript.deploy("prod", PM2, PYTHON, 7004)
                }
            }
        }

        stage('tests-on-prod') {
            steps {
                script {
                    echo '>>> Stage: Test on PROD'
                    testScript.runTests("prod")
                }
            }
        }
    }
}
