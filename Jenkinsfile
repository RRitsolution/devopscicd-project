pipeline {
    agent any

    environment {
        DEPLOY_BASE = './env'
    }

    stages {
        stage('Checkout Code') {
            steps {
                echo 'Code already checked out by Jenkins.'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Unit Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Deploy to Dev') {
            steps {
                sh 'cp -v target/*.class $DEPLOY_BASE/dev/'
            }
        }

        stage('Deploy to Test') {
            steps {
                input "Proceed to TEST?"
                sh 'cp -v target/*.class $DEPLOY_BASE/test/'
            }
        }

        stage('Deploy to Staging') {
            steps {
                input "Proceed to STAGING?"
                sh 'cp -v target/*.class $DEPLOY_BASE/staging/'
            }
        }

        stage('Deploy to Production') {
            steps {
                input "Proceed to PRODUCTION?"
                sh 'cp -v target/*.class $DEPLOY_BASE/prod/'
            }
        }
    }
}
