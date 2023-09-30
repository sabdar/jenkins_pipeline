@Grab('org.codehaus.groovy.templates:groovy-templates:2.0.0')
import groovy.text.TemplateEngine

def engine = new TemplateEngine()
def template = engine.createTemplate('<html><body><h1>${title}</h1><p>${content}</p></body></html>')
def binding = [title: 'My Title', content: 'This is my content']
def result = template.make(binding).toString()





def sayHello() {
    println("Hi I am from Groovy script")
}

def sayBye() {
    println("Bye Bye")
}

def returnHtml(){
    writeFile file: 'output', text: result
}

def sendEmail() {
    echo "Sending email"
    emailext body: '''Hello there, how 
please check your jenkins job build status''', subject: 'Jenkins Code Build Status', to: 'sabdar.143@gmail.com'    

    echo "Email sent"
}

return this;