# ⚔️ Projeto Prático: Simulador de Combate em Turnos

Este projeto é um jogo de arena em modo texto desenvolvido em Java puro. Ele coloca dois personagens para lutar em rodadas consecutivas até que o HP de um deles se esgote.

---

## 🎯 Conceitos de Orientação a Objetos Aplicados

1. **Abstração:** Modelagem da entidade `Personagem` com atributos essenciais (`nome`, `vida`, `ataque`, `defesa`) e ações (`atacar`, `mostrarStatus`, `estaVivo`).
2. **Encapsulamento:** Atributos privados protegidos contra manipulação direta externa. O acesso e alteração do HP acontecem estritamente dentro da regra de negócio do método `atacar()`.
3. **Pseudoaleatoriedade (`java.util.Random`):** Cada instância de personagem sorteia valores dinâmicos de poder ofensivo e defensivo durante sua criação via construtor.
4. **Game Loop:** Laço de repetição `while` gerenciando turnos alternados e verificando condições de parada e vitória.

---

## 📐 Regras de Negócio e Cálculo de Dano

$$\text{Dano Líquido} = \max(0, \text{Ataque}_{\text{atacante}} - \text{Defesa}_{\text{defensor}})$$

- Se o ataque for de 25 e a defesa do oponente for de 12, o dano aplicado é de 13 HP.
- Se a defesa for superior ou igual ao ataque, o dano é zerado (evitando que o ataque restaure vida do oponente).

---

## 🚀 Como Executar

No diretório deste projeto:

```bash
# Compilar os arquivos
javac Personagem.java Main.java

# Executar a batalha
java Main
```

---

## 📊 Estrutura de Arquivos

| Arquivo | Descrição |
|---|---|
| `Personagem.java` | Entidade que encapsula vida, atributos e método de ataque |
| `Main.java` | Classe executável contendo o laço de batalha por turnos |
| `README.md` | Documentação explicativa do projeto |
