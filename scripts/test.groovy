def sayHello() {
    println("Hi I am from Groovy script")
}

def sayBye() {
    println("Bye Bye")
}

def executeSql(){
    withCredentials([usernamePassword(credentialsId: 'cloud_oracle_db_hr', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
        def query = "SELECT * FROM EMPLOYEES"
        // def tns_path = sh(script: 'echo $TNS_ADMIN', returnStdout: true).trim()       
        // dir(tns_path){
            def sqlplusCommand = "sqlplus -S $USERNAME/$PASSWORD@oci_high <<EOF\n${query}\nEOF"
            def result = sh(script: sqlplusCommand, returnStdout: true)
        // }

        writeFile file: 'output.txt', text: result
        echo result
    }
}

def returnHtml(){
    def title = 'Dynamic HTML'
    def heading = 'Groovy Generated HTML'
    def message = 'This HTML file was generated dynamically using Groovy in a Jenkins pipeline.'
    def htmlContent = """
                        <html>
                            <head>
                                <title>${title}</title>
                            </head>
                            <body>
                                <h1>${heading}</h1>
                                <p>${message}</p>
                            </body>
                        </html>
                    """
    // sh "echo '${htmlContent.replaceAll("'", "\\\\'")}' > output.html"
    writeFile file: 'output.html', text: htmlContent
}

def sendEmail() {
    echo "Sending email"
    emailext body: '''Hello there, how 
please check your jenkins job build status''', subject: 'Jenkins Code Build Status', to: 'sabdar.143@gmail.com', attachmentsPattern: 'output.*'

    echo "Email sent"
}

return this;