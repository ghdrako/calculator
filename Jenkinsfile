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
    sh "./mvnw test"
    publishHTML (target: [
        reportDir: 'build/reports/jacoco/test/html',
        reportFiles: 'index.html',
        reportName: "JaCoCo Report"
    ])    
   }
  }
 }
}