<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ForumHub - README</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f4f4f9;
            color: #333;
            margin: 0;
            padding: 0;
            line-height: 1.6;
        }
        h1, h2 {
            color: #007bff;
        }
        h3 {
            margin-top: 30px;
            color: #444;
        }
        pre {
            background-color: #2e2e2e;
            color: #fff;
            padding: 10px;
            border-radius: 5px;
            overflow-x: auto;
            white-space: pre-wrap;
            word-wrap: break-word;
        }
        .container {
            width: 80%;
            margin: 20px auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
        }
        .section {
            margin-bottom: 20px;
        }
        .section p {
            font-size: 1.1em;
        }
        .header {
            text-align: center;
            margin-bottom: 40px;
        }
        .btn {
            background-color: #007bff;
            color: white;
            padding: 10px 20px;
            text-decoration: none;
            border-radius: 5px;
            font-size: 1.1em;
        }
        .btn:hover {
            background-color: #0056b3;
        }
        ul {
            list-style-type: square;
        }
    </style>
</head>
<body>

<div class="container">
    <div class="header">
        <h1>ForumHub</h1>
        <p>Uma aplicação de fórum desenvolvida com <strong>Java 21</strong> e Spring Boot</p>
        <a href="https://github.com/seu-usuario/forumhub" class="btn">Acessar Repositório no GitHub</a>
    </div>

    <div class="section">
        <h2>Tecnologias</h2>
        <ul>
            <li><strong>Java 21</strong></li>
            <li><strong>Spring Boot</strong> (com Spring Security)</li>
            <li><strong>JWT</strong> (JSON Web Token)</li>
            <li><strong>MySQL</strong> (Banco de dados)</li>
            <li><strong>Spring Data JPA</strong></li>
            <li><strong>Spring Web</strong></li>
        </ul>
    </div>

    <div class="section">
        <h2>Funcionalidades</h2>
        <p>ForumHub oferece as seguintes funcionalidades:</p>
        <ul>
            <li><strong>Autenticação:</strong> Login via usuário e senha, gerando um token JWT para autenticação em endpoints protegidos.</li>
            <li><strong>Postagens:</strong> Criação, listagem, atualização e exclusão de postagens com controle de acesso.</li>
            <li><strong>Segurança:</strong> Utiliza JWT para autenticação e Spring Security para proteger os endpoints.</li>
        </ul>
    </div>

    <div class="section">
        <h2>Endpoints</h2>
        
        <h3>Autenticação</h3>
        <p><strong>POST /login</strong>: Efetuar login e obter o token JWT.</p>
        <pre>
{
  "login": "usuario@example.com",
  "senha": "senha123"
}
        </pre>
        <p><strong>Resposta:</strong></p>
        <pre>
{
  "token": "jwt_token_aqui"
}
        </pre>

        <h3>Postagens</h3>
        <ul>
            <li><strong>POST /topicos</strong>: Criar uma nova postagem.</li>
            <li><strong>GET /topicos</strong>: Listar postagens com paginação.</li>
            <li><strong>GET /topicos/{id}</strong>: Detalhar uma postagem específica.</li>
            <li><strong>PUT /topicos/{id}</strong>: Atualizar uma postagem existente (somente o autor pode editar).</li>
            <li><strong>DELETE /topicos/{id}</strong>: Excluir uma postagem (somente o autor pode excluir).</li>
        </ul>
    </div>

    <div class="section">
        <h2>Como rodar o projeto</h2>
        <ol>
            <li>Clone este repositório.</li>
            <li>Configure o banco de dados MySQL e a URL do banco em <code>application.properties</code>.</li>
            <li>Execute o comando para rodar o projeto:</li>
        </ol>
        <pre>./mvnw spring-boot:run</pre>
        <p>A aplicação estará disponível em <strong>http://localhost:8080</strong>.</p>
    </div>

    <div class="section">
        <h2>Configuração de Banco de Dados</h2>
        <pre>
spring.datasource.url=${URL_MYSQL_FORUMHUB}
spring.datasource.username=${USER_MYSQL_FORUMHUB}
spring.datasource.password=${PASS_MYSQL_FORUMHUB}

spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

server.error.include-stacktrace=always

api.security.token.secret=${JWT_SECRET:12345678}
        </pre>
    </div>

    <div class="section">
        <h2>Contribuições</h2>
        <p>Se você deseja contribuir com o projeto, sinta-se à vontade para enviar um pull request. Qualquer contribuição será bem-vinda!</p>
    </div>
</div>

</body>
</html>
