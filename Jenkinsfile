pipeline {
    agent any
    
    environment {
        DOCKER_REGISTRY = 'your-registry.com'
        IMAGE_TAG = "${BUILD_NUMBER}"
    }
    
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        
        stage('Build') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }
        
        stage('Unit Test') {
            steps {
                sh 'mvn test'
            }
        }
        
        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    sh 'mvn sonar:sonar'
                }
            }
        }
        
        stage('Build Docker Images') {
            steps {
                sh """
                    docker-compose build
                    docker tag mall-product:latest ${DOCKER_REGISTRY}/mall-product:${IMAGE_TAG}
                    docker tag mall-order:latest ${DOCKER_REGISTRY}/mall-order:${IMAGE_TAG}
                    docker tag mall-admin:latest ${DOCKER_REGISTRY}/mall-admin:${IMAGE_TAG}
                """
            }
        }
        
        stage('Push Docker Images') {
            steps {
                withDockerRegistry([credentialsId: 'docker-registry-credentials', url: "https://${DOCKER_REGISTRY}"]) {
                    sh """
                        docker push ${DOCKER_REGISTRY}/mall-product:${IMAGE_TAG}
                        docker push ${DOCKER_REGISTRY}/mall-order:${IMAGE_TAG}
                        docker push ${DOCKER_REGISTRY}/mall-admin:${IMAGE_TAG}
                    """
                }
            }
        }
        
        stage('Deploy to Production') {
            steps {
                sshagent(['prod-server-credentials']) {
                    sh """
                        ssh user@prod-server 'cd /app/mall && \
                        docker-compose pull && \
                        docker-compose up -d'
                    """
                }
            }
        }
    }
    
    post {
        success {
            emailext (
                subject: "Pipeline Success: ${currentBuild.fullDisplayName}",
                body: "Your pipeline has completed successfully.",
                recipientProviders: [[$class: 'DevelopersRecipientProvider']]
            )
        }
        failure {
            emailext (
                subject: "Pipeline Failed: ${currentBuild.fullDisplayName}",
                body: "Your pipeline has failed. Please check the Jenkins console output.",
                recipientProviders: [[$class: 'DevelopersRecipientProvider']]
            )
        }
    }
} 