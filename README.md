# ForumHub

ForumHub é uma aplicação de fórum desenvolvida utilizando **Java 21** e **Spring Boot**. Ela oferece funcionalidades para o gerenciamento de postagens, autenticação com JWT, e segurança usando Spring Security.

[**Acessar Repositório no GitHub**](https://github.com/IsacGama/forumhub)

## Tecnologias

- **Java 21**
- **Spring Boot** (com Spring Security)
- **JWT** (JSON Web Token)
- **MySQL** (Banco de dados)
- **Spring Data JPA**
- **Spring Web**

## Funcionalidades

ForumHub oferece as seguintes funcionalidades:

- **Autenticação**: Login via usuário e senha, gerando um token JWT para autenticação em endpoints protegidos.
- **Postagens**: Criação, listagem, atualização e exclusão de postagens com controle de acesso.
- **Segurança**: Utiliza JWT para autenticação e Spring Security para proteger os endpoints.

## Endpoints

### Autenticação

#### `POST /login`
Efetua login e retorna o token JWT.

**Requisição:**

```json
{
  "login": "usuario@example.com",
  "senha": "senha123"
}
```
Resposta:
```json
{
  "token": "jwt_token_aqui"
}
```
### Postagens
- **POST /topicos**: Criar uma nova postagem.
- **GET /topicos**: Listar postagens com paginação.
- **GET /topicos/{id}**: Detalhar uma postagem específica.
- **PUT /topicos/{id}**: Atualizar uma postagem existente (somente o autor pode editar).
- **DELETE /topicos/{id}**: Excluir uma postagem (somente o autor pode excluir).

### Como rodar o projeto
- Clone este repositório.

- Configure o banco de dados MySQL e a URL do banco em application.properties.

- Execute o comando para rodar o projeto:

```bash
./mvnw spring-boot:run
```
#### A aplicação estará disponível em http://localhost:8080.
#### Configuração de Banco de Dados
```properties
spring.datasource.url=${URL_MYSQL_FORUMHUB}
spring.datasource.username=${USER_MYSQL_FORUMHUB}
spring.datasource.password=${PASS_MYSQL_FORUMHUB}

spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

server.error.include-stacktrace=always

api.security.token.secret=${JWT_SECRET:12345678}
```
Desenvolvido por Isac Gama.
