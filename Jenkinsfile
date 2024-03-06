pipeline {
    agent {
        any {
            image 'maven:3-alpine'
            args '-v /root/.m2:/root/.m2'
        }
    }
    stages {
        stage('Build') {
            steps {
                echo 'Build ok!!!!!'
            }
        }
        stage('Test') { 
            steps {
                echo 'test ok!!!!!'
            }
            // post {
            //     always {
            //         junit 'target/surefire-reports/*.xml' 
            //     }
            // }
        }
    }
}
