pipeline{
    agent any
        stages{
            stage('Build'){
                steps{
                    bat 'mvn clean package'
                    bat "docker build . -t quizappimage:${env.Build_Id}"
                }
            }
        }
}