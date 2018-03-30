pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        sh 'chmod +x ./gradlew && ./gradlew clean build'
      }
    }
    stage('Test') {
      steps {
        sh './gradlew clean test'
      }
    }
    stage('Deploy') {
      steps {
        echo 'Deploying....'
      }
    }
  }
}