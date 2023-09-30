pipeline {
    agent none 
    options {
        skipDefaultCheckout()
    }
    stages {
        stage("checkout") {
            agent {
                label "sabdar_pc"
            }
            steps {
                git branch: 'main', credentialsId: 'jenkins_pipeline', url: 'git@github.com:sabdar/jenkins_pipeline.git'
                stash name: 'scripts', includes: 'scripts/**'
            }
        }
        stage("windows") {
            agent {
                label "sabdar_pc"
            }
            steps {
                // unstash "scripts"
                script {
                    def test = load "scripts/test.groovy"
                    def text = test.returnHtml()
                    echo text
                    test.sendEmail()

                }
                bat 'dir'
                echo "Hello sabdar"
            }
        }
        stage("ubuntu") {
            agent {
                label "ubuntu"
            }
            stages {
                stage("steps") {
                    steps {
                        unstash "scripts"
                        script {
                            def abc = load "scripts/test.groovy"
                            abc.sayBye()
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
}
