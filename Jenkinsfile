pipeline {
    agent any
    stages {
        stage('Build') { 
            agent {
              docker {
               image 'maven:3-alpine'
              }
            }
            steps {
		//sh 'cd ./demo/'
		sh 'mvn clean package -f ./demo/'
		stash name: "app", includes: "**"



            }
        }
	stage('QualityTest') { 
            agent {
              docker {
               image 'maven:3-alpine'
              }
            }
            steps {
		    unstash "app"
		    sh 'mvn clean test -f ./demo/'
		    sh 'mvn sonar:sonar -f ./demo/ \
  -Dsonar.projectKey=he-arctest \
  -Dsonar.organization=lucienmoor-github \
  -Dsonar.host.url=https://sonarcloud.io \
  -Dsonar.login=79a46ded44689e7692f3d1be58473c1a94cbb3a4'
	    }
        }
    }
       post {
        always {
            echo 'always clean up'
            cleanWs()
        }
    }
}
