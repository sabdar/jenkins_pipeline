#!/usr/bin/env groovy

//write sample pipeline script for jenkins with 2 stages and agent label as "ubuntu"
pipeline {
    agent none 
    stages{
        stage("windows"){
            agent {
                label "sabdar_pc"
            }
            steps {
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








