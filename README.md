# Backend em Java

Repositório de estudos e exercícios das aulas de desenvolvimento backend em Java.

> Fonte de estudo: https://cainaantunes.notion.site/Desenvolvimento-Back-End-JAVA-3aea95f36a1d4097b6e680c57aed0403

---

## Objetivo

Aprender os fundamentos do Java para construir aplicações backend, começando pela lógica de programação orientada a objetos.

---

## Aula 01 - Paradigma POO

A Programação Orientada a Objetos (POO) é um paradigma de desenvolvimento que organiza o código em torno de objetos, que representam elementos do mundo real ou da lógica de negócio de um sistema. Em vez de escrever programas apenas como sequências de instruções, a POO busca modelar entidades com características próprias e comportamentos específicos.

### Conceitos fundamentais

- Classe: é o molde ou projeto que define as propriedades e ações de um tipo de objeto.
- Objeto: é a instância concreta de uma classe, ou seja, uma representação real criada a partir do molde.
- Atributos: são as características do objeto, como nome, idade, salário, velocidade, vida, etc.
- Métodos: são as ações que o objeto consegue realizar, como andar, atacar, calcular, salvar, etc.

### Por que a POO é importante?

A POO foi criada para facilitar a organização, a manutenção e a reutilização de código em sistemas maiores. Quando um sistema cresce, o uso de funções isoladas pode tornar o código difícil de entender e de evoluir. A POO ajuda a dividir o problema em partes menores, tornando a lógica mais clara e estruturada.

### Exemplo prático

Imagine a entidade `Carro`:

```java
public class Carro {
    String modelo;
    String cor;
    int velocidade;

    public void acelerar() {
        velocidade += 10;
    }

    public void frear() {
        velocidade -= 10;
    }
}
```

A partir dessa classe, podemos criar vários objetos diferentes:

```java
Carro carro1 = new Carro();
Carro carro2 = new Carro();
```

Cada objeto pode ter seus próprios valores de atributos, mesmo sendo do mesmo tipo.

### Vantagens da POO

- reutilização de código
- organização do projeto em partes menores
- fácil manutenção e expansão
- modelagem mais próxima da realidade
- melhor entendimento do sistema

### Conclusão

A Aula 01 introduz a ideia central de que, em Java, o código é construído a partir de objetos, e esses objetos representam partes do sistema com suas próprias propriedades e ações. Esse conceito é a base para desenvolver aplicações mais organizadas e escaláveis.

---

## Aula 02 - Estrutura de uma Classe Java

A estrutura básica de uma classe em Java é a base para qualquer projeto.

```java
public class Exemplo {
    // atributos

    public static void main(String[] args) {
        // execução
    }
}
```

### O que aprendemos:
- como declarar uma classe
- como criar atributos e métodos
- a importância do método `main`
- a relação entre nome da classe e nome do arquivo

Essencialmente, uma classe define o que um objeto sabe e o que ele pode fazer.

---

## Aula 03 - Classes Java

Nesta aula, o foco foi em entender melhor como as classes funcionam na prática em Java. Uma classe é um modelo que define as características e os comportamentos de um tipo de objeto. Ela funciona como um "molde" para criar instâncias que terão seus próprios valores.

```java
public class Personagem {
    String nome;
    int vida;
    int ataque;

    public void atacar() {
        System.out.println(nome + " atacou!");
    }

    public void mostrarStatus() {
        System.out.println("Nome: " + nome);
        System.out.println("Vida: " + vida);
    }
}
```

### O que uma classe contém?

- Atributos: representam dados do objeto. No exemplo acima, `nome`, `vida` e `ataque` são atributos.
- Métodos: representam ações que o objeto pode realizar, como `atacar()` e `mostrarStatus()`.
- Construtor: é um método especial usado para inicializar o objeto quando ele é criado.

### Criação de objetos

Depois de criar a classe, podemos criar objetos a partir dela:

```java
Personagem p1 = new Personagem();
p1.nome = "Arthur";
p1.vida = 100;
p1.ataque = 20;

Personagem p2 = new Personagem();
p2.nome = "Goblin";
p2.vida = 80;
p2.ataque = 15;
```

Mesmo sendo da mesma classe, cada objeto pode ter valores diferentes em seus atributos.

### Importância da classe

As classes permitem:

- organizar o código em partes lógicas
- representar objetos do mundo real ou da regra de negócio
- reutilizar o mesmo modelo várias vezes
- criar sistemas mais claros e escaláveis

### Relação entre classes e objetos

A classe define a estrutura. O objeto é a execução dessa estrutura.

Exemplo:
- `Personagem` é a classe
- `p1` e `p2` são objetos criados a partir dessa classe

### Conclusão

A aula 03 mostra que uma classe é o coração da programação orientada a objetos em Java. Ela reúne dados e comportamentos em uma única estrutura, permitindo criar vários objetos com o mesmo comportamento, mas com valores diferentes.

---

## Aula 03B - Sobrecarga e Exceções

Além das classes, aprendemos dois conceitos fundamentais:

### 1. Sobrecarga de métodos
Quando uma classe tem métodos com o mesmo nome, mas com parâmetros diferentes.

```java
public void calcular() { }
public void calcular(int valor) { }
```

Isso permite usar o mesmo nome para diferentes situações, deixando o código mais flexível.

### 2. Exceções
Erros que acontecem durante a execução do programa.

```java
try {
    // código perigoso
} catch (Exception e) {
    // tratar erro
}
```

Aprendemos que o programa precisa lidar com erros para não quebrar de forma inesperada.

---

## Estrutura do repositório

- `Aula_02/` - exercícios de estrutura e lógica Java
- `POO_aula1/` - introdução à POO
- `Arquivo_back/` - arquivos e materiais de apoio
- `luta/` - projeto prático de simulação de luta

---

## Próximos passos

Este README será atualizado conforme cada nova aula for concluída. A ideia é registrar o conteúdo aprendido e manter o repositório como portfolio de estudos.
