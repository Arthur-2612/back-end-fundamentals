# ☕ Back-End Java Fundamentals

[![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)](https://spring.io/projects/spring-boot)
[![Git](https://img.shields.io/badge/Git-F05032?style=for-the-badge&logo=git&logoColor=white)](https://git-scm.com/)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg?style=for-the-badge)](LICENSE)

> Repositório completo de estudos, exemplos práticos e projetos da disciplina de **Desenvolvimento Back-End em Java**, estruturado de forma didática, progressiva e alinhada às melhores práticas de engenharia de software e padrões de mercado.
>
> 🌐 **Ementa de Referência:** [Notion - Desenvolvimento Back-End JAVA](https://cainaantunes.notion.site/Desenvolvimento-Back-End-JAVA-3aea95f36a1d4097b6e680c57aed0403)

---

## 🎯 Sobre o Repositório

O objetivo deste repositório é consolidar a jornada de aprendizado em desenvolvimento back-end com Java, partindo dos fundamentos filosóficos da Programação Orientada a Objetos (POO) até a construção de arquiteturas modernas em camadas com o framework **Spring Boot**.

Cada módulo do curso conta com uma pasta individualizada contendo exatamente:
1. 📘 **README.md:** Um guia teórico aprofundado ("resumão"), didático e ricamente documentado com diagramas conceituais.
2. ☕ **Código Java Explicativo (`.java`):** Implementação prática, limpa e comentada linha a linha, pronta para compilação e execução.
3. 📝 **Caderno de Exercícios Práticos (`exercicios-praticos.md`):** Questões conceituais, desafios de código e gabaritos com soluções detalhadas.

---

## 🗺️ Mapa da Jornada de Aprendizado

```mermaid
flowchart TD
    subgraph Fundamentos_POO ["Fundamentos e Sintaxe"]
        A1["Aula 01: Paradigma POO"] --> A2["Aula 02: Classes, Atributos e Métodos"]
        A2 --> A3["Aula 03: Classes Padrão do Java"]
    end

    subgraph Robustez_Avancada ["Robustez e Estruturas"]
        A3 --> A4["Aula 04: Tratamento de Exceções"]
        A4 --> A5["Aula 05: Herança e Polimorfismo"]
        A5 --> A6["Aula 06: Collections & Generics"]
    end

    subgraph Arquitetura_Empresarial ["Arquitetura e Frameworks"]
        A6 --> A7["Aula 07: Relações Entre Classes"]
        A7 --> A8["Aula 08: Arquitetura MVC & DAO"]
        A8 --> A9["Aula 09: Spring Boot & APIs RESTful"]
    end

    style Fundamentos_POO fill:#f0f4f8,stroke:#2b6cb0,stroke-width:2px
    style Robustez_Avancada fill:#e6fffa,stroke:#319795,stroke-width:2px
    style Arquitetura_Empresarial fill:#faf5ff,stroke:#805ad5,stroke-width:2px
```

---

## 📚 Índice Completo das Aulas

Navegue diretamente pelos módulos de estudo utilizando os links abaixo:

| Aula | Tema Central | Resumo Teórico | Código Comentado | Exercícios & Desafios |
|:---:|---|:---:|:---:|:---:|
| **01** | **Paradigma POO & Pilares** | [📘 Resumo Aula 01](aula-01-paradigma-poo/README.md) | [☕ ExemploAula01.java](aula-01-paradigma-poo/ExemploAula01.java) | [📝 Exercícios 01](aula-01-paradigma-poo/exercicios-praticos.md) |
| **02** | **Classes, Construtores & Encapsulamento** | [📘 Resumo Aula 02](aula-02-classes-atributos-metodos/README.md) | [☕ ExemploAula02.java](aula-02-classes-atributos-metodos/ExemploAula02.java) | [📝 Exercícios 02](aula-02-classes-atributos-metodos/exercicios-praticos.md) |
| **03** | **Classes Utilitárias: String, Math, Random & GUI** | [📘 Resumo Aula 03](aula-03-classes-java/README.md) | [☕ ExemploAula03.java](aula-03-classes-java/ExemploAula03.java) | [📝 Exercícios 03](aula-03-classes-java/exercicios-praticos.md) |
| **04** | **Tratamento Defensivo de Exceções** | [📘 Resumo Aula 04](aula-04-tratamento-de-excecoes/README.md) | [☕ ExemploAula04.java](aula-04-tratamento-de-excecoes/ExemploAula04.java) | [📝 Exercícios 04](aula-04-tratamento-de-excecoes/exercicios-praticos.md) |
| **05** | **Herança, Classes Abstratas & Polimorfismo** | [📘 Resumo Aula 05](aula-05-heranca-e-polimorfismo/README.md) | [☕ ExemploAula05.java](aula-05-heranca-e-polimorfismo/ExemploAula05.java) | [📝 Exercícios 05](aula-05-heranca-e-polimorfismo/exercicios-praticos.md) |
| **06** | **Java Collections Framework & Generics** | [📘 Resumo Aula 06](aula-06-collections-e-listas/README.md) | [☕ ExemploAula06.java](aula-06-collections-e-listas/ExemploAula06.java) | [📝 Exercícios 06](aula-06-collections-e-listas/exercicios-praticos.md) |
| **07** | **Relacionamentos, UML & Cardinalidade** | [📘 Resumo Aula 07](aula-07-relacionamento-entre-classes/README.md) | [☕ ExemploAula07.java](aula-07-relacionamento-entre-classes/ExemploAula07.java) | [📝 Exercícios 07](aula-07-relacionamento-entre-classes/exercicios-praticos.md) |
| **08** | **Padrão MVC, DAO & Persistência** | [📘 Resumo Aula 08](aula-08-arquitetura-mvc/README.md) | [☕ ExemploAula08.java](aula-08-arquitetura-mvc/ExemploAula08.java) | [📝 Exercícios 08](aula-08-arquitetura-mvc/exercicios-praticos.md) |
| **09** | **Spring Boot, IoC, DI & APIs REST** | [📘 Resumo Aula 09](aula-09-spring-e-springboot/README.md) | [☕ ExemploAula09.java](aula-09-spring-e-springboot/ExemploAula09.java) | [📝 Exercícios 09](aula-09-spring-e-springboot/exercicios-praticos.md) |

---

## 🛠️ Projetos Práticos Integrados

Além das aulas teóricas e exercícios, o repositório conta com projetos aplicados desenvolvidos durante o semestre:

| Projeto | Tecnologia / Conceito | Descrição | Acesso |
|---|---|---|:---:|
| **Simulador de Luta** | POO, Random, Game Loop | Jogo em modo texto com combates medievais em turnos e cálculo dinâmico de dano. | [Visualizar Projeto](projetos-praticos/simulador-luta/README.md) |
| **Gerenciador de Arquivos** | Encapsulamento, Pacotes, Swing | Sistema de arquivos virtual em memória com cálculo dinâmico de bits e diálogo gráfico. | [Visualizar Projeto](projetos-praticos/gerenciador-arquivos/README.md) |
| **Mini-Projeto ScreenSaver** | Herança, Polimorfismo, Swing 2D | Protetor de tela animado em 60 FPS com formas polimórficas e física de colisão. | [Visualizar Projeto](projetos-praticos/screensaver/README.md) |

---

## 💻 Como Compilar e Executar os Exemplos

Todos os códigos foram projetados para rodar sem dependências externas adicionais, utilizando apenas o JDK nativo (Java 17 ou superior recomendado).

### 1. Clonar o repositório
```bash
git clone https://github.com/Arthur-2612/back-end-fundamentals.git
cd back-end-fundamentals
```

### 2. Compilar e executar qualquer aula
Exemplo com a **Aula 05 (Herança e Polimorfismo)**:
```bash
cd aula-05-heranca-e-polimorfismo
javac ExemploAula05.java
java ExemploAula05
```

Exemplo com o **Simulador de Combate**:
```bash
cd projetos-praticos/simulador-luta
javac Personagem.java Main.java
java Main
```

---

## 📌 Padrão de Commits Adotado

O repositório adota a convenção internacional de [Conventional Commits](https://www.conventionalcommits.org/pt-br/v1.0.0/):

- `feat:` Inclusão de novas implementações de código ou projetos.
- `docs:` Criação ou enriquecimento de documentações, resumos de aula e listas de exercícios.
- `refactor:` Melhorias estruturais em código existente sem alterar comportamento funcional.
- `chore:` Configurações auxiliares, ajustes de `.gitignore` ou manutenção de repositório.

---

## 👨‍💻 Autor

Desenvolvido por **Arthur Silva**  
Repositório mantido como portfólio profissional de estudos em desenvolvimento back-end e engenharia de software Java.
