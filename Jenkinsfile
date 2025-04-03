pipeline {
    agent any

    environment {
        WORKDIR = "python-greetings"
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
                    deleteDir()
                    installScript(WORKDIR)
                }
            }
        }

        stage('deploy-to-dev') {
            steps {
                script {
                    deployScript.deploy("dev", 7001, WORKDIR)
                }
            }
        }

        stage('tests-on-dev') {
            steps {
                script {
                    testScript.run("dev")
                }
            }
        }

        stage('deploy-to-staging') {
            steps {
                script {
                    deployScript.deploy("staging", 7002, WORKDIR)
                }
            }
        }

        stage('tests-on-staging') {
            steps {
                script {
                    testScript.run("staging")
                }
            }
        }

        stage('deploy-to-preprod') {
            steps {
                script {
                    deployScript.deploy("preprod", 7003, WORKDIR)
                }
            }
        }

        stage('tests-on-preprod') {
            steps {
                script {
                    testScript.run("preprod")
                }
            }
        }

        stage('deploy-to-prod') {
            steps {
                script {
                    deployScript.deploy("prod", 7004, WORKDIR)
                }
            }
        }

        stage('tests-on-prod') {
            steps {
                script {
                    testScript.run("prod")
                }
            }
        }
    }
}
