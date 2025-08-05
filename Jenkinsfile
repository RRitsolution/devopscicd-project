pipeline {
    agent any

    environment {
        DEPLOY_BASE = './env'
    }

    stages {

        stage('Checkout Code') {
            steps {
                echo 'Code already checked out by Jenkins.'
                // If not pre-checked out, add: checkout scm
            }
        }

        stage('Build') {
            steps {
                echo 'Building the Maven project...'
                sh '/usr/bin/mvn clean compile'
            }
        }

        stage('Unit Test') {
            steps {
                echo 'Running unit tests...'
                sh '/usr/bin/mvn test'
            }
        }

        stage('Deploy to Dev') {
            steps {
                echo 'Deploying to DEV environment...'
                sh '''
                    mkdir -p $DEPLOY_BASE/dev
                    cp -v target/**/*.class $DEPLOY_BASE/dev/
                    cp -v config.yaml $DEPLOY_BASE/dev/
                '''
            }
        }

        stage('Deploy to Test') {
            steps {
                input "Proceed to TEST?"
                echo 'Deploying to TEST environment...'
                sh '''
                    mkdir -p $DEPLOY_BASE/test
                    cp -v target/**/*.class $DEPLOY_BASE/test/
                    cp -v config.yaml $DEPLOY_BASE/test/
                '''
            }
        }

        stage('Deploy to Staging') {
            steps {
                input "Proceed to STAGING?"
                echo 'Deploying to STAGING environment...'
                sh '''
                    mkdir -p $DEPLOY_BASE/staging
                    cp -v target/**/*.class $DEPLOY_BASE/staging/
                    cp -v config.yaml $DEPLOY_BASE/staging/
                '''
            }
        }

        stage('Deploy to Production') {
            steps {
                input "Proceed to PRODUCTION?"
                echo 'Deploying to PRODUCTION environment...'
                sh '''
                    mkdir -p $DEPLOY_BASE/prod
                    cp -v target/**/*.class $DEPLOY_BASE/prod/
                    cp -v config.yaml $DEPLOY_BASE/prod/
                '''
            }
        }
    }
}
