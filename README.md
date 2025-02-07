# E-Commerce Catalisa

Este projeto é uma **API RESTful** para um sistema básico de E-Commerce. Ele permite o cadastro de produtos, clientes e a realização de compras, com validações e manipulação de dados.

---

## **Funcionalidades**

### **Cadastro de Produtos**
- **Nome**: `String` (não pode ser repetido).
- **Preço**: `Double` (deve ser maior que 0).
- **Quantidade**: `int` (deve ser maior ou igual a 0).
- **Regras**:
  - Não será permitido cadastrar produtos com o mesmo nome.

### **Cadastro de Clientes**
- **Nome**: `String`.
- **CPF**: `String` (único e válido).
- **Email**: `String` (único e válido).
- **Regras**:
  - Não será permitido cadastrar clientes com o mesmo CPF ou Email.

### **Realização de Compras**
- Verifica se o produto está disponível em estoque (quantidade maior que 0).
- Atualiza a quantidade do produto no estoque após a compra.

---

## **Endpoints**

### **Produtos**
- **GET /produtos**  
  Retorna a lista de todos os produtos cadastrados.

- **POST /produtos**  
  Cadastra um novo produto.  
  **Exemplo de Requisição**:
  ```json
  {
    "nome": "Produto A",
    "preco": 100.0,
    "quantidade": 10
  }

DELETE /produtos/{id}

Deleta um produto pelo ID.

GET /produtos/nome/{nome}

Retorna um produto pelo nome.

GET /produtos/{id}

Retorna um produto pelo ID.

Clientes
POST /clientes

Cadastra um novo cliente.

Exemplo de Requisição:


```json
{
  "nome": "João Silva",
  "cpf": "12345678901",
  "email": "joao.silva@email.com"
}
```
GET /clientes/{cpf}

Retorna os dados de um cliente específico pelo CPF.

PUT /clientes/{cpf}

Atualiza os dados de um cliente.

Exemplo de Requisição:
```json
{
  "nome": "João Silva Atualizado",
  "cpf": "12345678901",
  "email": "joao.silva.atualizado@email.com"
}
```
GET /clientes
Retorna a lista de todos os clientes cadastrados.

Compras
POST /compras

Registra uma nova compra e atualiza a quantidade do produto no estoque.
Exemplo de Requisição:
```
{
  "cpfCliente": "12345678901",
  "idProduto": 1,
  "quantidade": 2
}

```

# Regras de Negócio

## Cadastro de Produtos
Não será permitido cadastrar produtos com o mesmo nome.
O preço deve ser maior que 0.
A quantidade deve ser maior ou igual a 0.

## Cadastro de Clientes
Não será permitido cadastrar clientes com o mesmo CPF ou Email.
O CPF deve ser válido.

## Realização de Compras
O sistema deve verificar se o produto está disponível em estoque (quantidade maior que 0).
Caso contrário, deve retornar um erro 400 com a mensagem de que o produto está em falta.
O sistema deve reduzir a quantidade do produto no estoque após a compra.

# Tecnologias Utilizadas
Java 17
Spring Boot
Jakarta Validation
Maven

# Como Executar o Projeto

Clone o repositório:
git clone https://github.com/seu-usuario/ecommerce-api.git
cd ecommerce-api
Compile e execute o projeto:



mvn spring-boot:run
Acesse a API em: http://localhost:8080

# Validações e Tratamento de Erros

## Cadastro de Produtos
Nome duplicado: Retorna erro 400 com a mensagem "Produto com o mesmo nome já cadastrado."
Preço inválido: Retorna erro 400 com a mensagem "O preço deve ser maior que 0."
Quantidade inválida: Retorna erro 400 com a mensagem "A quantidade deve ser maior ou igual a 0."

## Cadastro de Clientes
CPF duplicado: Retorna erro 400 com a mensagem "CPF já cadastrado."
Email duplicado: Retorna erro 400 com a mensagem "Email já cadastrado."
CPF inválido: Retorna erro 400 com a mensagem "CPF inválido."
Email inválido: Retorna erro 400 com a mensagem "Email inválido."

## Realização de Compras
Produto em falta: Retorna erro 400 com a mensagem "Produto em falta no estoque."
Cliente ou Produto não encontrado: Retorna erro 400 com a mensagem correspondente.

# Melhorias Futuras
Implementar autenticação e autorização.
Adicionar paginação nos endpoints de listagem.
Criar testes unitários e de integração.
Adicionar logs para rastreamento de operações.
