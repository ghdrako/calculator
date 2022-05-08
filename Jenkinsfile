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
    //publishHTML (target: [
    //    reportDir: 'target/jacoco-report',
    //    reportFiles: 'index.html',
    //    reportName: "JaCoCo Report"
    //])    
   }
  }
  stage("Code coverage") {
   steps {
       
    sh "chmod u+x mvnw"    
    sh "./mvnw jacoco:report-aggregate" 
    post {
            always {
                // Requires HTMLPublisher plugin in Jenkins instance.
                publishHTML(target: [
                        reportDir  : '**/target/site/jacoco-aggregate',
                        reportFiles: 'index.html',
                        reportName : 'Coverage Report - Unit Tests'
                ])
            }
         }
    sh "./mvnw verify"
   }
  }
 }
}