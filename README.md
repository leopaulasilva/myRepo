# Desafio Técnico | Zenvia 

<strong>Instalação  via github:</strong>

 - git clone https://github.com/leopaulasilva/myRepo.git<br />
 - cd zenvia<br />
 - mvn clean install

<h2><strong>URL metodo POST para enviar a lista</strong></h2>

 - http://localhost:8080/msg/add<br />

<strong>Parametros no header </strong>:<br />
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

<h2><strong>URL metodo GET para ver processada</strong></h2>
  - http://localhost:8080/msg/list
    

    