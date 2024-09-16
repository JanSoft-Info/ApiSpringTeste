# ApiSpringTeste
Api de Testes desenvolvida com Java e o framework Spring Boot com o objetivo didático servindo como uma aplicação para testes de novas tecnologias e funcionalidades.

## Java
Essa API foi desenvolvida utilizando o Java 17

## Spring Framework
Essa API foi desenvolvida utilizando a versão 3.2.2 do Spring Framework

## REST
Essa API disponibiliza uma serviço REST que pode ser acessado utilizando uma plataforma de API do tipo Postman. O collection das chamadas da API estão diponibilizados na pasta indicada abaixo:
- \ApiSpringTest\postman

### Arquitetura Hexagonal
Essa API implementa a arquitetura hexagonal que visa a criação de componentes de aplicação fracamente acoplados que podem ser facilmente conectados ao seu ambiente de software por meio de portas e adaptadores. 

## Banco de Dados
Essa API usa o banco de dados em memória H2 e conta com o arquivo que popula o banco incialmente assim que a aplicação for executa. Esse arquivo encontra-se indicado na pasta abaixo:
- \ApiSpringTeste\src\main\resources\data.sql

### Modelo Entidade Relacional
Foi criado um modelo Entidade Relacional (ER) para demonstração das estruturas e relacionamentos das tabelas utilizadas pela API. Esse modelo está disponibilizado na pasta indicada abaixo:
- \ApiSpringTeste\modelorelacional

## Cache
### Redis
Essa API disponibiliza um serviço de cache com Redis para fins de teste.

## Mensageria
### Kafka
Essa API disponibiliza um serviço de mensageria Kafka composto com um Producer e um Consumer para o tópico "api.spring.teste.topic". Os componentes necessário para execução do Kafka estão incluídos no docker-compose. Ao ser executado pala primeira vez, abra o KafkaDrop e crie o tópico mencionado.

## Observability
Essa API expõe endpoints de gerenciamento extras para utilização de métricas. No docker-compose disponibilizado junto com ela, instala e configura o Prometheus e Grafana para fins de estudo da construção de dashboards. Segue abaixo os endpoints expostos:
- info,metrics,health,prometheus

### Grafana
Essa API disponibiliza alguns painéis de observabilidade feitos no grafana, para acessar use o usuário e senha indicados abaixo:
- User: admin
- Password: admin

### Tracing
Essa API disponibiliza um portal de tracing através do Jeagger

## Docker
Essa API disponibiliza um docker-compose para baixar e conteniarizar algumas imagems de aplicações utilizadas pela mesma, além da própria aplicação dockerizada para fins didáticos na utilização de tracing com o Jeager. Esse arquivo esta na pasta indicada abaixo:
- \java\ApiSpringTeste

Antes de executar esse arquivo, certifique-se que que tenha instalado em sua máquina o Docker, caso não tenha ele pode ser baixado de acordo com seu sistema operacional no site do fabricante:
https://docs.docker.com/get-docker/

Após a instalação, verifique se o docker-compose está instalado corretamente executando o comando no seu terminal:
- docker-compose --version

Agora, acesse a pasta \java\ApiSpringTeste pelo terminal e execute o comando:
- docker-compose up -d

## URLs da API
### Database H2
http://localhost:5001/h2-console
### Swagger
http://localhost:5001/swagger-ui/index.html
### Promethues
http://localhost:9090
### Grafana
http://localhost:3000
### Jeager
http://localhost:16686/search
### kafkaDrop
http://localhost:9000
### Actuator
http://localhost:5001/actuator
### Health
http://localhost:5001/actuator/health
### Metrics
http://localhost:5001/actuator/metrics