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
                // bat 'git checkout main'
                bat 'dir'
                echo "Hello sabdar"
            }
        }
        stage("ubuntu"){
            agent {
                label "ubuntu"
            }
            steps {
                echo "Hello ubuntu"
            }
        }
    }
}