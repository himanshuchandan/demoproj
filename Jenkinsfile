@Library('shared-library')
//properties([pipelineTriggers([pollSCM('* * * * *')])])
pipeline{
    agent any
    tools{
        jdk 'JDK_8'
        maven 'MAVEN'
    }
    stages{
	    /*
        stage('SCM Checkout'){
            steps{
               git credentialsId: 'for_github', url: 'https://github.com/himanshuchandan/demoproj.git'
            }
        }
        */
	    /*
        stage('sonar analysis') {
                steps {
                
                bat 'mvn clean package sonar:sonar'  
            }
        }   
	*/
	stage('Package'){
            steps{
                bat 'mvn clean package'
              //sh 'mvn package'
            }
        }    
        
       /* stage('Build') {
                steps {
                //ABC indicates the folder name where the pom.xml file resides
                sh 'mvn -f /var/lib/jenkins/workspace/student_data_101/bootjpa/pom.xml clean compile'  
            }
        }*/
        stage('Store war in nexus repo'){
            steps{
               nexusArtifactUploader artifacts: [
                   [
                       artifactId: 'demo', 
                       classifier: '',
                       file: 'C:/windows/system32/config/systemprofile/AppData/Local/Jenkins/.jenkins/workspace/pipeline_demo/target/demo-0.0.1-SNAPSHOT.war', 
                       type: 'war'
                    ]
                ],
                credentialsId: 'nexus', 
                groupId: 'org.springframework.boot', 
                nexusUrl: '35.222.214.106:8081', 
                nexusVersion: 'nexus3', 
                protocol: 'http', 
                repository: 'demoapp/', 
                version: '0.0.1-SNAPSHOT'
            }
        }
    }
}


