pipeline {
    agent any

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
                    deleteDir()
                    git(url: 'https://github.com/mtararujs/python-greetings', branch: 'main')
                    installScript('.')
                }
            }
        }

        stage('deploy-to-dev') {
            steps {
                script {
                    deployScript.deploy('dev', 7001)
                }
            }
        }

        stage('tests-on-dev') {
            steps {
                script {
                    deleteDir()
                    git(url: 'https://github.com/mtararujs/course-js-api-framework', branch: 'main')
                    testScript.runTests('greetings_dev')
                }
            }
        }

        stage('deploy-to-staging') {
            steps {
                script {
                    deployScript.deploy('staging', 7002)
                }
            }
        }

        stage('tests-on-staging') {
            steps {
                script {
                    deleteDir()
                    git(url: 'https://github.com/mtararujs/course-js-api-framework', branch: 'main')
                    testScript.runTests('greetings_stg')
                }
            }
        }

        stage('deploy-to-preprod') {
            steps {
                script {
                    deployScript.deploy('preprod', 7003)
                }
            }
        }

        stage('tests-on-preprod') {
            steps {
                script {
                    deleteDir()
                    git(url: 'https://github.com/mtararujs/course-js-api-framework', branch: 'main')
                    testScript.runTests('greetings_preprod')
                }
            }
        }

        stage('deploy-to-prod') {
            steps {
                script {
                    deployScript.deploy('prod', 7004)
                }
            }
        }

        stage('tests-on-prod') {
            steps {
                script {
                    deleteDir()
                    git(url: 'https://github.com/mtararujs/course-js-api-framework', branch: 'main')
                    testScript.runTests('greetings_prod')
                }
            }
        }
    }
}
