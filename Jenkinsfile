pipeline {
 agent any
 stages {
  stage("Compile") {
   steps {
    sh "chmod u+x mvnw"
    sh "./mvnw clean compile"
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
      publishHTML (target: [
                        reportDir: 'build/reports/checkstyle/',
                        reportFiles: 'main.html',
                        reportName: "Checkstyle Report"
      ])      
      //sh "./mvnw checkstyle:check"
     }
    }
    stage("Package") {
     steps {
      sh "chmod u+x mvnw" 
      sh "./mvnw package"
     }
    }
    stage("Docker build") {
     steps {
      sh "docker build -t akdevops/calculator ."
     }
    }
    stage("Deploy to staging") {
     steps {
      sh "docker run -d --rm -p 8765:8080 --name calculator akdevops/calculator"
     }
    } 
    stage("Acceptance test") {
     steps {
      sleep 60
      sh "chmod +x acceptance_test.sh && ./acceptance_test.sh"
     }
    }
    

  }
  post {
     always {
      sh "docker stop calculator"
     }
  }
}