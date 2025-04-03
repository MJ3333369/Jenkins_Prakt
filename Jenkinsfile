def deployScript = load 'jenkins/deploy.groovy'
def installScript = load 'jenkins/install.groovy'
def testScript = load 'jenkins/test.groovy'

pipeline {
    agent any

    stages {
        stage('install-pip-deps') {
            steps {
                script {
                    echo ">>> Stage: Install dependencies"
                    dir('greetings') {
                        deleteDir()
                    }
                    git(url: 'https://github.com/mtararujs/python-greetings', branch: 'main', changelog: false, poll: false)
                    installScript('greetings')
                }
            }
        }

        stage('deploy-to-dev') {
            steps {
                script {
                    echo ">>> Stage: Deploy to DEV"
                    deployScript.deploy('dev', 7001)
                }
            }
        }

        stage('tests-on-dev') {
            steps {
                script {
                    echo ">>> Stage: Run tests on DEV"
                    dir('test-framework') {
                        deleteDir()
                    }
                    git(url: 'https://github.com/mtararujs/course-js-api-framework', branch: 'main', changelog: false, poll: false)
                    testScript.runTests('greetings_dev')
                }
            }
        }

        stage('deploy-to-staging') {
            steps {
                script {
                    echo ">>> Stage: Deploy to STAGING"
                    deployScript.deploy('staging', 7002)
                }
            }
        }

        stage('tests-on-staging') {
            steps {
                script {
                    echo ">>> Stage: Run tests on STAGING"
                    dir('test-framework') {
                        deleteDir()
                    }
                    git(url: 'https://github.com/mtararujs/course-js-api-framework', branch: 'main', changelog: false, poll: false)
                    testScript.runTests('greetings_stg')
                }
            }
        }

        stage('deploy-to-preprod') {
            steps {
                script {
                    echo ">>> Stage: Deploy to PREPROD"
                    deployScript.deploy('preprod', 7003)
                }
            }
        }

        stage('tests-on-preprod') {
            steps {
                script {
                    echo ">>> Stage: Run tests on PREPROD"
                    dir('test-framework') {
                        deleteDir()
                    }
                    git(url: 'https://github.com/mtararujs/course-js-api-framework', branch: 'main', changelog: false, poll: false)
                    testScript.runTests('greetings_preprod')
                }
            }
        }

        stage('deploy-to-prod') {
            steps {
                script {
                    echo ">>> Stage: Deploy to PROD"
                    deployScript.deploy('prod', 7004)
                }
            }
        }

        stage('tests-on-prod') {
            steps {
                script {
                    echo ">>> Stage: Run tests on PROD"
                    dir('test-framework') {
                        deleteDir()
                    }
                    git(url: 'https://github.com/mtararujs/course-js-api-framework', branch: 'main', changelog: false, poll: false)
                    testScript.runTests('greetings_prod')
                }
            }
        }
    }
}
