pipeline {
    agent any

    environment {
        PYTHON_ENV = 'greetings'
        TEST_ENV = 'test-framework'
    }

    stages {
        stage('Clone Repositories') {
            steps {
                echo 'Cloning repositories...'

                // Klonē Python mikroservisu
                git url: 'https://github.com/mtararujs/python-greetings', branch: 'main', changelog: false, poll: false, dir: "${PYTHON_ENV}"

                // Klonē testu sistēmu
                git url: 'https://github.com/mtararujs/course-js-api-framework', branch: 'main', changelog: false, poll: false, dir: "${TEST_ENV}"
            }
        }

        stage('Install Dependencies') {
            steps {
                script {
                    load('jenkins/install.groovy').call()
                }
            }
        }

        stage('Deploy to Dev') {
            steps {
                script {
                    load('jenkins/deploy.groovy').call('dev', '7001')
                }
            }
        }

        stage('Test on Dev') {
            steps {
                script {
                    load('jenkins/test.groovy').call('greetings_dev')
                }
            }
        }

        stage('Deploy to Staging') {
            steps {
                script {
                    load('jenkins/deploy.groovy').call('staging', '7002')
                }
            }
        }

        stage('Test on Staging') {
            steps {
                script {
                    load('jenkins/test.groovy').call('greetings_stg')
                }
            }
        }

        stage('Deploy to Preprod') {
            steps {
                script {
                    load('jenkins/deploy.groovy').call('preprod', '7003')
                }
            }
        }

        stage('Test on Preprod') {
            steps {
                script {
                    load('jenkins/test.groovy').call('greetings_preprod')
                }
            }
        }

        stage('Deploy to Prod') {
            steps {
                script {
                    load('jenkins/deploy.groovy').call('prod', '7004')
                }
            }
        }

        stage('Test on Prod') {
            steps {
                script {
                    load('jenkins/test.groovy').call('greetings_prod')
                }
            }
        }
    }
}
