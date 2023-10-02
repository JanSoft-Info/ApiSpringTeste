# ApiSpringTeste
Api de Testes desenvolvida com Java e o framework Spring Boot com o objetivo didático servindo como uma aplicação para testes de novas tecnologias e funcionalidades.

## JAVA
Essa API foi desenvolvida utilizando o Java 11

## Spring Framework
Essa API foi desenvolvida utilizando a versão 2.5.0 do Spring Framework

## REST
Essa API disponibiliza uma serviço REST que pode ser acessado utilizando uma plataforma de API do tipo Postman. O collection das chamadas da API estão diponibilizados na pasta indicada abaixo:
- \ApiSpringTest\postman

## Banco de Dados
Essa API usa o banco de dados em memória H2 e conta com o arquivo que popula o banco incialmente assim que a aplicação for executa. Esse arquivo encontra-se indicado na pasta abaixo:
- \ApiSpringTeste\src\main\resources\data.sql

### Modelo Entidade Relacional
Foi criado um modelo Entidade Relacional (ER) para demonstração das estruturas e relacionamentos das tabelas utilizadas pela API. Esse modelo está disponibilizado na pasta indicada abaixo:
- \ApiSpringTeste\modelorelacional

## Docker
Essa API disponibiliza um docker-compose para baixar e conteniarizar algumas imagems de aplicações utilizadas pela mesma, esse arquivo esta na pasta indicada abaixo:
- \java\ApiSpringTeste\docker

Antes de executar esse arquivo, certifique-se que que tenha instalado em sua máquina o Docker, caso não tenha ele pode ser baixado de acordo com seu sistema operacional no site do fabricante:
https://docs.docker.com/get-docker/

Após a instalação, verifique se o docker-compose está instalado corretamente executando o comando no seu terminal:
- docker-compose --version

Agora, acesse a pasta \java\ApiSpringTeste\docker pelo terminal e execute o comando:
- docker-compose up

## URLs da API
### Database H2
http://localhost:5001/h2-console
### Actuator
http://localhost:5001/actuator
### Health
http://localhost:5001/actuator/health
### Metrics
http://localhost:5001/actuator/metrics