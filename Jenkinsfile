def install = load 'jenkins/install.groovy'
def deploy = load 'jenkins/deploy.groovy'
def test = load 'jenkins/test.groovy'

pipeline {
    agent any

    environment {
        APP_REPO = 'https://github.com/mtararujs/python-greetings'
        TEST_REPO = 'https://github.com/mtararujs/course-js-api-framework'
    }

    stages {
        stage('install-pip-deps') {
            steps {
                script {
                    echo "Klonē Python aplikācijas repozitoriju..."
                    dir('python-greetings') {
                        git branch: 'main', url: "${APP_REPO}"
                        echo "Uzstāda Python atkarības..."
                        install.call('python-greetings')
                    }
                }
            }
        }

        stage('deploy-to-dev') {
            steps {
                script {
                    echo "Izvieto uz DEV vides porta 7001..."
                    dir('python-greetings') {
                        git branch: 'main', url: "${APP_REPO}"
                        deploy.deploy('dev', 7001)
                    }
                }
            }
        }

        stage('tests-on-dev') {
            steps {
                script {
                    echo "Testēšana DEV vidē..."
                    dir('course-js-api-framework') {
                        git branch: 'main', url: "${TEST_REPO}"
                        test.runTests('greetings_dev')
                    }
                }
            }
        }

        stage('deploy-to-staging') {
            steps {
                script {
                    echo "Izvieto uz STAGING vides porta 7002..."
                    dir('python-greetings') {
                        git branch: 'main', url: "${APP_REPO}"
                        deploy.deploy('staging', 7002)
                    }
                }
            }
        }

        stage('tests-on-staging') {
            steps {
                script {
                    echo "Testēšana STAGING vidē..."
                    dir('course-js-api-framework') {
                        git branch: 'main', url: "${TEST_REPO}"
                        test.runTests('greetings_staging')
                    }
                }
            }
        }

        stage('deploy-to-preprod') {
            steps {
                script {
                    echo "Izvieto uz PREPROD vides porta 7003..."
                    dir('python-greetings') {
                        git branch: 'main', url: "${APP_REPO}"
                        deploy.deploy('preprod', 7003)
                    }
                }
            }
        }

        stage('tests-on-preprod') {
            steps {
                script {
                    echo "Testēšana PREPROD vidē..."
                    dir('course-js-api-framework') {
                        git branch: 'main', url: "${TEST_REPO}"
                        test.runTests('greetings_preprod')
                    }
                }
            }
        }

        stage('deploy-to-prod') {
            steps {
                script {
                    echo "Izvieto uz PROD vides porta 7004..."
                    dir('python-greetings') {
                        git branch: 'main', url: "${APP_REPO}"
                        deploy.deploy('prod', 7004)
                    }
                }
            }
        }

        stage('tests-on-prod') {
            steps {
                script {
                    echo "Testēšana PROD vidē..."
                    dir('course-js-api-framework') {
                        git branch: 'main', url: "${TEST_REPO}"
                        test.runTests('greetings_prod')
                    }
                }
            }
        }
    }
}
