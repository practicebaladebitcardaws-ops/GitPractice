pipeline {
    agent any
    tools{
        nodejs 'node21'
        jdk 'jdk'
    }
    environment{
        SONAR_SCANNER= tool 'sonar-scanner'
    }

    stages {
        stage('Git Checkout') {
            steps {
                checkout scmGit(branches: [[name: '*/nodeapp']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/practicebaladebitcardaws-ops/GitPractice']])
            }
        }
        stage('Sonar Qube Analysis') {
            steps {
                withSonarQubeEnv('sonarserver') {
                  sh '''$SONAR_SCANNER/bin/sonar-scanner -Dsonar.projectKey=nodesjapp -Dsonar.projectName=nodejsapp'''
                }
            }
        }
        stage('Building Docker Image') {
            steps {
                script{
                    withDockerRegistry(credentialsId: 'mydockerpwd') {
                        sh 'docker build -t venkaiahk/nodelatest:v1 .'
                        sh 'docker run -dt -p 7000:3000 venkaiahk/nodelatest:v1'
                        sh 'docker push venkaiahk/nodelatest:v1'
                        }
                }
            }
        }
    }
}
