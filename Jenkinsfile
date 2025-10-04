pipeline {
    agent any
    tools {
            maven 'Maven3' // Name you gave in Global Tool Config
            jdk 'JDK21'    // Your JDK tool name
        }
    environment {
        DOCKER_IMAGE = "varshayamsani/scientific-calculator:latest"
    }

    stages {

        stage('Clone Repository') {
            steps {
                echo 'Cloning GitHub repository...'
                git branch: 'main', url: 'https://github.com/varshayamsani/scientificCalculator.git'

            }

        }

        stage('Build') {
            steps {
                echo 'Building Java project with Maven...'
                sh 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                echo 'Running tests with Maven...'
                sh 'mvn test'
            }
        }

        stage('Build Docker Image') {
            steps {
                echo 'Building Docker image...'
                sh 'docker build -t $DOCKER_IMAGE .'
            }
        }

        stage('Push Docker Image') {
            steps {
                echo 'Pushing Docker image to Docker Hub...'
                withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'DOCKER_PASSWORD', usernameVariable: 'DOCKER_USERNAME')]) {
                    sh '''
                        echo $DOCKER_PASSWORD | docker login -u $DOCKER_USERNAME --password-stdin
                        docker push $DOCKER_IMAGE
                    '''
                }
            }
        }

        stage('Deploy Container with Ansible') {
            steps {
                echo 'Deploying container locally via Ansible'
                sh 'ansible-playbook -i ansible/hosts ansible/deploy.yml'
            }
        }
    }

    post {
        success {
            echo 'Pipeline completed successfully!'
        }
        failure {
            echo 'Pipeline failed!'
        }
    }
}
