pipeline {
  agent any
    stages {
        stage('build') {
            steps {
                sh 'mvn --version'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn clean install -Dtest.ENV=int -Dtestgroup=SmokeTest -Dapiver=V2'
            }
        }
    }
}
