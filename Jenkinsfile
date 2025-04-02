node {
    // Piespiež klonēt Jenkins_Prakt repozitoriju no jauna
    stage('checkout-self') {
        checkout scm
    }

    // Tikai pēc checkout ielādē groovy failus
    def install = load 'jenkins/install.groovy'
    def deploy = load 'jenkins/deploy.groovy'
    def test = load 'jenkins/test.groovy'

    stage('install-pip-deps') {
        dir('python-greetings') {
            git branch: 'main', url: 'https://github.com/mtararujs/python-greetings'
            install.call('python-greetings')
        }
    }

    stage('deploy-to-dev') {
        dir('python-greetings') {
            git branch: 'main', url: 'https://github.com/mtararujs/python-greetings'
            deploy.deploy('dev', 7001)
        }
    }

    stage('tests-on-dev') {
        dir('course-js-api-framework') {
            git branch: 'main', url: 'https://github.com/mtararujs/course-js-api-framework'
            test.runTests('greetings_dev')
        }
    }

    stage('deploy-to-staging') {
        dir('python-greetings') {
            git branch: 'main', url: 'https://github.com/mtararujs/python-greetings'
            deploy.deploy('staging', 7002)
        }
    }

    stage('tests-on-staging') {
        dir('course-js-api-framework') {
            git branch: 'main', url: 'https://github.com/mtararujs/course-js-api-framework'
            test.runTests('greetings_staging')
        }
    }

    stage('deploy-to-preprod') {
        dir('python-greetings') {
            git branch: 'main', url: 'https://github.com/mtararujs/python-greetings'
            deploy.deploy('preprod', 7003)
        }
    }

    stage('tests-on-preprod') {
        dir('course-js-api-framework') {
            git branch: 'main', url: 'https://github.com/mtararujs/course-js-api-framework'
            test.runTests('greetings_preprod')
        }
    }

    stage('deploy-to-prod') {
        dir('python-greetings') {
            git branch: 'main', url: 'https://github.com/mtararujs/python-greetings'
            deploy.deploy('prod', 7004)
        }
    }

    stage('tests-on-prod') {
        dir('course-js-api-framework') {
            git branch: 'main', url: 'https://github.com/mtararujs/course-js-api-framework'
            test.runTests('greetings_prod')
        }
    }
}
