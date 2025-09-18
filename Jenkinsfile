pipeline {
  agent any

  tools {
    jdk 'JDK21'        // Configure in: Manage Jenkins -> Global Tool Configuration
    maven 'Maven3'     // Configure in: Manage Jenkins -> Global Tool Configuration
  }

  options {
    timestamps()
    ansiColor('xterm')
  }

  stages {
    stage('Checkout') {
      steps {
        checkout scm
        script {
          if (isUnix()) {
            sh 'java -version'
            sh 'mvn -v'
          } else {
            bat 'java -version'
            bat 'mvn -v'
          }
        }
      }
    }

    stage('Build & Test') {
      steps {
        script {
          // Single build command that runs unit tests, ITs, static analysis & coverage
          def cmd = 'mvn -B -U clean verify'
          if (isUnix()) { sh cmd } else { bat cmd }
        }
      }
      post {
        always {
          junit allowEmptyResults: true, testResults: '**/surefire-reports/*.xml, **/failsafe-reports/*.xml'
          archiveArtifacts artifacts: 'target/site/**, target/*.xml', fingerprint: true, allowEmptyArchive: true
        }
      }
    }
  }

  // Uncomment to enable periodic polling or webhooks
  // triggers { pollSCM('@daily') }
}
