📝 ToDoList API
API REST para gerenciamento de tarefas pessoais, construída com Spring Boot.

✅ Funcionalidades
Criar tarefas

Listar todas as tarefas

Buscar tarefa por ID

Filtrar tarefas por status

Excluir tarefas

🔧 Tecnologias
Java 17+

Spring Boot

Spring Data JPA

H2 (banco em memória)

ModelMapper (conversão DTO ↔ Entidade)

Maven

📦 Instalação
bash
Copiar
Editar
git clone https://github.com/seu-usuario/ToDoList.git
cd ToDoList
./mvnw spring-boot:run
📁 Estrutura de Pacotes
controller: Camada de controle (REST API)

service: Regras de negócio

repository: Interface com o banco de dados

dto: Objetos de transferência de dados

entity: Entidades JPA

enums: Enums para status, categoria, prioridade

🔄 Exemplo de Requisição JSON
Criar nova tarefa (POST /todolist)
json
Copiar
Editar
{
  "data": "05/07/2025",
  "categoria": "TRABALHO",
  "prioridade": "ALTA",
  "status": "PENDENTE"
}
Retorno:
json
Copiar
Editar
{
  "id": 1,
  "data": "05/07/2025",
  "categoria": "TRABALHO",
  "prioridade": "ALTA",
  "status": "PENDENTE"
}
📊 StatusEnums disponíveis:
PENDENTE

EM_ANDAMENTO

CONCLUIDO

📫 Contato
Desenvolvido por Rafael Maranduba.
