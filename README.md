# ToDoList - API com Autenticação JWT

Este é um projeto de API REST para gerenciar uma lista de tarefas (**ToDoList**), desenvolvido em **Java com Spring Boot**.

---

## ✅ Funcionalidades

- Cadastro de usuários (**nome**, **email** e **senha**);
- Autenticação de usuários (**login**) com geração de token **JWT**;
- Acesso a rotas protegidas mediante envio do token JWT no Header;
- Cadastro, listagem e manipulação de tarefas (**ToDoList**) em rotas protegidas.

---

## ✅ Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Spring Security
- JWT (JSON Web Token)
- H2 Database (banco de dados em memória para testes)
- Maven

---

## ✅ Como Executar o Projeto

1. Clone este repositório ou extraia o ZIP.
2. Importe no seu IDE preferido (Eclipse, IntelliJ, VS Code).
3. Execute a aplicação na classe principal (`@SpringBootApplication`).
4. Acesse o **H2 Console** (caso deseje):
   - URL: `http://localhost:8080/h2-console`
   - JDBC URL: `jdbc:h2:mem:testdb`
   - Usuário: `sa`
   - Senha: *(vazia)*
5. Teste as rotas usando **Postman** ou outro cliente HTTP.

---

## ✅ Principais Endpoints

| Método | Rota             | Descrição                          |
|--------|------------------|-----------------------------------|
| POST   | `/usuarios`      | Cadastrar novo usuário             |
| POST   | `/auth/login`    | Autenticar e obter token JWT       |
| GET/POST/PUT/DELETE | `/todolist` | Rotas protegidas (JWT obrigatório) |

---

## ✅ Exemplo de Login

### Requisição (JSON):
```json
{
  "email": "seuemail@exemplo.com",
  "senha": "suasenha"
}
## ✅ Resposta (JSON):

{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6..."
}

✅ Como Utilizar o Token JWT nas Rotas Protegidas
Após o login, copie o token JWT recebido e envie no Header Authorization de cada requisição protegida:

Authorization: Bearer SEU_TOKEN_AQUI

✅ Observação Importante

A lógica de autenticação JWT foi implementada com ajuda da GPT (ChatGPT), conforme solicitado pelo autor deste projeto.

✅ Licença

Este projeto foi desenvolvido para fins de estudo e prática.
