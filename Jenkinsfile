pipeline {
    agent any
    
    stages {
        stage('---clean---') {
            steps {
                mvn clean
            }
        }
        stage('---test---') {
            steps {
                bat "mvn test"
            }
        }
      
        stage('---install---') {
            steps {
                bat "mvn install"
            }
        }

           stage('---package---') {
            steps {
                bat "mvn package "
            }
        }

           stage('---sonar---') {
            steps {
                bat "mvn sonar:sonar "
            }
            
        }

    
    }
}
