pipeline {

    environment {
        registry = "aziz04/devopstimesheet"
        registryCredential = 'dockerHub'
        dockerImage = ''
        
    }
 
    agent any
    
    stages {
        stage('---clean---') {
            steps {
                bat "mvn clean"
            }
        }
    
      
        stage('---install---') {
            steps {
                bat "mvn install"
            }
        }
        
            stage('---test---') {
            steps {
                bat "mvn test"
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

            stage("---nexus---") {
            steps {
                bat "mvn clean package -Dmaven.test.skip=true  deploy:deploy-file  -DgroupId=tn.esprit.spring    -DartifactId=Timesheet-spring-boot-core-data-jpa-mvc-REST-1 -Dversion=6.2  -DgeneratePom=true   -Dpackaging=war -DrepositoryId=deploymentRepo  -Durl=http://localhost:8081/repository/maven-releases/   -Dfile=target/Timesheet-spring-boot-core-data-jpa-mvc-REST-1-6.2.war"
            }
        }

        stage('---build image docker---') {
            steps {
                script {
                    dockerImage = docker.build registry 
                }
            }
        }
        stage('---deploy image docker ---') {
        steps {
            script {
                docker.withRegistry( '', registryCredential ) {
                        dockerImage.push()
                    }
                }
            }
        }
       

            
        

    
    }
}
