pipeline {
  agent any
  stages {
    stage('CheckVersion') {
      steps {
        build 'restassured'
      }
    }

  }
  environment {
    ENV = 'int'
  }
}