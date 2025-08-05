pipeline {
    agent any

    tools {
        jdk 'JDK17'
        maven 'Maven3.8.7'
    }

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
                echo 'Building the Maven project...'
                sh 'mvn clean compile'
            }
        }

        stage('Unit Test') {
            steps {
                echo 'Running unit tests...'
                sh 'mvn test'
            }
        }

        stage('Deploy to Dev') {
            steps {
                echo 'Deploying to DEV environment...'
                sh '''
                    mkdir -p $DEPLOY_BASE/dev
                    cp -v target/**/*.class $DEPLOY_BASE/dev/
                    cp -v $DEPLOY_BASE/dev/config.yaml $DEPLOY_BASE/dev/
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
                    cp -v $DEPLOY_BASE/test/config.yaml $DEPLOY_BASE/test/
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
                    cp -v $DEPLOY_BASE/staging/config.yaml $DEPLOY_BASE/staging/
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
                    cp -v $DEPLOY_BASE/prod/config.yaml $DEPLOY_BASE/prod/
                '''
            }
        }
    }
}
