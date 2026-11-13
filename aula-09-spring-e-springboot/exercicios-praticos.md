# 📝 Caderno de Exercícios & Desafios: Aula 09 (Spring Boot & REST APIs)

Pratique o desenho de rotas, contratos de API e arquitetura corporativa moderna com o framework Spring.

---

## 🎯 Exercício 01: Desenho de Contrato REST para Gestão de Clientes

### Cenário
Você precisa projetar uma API RESTful para cadastro de clientes (`/api/v1/clientes`).

### Tarefa:
Preencha a matriz de endpoints especificando método HTTP, rota, código de sucesso e descrição:

| Operação | Método HTTP | Rota | Status de Sucesso | Status de Erro |
| :--- | :--- | :--- | :--- | :--- |
| **Listar todos os clientes** | `GET` | `/api/v1/clientes` | `200 OK` | `500 Server Error` |
| **Buscar cliente por ID** | `GET` | `/api/v1/clientes/{id}` | `200 OK` | `404 Not Found` |
| **Cadastrar novo cliente** | `POST` | `/api/v1/clientes` | `201 Created` | `400 Bad Request` |
| **Atualizar dados cadastrais**| `PUT` | `/api/v1/clientes/{id}` | `200 OK` | `404 Not Found` |
| **Excluir cliente** | `DELETE` | `/api/v1/clientes/{id}` | `204 No Content`| `404 Not Found` |

---

## 🚀 Desafio Prático: O Padrão DTO (Data Transfer Object)

### Problema
Por que nunca devemos expor nossas entidades de banco de dados (`@Entity`) diretamente como parâmetros de entrada no `@RestController`?
1. **Segurança (Over-posting Attack):** Um usuário mal-intencionado pode enviar campos que não deveriam ser alterados (ex: `admin: true` ou `saldo: 999999`).
2. **Desacoplamento:** O formato como o dado é salvo no banco não precisa ser idêntico ao formato que o frontend ou mobile consome.

### Solução com DTO:
```java
// DTO de entrada: apenas os campos que o cliente tem permissão de enviar
public record ClienteRequestDTO(
    String nome,
    String email,
    String telefone
) {}
```

---

## 🧠 Quiz de Fixação

1. **O que é Injeção de Dependências (DI)?**
   - (A) Uma falha de segurança provocada por injeção de SQL.
   - (B) Um padrão de projeto onde um framework (como o Spring) fornece as instâncias que uma classe precisa para funcionar, eliminando o uso manual de `new`. *(Correta)*
   - (C) Um script de instalação do Windows.

2. **Qual verbo HTTP deve ser utilizado segundo as boas práticas para CRIAR um novo registro?**
   - (A) `GET`
   - (B) `POST` *(Correta)*
   - (C) `PATCH`

3. **Qual status HTTP indica que o recurso solicitado pelo cliente simplesmente não existe no servidor?**
   - (A) `200 OK`
   - (B) `404 Not Found` *(Correta)*
   - (C) `500 Internal Server Error`

