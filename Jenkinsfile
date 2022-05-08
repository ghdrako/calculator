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
  }
  stage("Code coverage") {
   steps {
    sh "chmod u+x mvnw"     
    sh "./mvnw verify"
    publishHTML (target: [
        reportDir: 'target/jacoco-report',
        reportFiles: 'index.html',
        reportName: "JaCoCo Report"
    ])    
   }
  }
 }
}