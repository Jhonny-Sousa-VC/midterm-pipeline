pipeline {
  agent any

  environment {
    IMAGE_NAME = "midterm-pipeline"
    CONTAINER_NAME = "midterm-pipeline-app"
    APP_PORT = "8082"
  }

  stages {
    stage('Checkout') {
      steps {
        checkout scm
      }
    }

    stage('Build + Unit Tests (Maven)') {
      steps {
        sh 'mvn -B clean test'
      }
    }

    stage('Package (Maven)') {
      steps {
        sh 'mvn -B clean package -DskipTests'
      }
    }

    stage('Docker Build') {
      steps {
        sh 'docker build -t ${IMAGE_NAME}:latest .'
      }
    }

    stage('Docker Deploy (local)') {
      steps {
        sh """
          set +e
          docker rm -f ${CONTAINER_NAME} 2>/dev/null
          set -e
          docker run -d --name ${CONTAINER_NAME} -p ${APP_PORT}:8080 ${IMAGE_NAME}:latest
        """
      }
    }
  }

  post {
    always {
      echo "Done. If deploy ran, app should be on http://localhost:${APP_PORT}/hello"
    }
  }
}