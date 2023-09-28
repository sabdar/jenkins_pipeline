#!/usr/bin/env groovy

//write sample pipeline script for jenkins with 2 stages and agent label as "ubuntu"
//add groovy script to read file in windows stage steps



pipeline {
    agent none 
     options {
        skipDefaultCheckout()
    }
    stages{
        stage("checkout"){
            agent {
                label "sabdar_pc"
            }
            steps {
                git branch: 'main', credentialsId: 'jenkins_pipeline', url: 'git@github.com:sabdar/jenkins_pipeline.git'
                stash name: 'scripts', includes: 'scripts/**'
            }
        }
        stage("windows"){
            agent {
                label "sabdar_pc"
            }
            steps {
                // unstash "scripts"
                def myTest = load "scripts/test.groovy"
                myTest.sayHello()
                bat 'dir'
                echo "Hello sabdar"
                script{
                    myTest.sayHello()
                }
                
            }
        }
        stage("ubuntu"){
            agent {
                label "ubuntu"
            }
            steps {
                unstash "scripts"
                def myTest =  load "scripts/test.groovy"
                myTest.sayBye()
                echo "Hello ubuntu"
                script{
                    myTest.sayBye()
                }
              
            }
        }
    }
}