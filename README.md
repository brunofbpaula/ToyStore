### Equipe de desenvolvedores:
Bruno de Paula (RM552226)
Kayque Lima (RM550782)
Gabriel Francisco (RM99708)
Gabriel França (RM551905)
Edward de Lima (RM98676)

## Como Rodar a Aplicação:

Para rodar a aplicação, siga os passos abaixo:

1. Clone o repositório do projeto para o seu ambiente local.
2. Certifique-se de ter o Java JDK e o Spring Boot instalados em sua máquina.
3. Abra o terminal e navegue até o diretório onde está o projeto.
4. Abra o projeto na sua IDE de preferencia.
5. Baixe as dependências do Maven utilizando o comando: `mvn clean install`.
6. Rode a classe `LojaDeBrinquedosApplication.java`
7. Use o `-Dspring.profiles.active=local` caso queira rodar em um ambiente de desenvolvimento com um banco de dados em memória (H2).
8. Acesse a documentação da API usando o endereço: http://localhost:8080/loja-de-brinquedos/swagger-ui/swagger-ui/index.html.
9. Utilize a interface do swagger para facilitar as chamadas ;)

## Documentação da API:

Aqui estão listados todos os endpoints disponíveis na API de acordo com os domínios do software:

#### Brinquedo
1. POST `/brinquedo`: Adiciona um novo registro de brinquedo.
2. GET  `/brinquedo`: Lista os brinquedos da base de dados.
3. GET  `/brinquedo/{id}`: Busca um brinquedo na base de dados.
4. PUT `/brinquedo/{id}`: Atualiza um brinquedo na base de dados.
5. DELETE `/brinquedo/{ìd}`: Deleta um brinquedo da base de dados.
