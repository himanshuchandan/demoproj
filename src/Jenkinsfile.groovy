properties([pipelineTriggers([githubPush()])])      
pipeline{
    agent any
    tools{
        jdk 'JDK_8'
        maven 'MAVEN'
    }
    stages{
        
        stage('compile'){
            steps{
                bat 'mvn compile'
            }
        }
		stage('package'){
            steps{
                bat 'mvn package'
            }
        }
    }
}
