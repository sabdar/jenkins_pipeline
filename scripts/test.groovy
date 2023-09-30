def sayHello() {
    println("Hi I am from Groovy script")
}

def sayBye() {
    println("Bye Bye")
}

def returnHtml(){
    return "<html><body><h1>Hello World</h1></body></html>"
}

def sendEmail() {
    echo "Sending email"
    emailext body: '''Hello there, how 
please check your jenkins job build status''', subject: 'Jenkins Code Build Status', to: 'sabdar.143@gmail.com'    

    echo "Email sent"
}

return this;