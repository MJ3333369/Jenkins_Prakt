pipeline {
    agent any

    environment {
        PYTHON_REPO = 'https://github.com/mtararujs/python-greetings'
        TEST_REPO = 'https://github.com/mtararujs/course-js-api-framework'
    }

    stages {
        stage('install-pip-deps') {
            steps {
                dir('python-greetings') {
                    git url: "${env.PYTHON_REPO}", changelog: false, poll: false
                    script {
                        load 'C:/Jenkins_Prakt/jenkins/install.groovy'
                    }
                }
            }
        }

        stage('deploy-to-dev') {
            steps {
                dir('python-greetings') {
                    script {
                        load 'C:/Jenkins_Prakt/jenkins/deploy.groovy'
                        deploy('dev', 7001)
                    }
                }
            }
        }

        stage('tests-on-dev') {
            steps {
                dir('course-js-api-framework') {
                    git url: "${env.TEST_REPO}", changelog: false, poll: false
                    script {
                        load 'C:/Jenkins_Prakt/jenkins/test.groovy'
                        runTests('greetings_dev')
                    }
                }
            }
        }
    }
}
