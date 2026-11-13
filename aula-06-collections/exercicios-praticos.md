# 📝 Caderno de Exercícios & Desafios: Aula 06 (Collections)

Exercícios práticos para fixar a manipulação de listas, conjuntos e dicionários no Java.

---

## 🎯 Exercício 01: Filtro de Nomes Únicos em um Sorteio

### Cenário
Em uma promoção no Instagram, muitos seguidores comentaram várias vezes na postagem. Para que o sorteio seja justo, cada pessoa só pode concorrer uma única vez.

### Requisitos:
1. Receba uma `List<String>` contendo todos os comentários brutos (com muitos nomes repetidos).
2. Converta essa lista para uma estrutura que elimine automaticamente todas as duplicatas (`Set<String>`).
3. Imprima a quantidade de participantes únicos e a lista sem repetições.

### 💻 Resolução Sugerida:
```java
List<String> participantesBrutos = List.of("arthur", "maria", "arthur", "pedro", "maria", "lucas");
Set<String> participantesUnicos = new HashSet<>(participantesBrutos);

System.out.println("Total de comentários: " + participantesBrutos.size());
System.out.println("Total de pessoas únicas: " + participantesUnicos.size());
```

---

## 🎯 Exercício 02: Dicionário de Sinônimos ou Tradutor com `Map`

Crie um pequeno dicionário Português -> Inglês utilizando `Map<String, String>`:
- Cadastre pelo menos 5 palavras.
- Peça ao usuário uma palavra em português e retorne a tradução em inglês usando `.getOrDefault()`.

---

## 🚀 Desafio Backend: Gerenciador de Inventário em Memória

Crie uma classe `EstoqueRepository` que gerencie produtos utilizando um `Map<Integer, Produto>` onde a chave é o ID do produto:
1. Método `salvar(Produto p)`: insere ou atualiza o produto no mapa.
2. Método `buscarPorId(int id)`: retorna o produto ou `null`.
3. Método `remover(int id)`: remove o item do estoque.
4. Método `listarTodos()`: retorna uma `List<Produto>` com todos os itens armazenados.

---

## 🧠 Quiz de Fixação

1. **Qual coleção NÃO permite a inserção de elementos duplicados?**
   - (A) `ArrayList`
   - (B) `Set` (como `HashSet`) *(Correta)*
   - (C) `Vector`

2. **Para implementar uma tabela de busca rápida por CPF ou Chave Pix, qual estrutura é ideal?**
   - (A) `Map<String, Usuario>` (como `HashMap`) *(Correta)*
   - (B) `int[]`
   - (C) `Stack`

3. **Qual é a principal vantagem dos Generics (`List<String>`) sobre listas antigas sem tipo?**
   - (A) Evitar erros de tipo (`ClassCastException`) em tempo de execução, garantindo verificação rigorosa já na compilação. *(Correta)*
   - (B) Deixar o código Java compilado compatível com JavaScript.
   - (C) Economizar espaço em disco no código-fonte.

