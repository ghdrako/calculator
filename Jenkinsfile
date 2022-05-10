pipeline {
 agent any
 stages {
  stage("Compile") {
   steps {
    sh "chmod u+x mvnw"
    sh "./mvnw compile"
   }
  }
  stage("Unit test") {
   steps {
    sh "chmod u+x mvnw"   
    sh "./mvnw test"
   }
   post {
        always {
            junit '**/target/surefire-reports/TEST-*.xml'
        }
   }
  }
  stage("Code coverage") {
   steps {  
    sh "chmod u+x mvnw"    
    sh "./mvnw jacoco:report-aggregate" 
    publishHTML(target: [
                        reportDir  : '**/target/site/jacoco-aggregate',
                        reportFiles: 'index.html',
                        reportName : 'Coverage Report - Unit Tests'
                ])
    sh "./mvnw verify"
   }
  } 
   //post {
   //         always {
                // Requires HTMLPublisher plugin in Jenkins instance.
   //             publishHTML(target: [
   //                     reportDir  : '**/target/site/jacoco-aggregate',
   //                     reportFiles: 'index.html',
   //                     reportName : 'Coverage Report - Unit Tests'
   //             ])
   //         }
   // }
    stage("Static code analysis") {
     steps {
      sh "chmod u+x mvnw"
      sh "./mvnw checkstyle:checkstyle-aggregate"  
      sh "./mvnw checkstyle:check"
     }
    }
  }
}