pipeline {
    agent none 
    options {
        skipDefaultCheckout()
    }
    stages {
        stage("checkout") {
            when {
                expression { return true}
            }
            agent {
                label "sabdar_pc"
            }
            steps {
                git branch: 'main', credentialsId: 'jenkins_pipeline', url: 'git@github.com:sabdar/jenkins_pipeline.git'
                stash name: 'scripts', includes: 'scripts/**'
            }
        }
        stage("windows") {
            when {
                expression { return true}
            }
            agent {
                label "sabdar_pc"
            }
            steps {
                // unstash "scripts"
                script {
                    def test = load "scripts/test.groovy"
                    test.returnHtml()
                 
                }
                bat 'dir'
                echo "Hello sabdar"
            }
        }
        stage("ubuntu") {
            when {
                expression { return true}
            }
            agent {
                label "ubuntu"
            }
             environment {
                ORCLE_CRED = credentials('cloud_oracle_db_hr')
             }
            stages {
                stage("steps") {
                    steps {
                        sh """
                            #!/bin/bash
                            echo "Hello from \$SHELL"
                            cat ~/.bashrc
                            source ~/.bashrc
                            sqlplus -version        
                            sqlplus -S $ORCLE_CRED_USR/$ORCLE_CRED_PSW@oci_high <<EOF\n${query}\nEOF | tee output.txt
                            """
                        unstash "scripts"
                        script {
                            def abc = load "scripts/test.groovy"
                           abc.sayBye()
                           def query = "SELECT * FROM EMPLOYEES"
        
           
                            
                            abc.executeSql()
                            abc.sendEmail()

                        }
                    }
                }
                stage("level2") {
                    steps {
                        echo "hello level2"
                    }
                }
            }
        }
    }
    post{
        always{
            echo "I will always run"
            // emailext attachLog: true, body: 'ji', subject: 'hello test ', to: 'sabdar.143@gmail.com'
            echo "Email commneted for some time"
        }
    }
}
