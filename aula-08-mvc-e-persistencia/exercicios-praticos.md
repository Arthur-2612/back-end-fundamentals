# 📝 Caderno de Exercícios & Desafios: Aula 08 (Arquitetura MVC)

Treine o pensamento arquitetural corporativo e a divisão estrita de responsabilidades entre camadas de software.

---

## 🎯 Exercício 01: Identificação e Refatoração de Violações Arquiteturais

### Cenário
Analise o trecho de código abaixo e identifique **3 violações graves de arquitetura**:

```java
// Código problemático encontrado em um projeto legado:
public class ProdutoView {
    public void cadastrar() {
        Scanner s = new Scanner(System.in);
        System.out.println("Digite o nome:");
        String nome = s.nextLine();
        
        // ❌ Problema 1: Cálculo e validação de negócio dentro da View!
        double preco = 100.0 * 1.15; 
        
        // ❌ Problema 2: Conexão direta com Banco / Arquivo dentro da tela!
        try (FileWriter fw = new FileWriter("produtos.txt", true)) {
            fw.write(nome + ";" + preco + "\n");
        } catch (Exception e) {}
    }
}
```

### Explicação da Correção:
1. A **View** deve apenas capturar o texto digitado e repassar para o `ProdutoController`.
2. O acréscimo de 15% deve ser responsabilidade exclusiva do `ProdutoService`.
3. A escrita no arquivo deve ser encapsulada dentro de um `ProdutoRepository`.

---

## 🚀 Desafio Prático: Adicionando Exclusão na Arquitetura MVC

Expanda o projeto da Aula 08 implementando o fluxo de exclusão de tarefas:
1. No `TarefaRepository`: crie o método `boolean excluir(int id)` que remove a tarefa da lista e atualiza o arquivo em disco.
2. No `TarefaService`: crie o método `boolean removerTarefa(int id)` validando se a tarefa realmente existe antes de solicitar a remoção.
3. No `TarefaController`: crie o método `void processarExclusao(int id)` que retorna mensagens claras de sucesso ou erro para a View.

---

## 🧠 Quiz de Fixação

1. **Qual é a principal responsabilidade da camada Service no padrão em camadas?**
   - (A) Renderizar janelas com botões coloridos.
   - (B) Conter e aplicar as regras de negócio do sistema (validações, cálculos, decisões). *(Correta)*
   - (C) Executar o comando git commit.

2. **O que é o padrão DAO (Data Access Object) / Repository?**
   - (A) Um componente que isola e centraliza todos os comandos de acesso e persistência a dados (bancos, arquivos). *(Correta)*
   - (B) Um tipo especial de loop for.
   - (C) Um antivírus do Java.

3. **Por que o padrão MVC facilita a criação de testes de software?**
   - (A) Porque como as regras de negócio estão isoladas no Service, podemos testá-las sem precisar abrir telas ou digitar no terminal. *(Correta)*
   - (B) Porque testes só rodam em arquivos chamados Model.
   - (C) Porque ele apaga o banco de dados a cada teste.

