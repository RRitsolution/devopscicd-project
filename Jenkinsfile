pipeline {
    agent any

    environment {
        DEPLOY_BASE = 'env'
    }

    stages {
        stage('Checkout Code') {
            steps {
                git 'https://github.com/RRitsolution/devopscicd-project.git'
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
                sh 'mkdir -p $DEPLOY_BASE/dev'
                sh 'cp -v target/**/*.class $DEPLOY_BASE/dev/'
            }
        }

        stage('Deploy to Test') {
            steps {
                input "Proceed to TEST?"
                sh 'mkdir -p $DEPLOY_BASE/test'
                sh 'cp -v target/**/*.class $DEPLOY_BASE/test/'
            }
        }

        stage('Deploy to Staging') {
            steps {
                input "Proceed to STAGING?"
                sh 'mkdir -p $DEPLOY_BASE/staging'
                sh 'cp -v target/**/*.class $DEPLOY_BASE/staging/'
            }
        }

        stage('Deploy to Production') {
            steps {
                input "Proceed to PRODUCTION?"
                sh 'mkdir -p $DEPLOY_BASE/prod'
                sh 'cp -v target/**/*.class $DEPLOY_BASE/prod/'
            }
        }
    }
}
