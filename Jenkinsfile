pipeline {
    agent any
    environment{
        VENKAIAH_HOME= tool 'sonar-scanner'
    }
    stages {
        stage('Git Checkout') {
            steps {
                git branch: 'pythonapp', url: 'https://github.com/practicebaladebitcardaws-ops/GitPractice.git'
            }
        }
        stage('Installing the Flask') {
            steps {
                sh 'pip install -r requirements.txt --break-system-packages'
            }
        }
        
        stage('Build and Pusing Docker Image') {
            steps {
                script{
                    withDockerRegistry(credentialsId: '71fe015f-17e0-46a4-8d31-f8014321eb89') {
                        sh 'docker build -t venkaiahk/pylogin:v5 .'
                        sh 'docker run -dt -p 6000:5000 venkaiahk/pylogin:v5'
                        sh 'docker push venkaiahk/pylogin:v5'
                    }
                }
            }
        }
        stage('Exporting to the SonarQube') {
            steps {
                withSonarQubeEnv('sonarserver') {
                    sh '''$VENKAIAH_HOME/bin/sonar-scanner -Dsonar.projectKey=pythondemo -Dsonar.ProjectName=pythondemo -Dsonar.sources=/var/lib/jenkins/workspace/pyhtonlogin/'''
                }
            }
        }
    }
}
