# Readme 

<strong>Instalar e configurar as variáveis de ambiente</strong> <br />
- JAVA_HOME : JDK 11.0.3 <br />
- MAVEN_HOME : apache-maven-3.6.3<br />
 <p />
 
 1- git clone https://github.com/leopaulasilva/myRepo.git<br />
 2- cd zenvia<br />
 3- mvn clean install<br />
 4- mvn spring-boot:run
 
<h2><strong>Acessar via REST client as URLs </strong></h2>
<strong>Metodo POST para enviar a lista</strong>
 - http://localhost:8080/msg/add<br />

Parametros no header:<br />
  -  Content-Type : application/json<br />
  -  token : whatever<br />

<strong>Body </strong>exemplo:
  ````
    [
        {
            
            "messageBody": "Lorem Ipsum is s industry.",
            "location": "brazil"
        },
        {
            
            "messageBody": "t is a long e when looking at its layout",
            "location": "Autralia"
        },
        {
            
            "messageBody": "Contrary to popular belief, Lorem Ipsum is not simply randt over 2000 years old",
            "location": "Argentina"
        }
    ] 

````

<strong>URL metodo GET para ver a lista processada</strong>
  - http://localhost:8080/msg/list
    

    