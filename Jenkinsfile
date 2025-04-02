pipeline {
    agent any

    stages {
        stage('Install Dependencies') {
            steps {
                script {
                    load 'jenkins/install.groovy'
                }
            }
        }

        stage('Deploy to Dev') {
            steps {
                script {
                    load 'jenkins/deploy.groovy'
                    deploy('dev', 7001)
                }
            }
        }

        stage('Test on Dev') {
            steps {
                script {
                    load 'jenkins/test.groovy'
                    runTests('greetings_dev')
                }
            }
        }

        stage('Deploy to Staging') {
            steps {
                script {
                    deploy('staging', 7002)
                }
            }
        }

        stage('Test on Staging') {
            steps {
                script {
                    runTests('greetings_stg')
                }
            }
        }

        stage('Deploy to Preprod') {
            steps {
                script {
                    deploy('preprod', 7003)
                }
            }
        }

        stage('Test on Preprod') {
            steps {
                script {
                    runTests('greetings_preprod')
                }
            }
        }

        stage('Deploy to Prod') {
            steps {
                script {
                    deploy('prod', 7004)
                }
            }
        }

        stage('Test on Prod') {
            steps {
                script {
                    runTests('greetings_prod')
                }
            }
        }
    }
}
