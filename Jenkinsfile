#!/usr/bin/env groovy

//write sample pipeline script for jenkins with 2 stages and agent label as "ubuntu"
//add groovy script to read file in windows stage steps



pipeline {
    agent none 
     options {
        skipDefaultCheckout()
    }
    stages{
        stage("windows"){
            agent {
                label "sabdar_pc"
            }
            steps {
                load "scripts/test.groovy"
                bat 'dir'
                echo "Hello sabdar"
                sayHello()
            }
        }
        stage("ubuntu"){
            agent {
                label "ubuntu"
            }
            steps {
                load "scripts/test.groovy"
                echo "Hello ubuntu"
                sayBye()
            }
        }
    }
}