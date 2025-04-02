pipeline {
    agent any

    environment {
        PYTHON_REPO = 'https://github.com/mtararujs/python-greetings'
        TEST_REPO = 'https://github.com/mtararujs/course-js-api-framework'
    }

    stages {
        stage('install-pip-deps') {
            steps {
                checkout scm
                git url: "${PYTHON_REPO}", changelog: false, poll: false
                script {
                    install.call('./python-greetings')
                }
            }
        }

        stage('deploy-to-dev') {
            steps {
                git url: "${PYTHON_REPO}", changelog: false, poll: false
                script {
                    deploy.call('./python-greetings', 'dev', '7001')
                }
            }
        }

        stage('tests-on-dev') {
            steps {
                git url: "${TEST_REPO}", changelog: false, poll: false
                script {
                    test.call('./course-js-api-framework', 'greetings_dev')
                }
            }
        }

        stage('deploy-to-staging') {
            steps {
                git url: "${PYTHON_REPO}", changelog: false, poll: false
                script {
                    deploy.call('./python-greetings', 'staging', '7002')
                }
            }
        }

        stage('tests-on-staging') {
            steps {
                git url: "${TEST_REPO}", changelog: false, poll: false
                script {
                    test.call('./course-js-api-framework', 'greetings_staging')
                }
            }
        }

        stage('deploy-to-preprod') {
            steps {
                git url: "${PYTHON_REPO}", changelog: false, poll: false
                script {
                    deploy.call('./python-greetings', 'preprod', '7003')
                }
            }
        }

        stage('tests-on-preprod') {
            steps {
                git url: "${TEST_REPO}", changelog: false, poll: false
                script {
                    test.call('./course-js-api-framework', 'greetings_preprod')
                }
            }
        }

        stage('deploy-to-prod') {
            steps {
                git url: "${PYTHON_REPO}", changelog: false, poll: false
                script {
                    deploy.call('./python-greetings', 'prod', '7004')
                }
            }
        }

        stage('tests-on-prod') {
            steps {
                git url: "${TEST_REPO}", changelog: false, poll: false
                script {
                    test.call('./course-js-api-framework', 'greetings_prod')
                }
            }
        }
    }
}
