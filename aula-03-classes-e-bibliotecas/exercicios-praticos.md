# 📝 Caderno de Exercícios & Desafios: Aula 03 (Bibliotecas Padrão)

Aprimore suas habilidades de manipulação textual, matemática e aleatoriedade com os exercícios a seguir.

---

## 🎯 Exercício 01: Sanitizador de Cadastro de Usuário

### Cenário
Em sistemas backend, os usuários frequentemente enviam nomes com espaços acidentais e formatações inconsistentes (ex: `"  joao da SILVA  "`).

### Requisitos:
Crie um método estático `sanitizarNome(String entrada)` que:
1. Remova espaços em branco excedentes nas extremidades (`trim()`).
2. Converta tudo para letras minúsculas.
3. Garanta que o nome comece com a primeira letra maiúscula.
4. Retorne o nome formatado.

### 💻 Resolução Sugerida:
```java
public class FormatadorUtil {
    public static String sanitizarNome(String entrada) {
        if (entrada == null || entrada.trim().isEmpty()) {
            return "";
        }
        String limpo = entrada.trim().toLowerCase();
        return limpo.substring(0, 1).toUpperCase() + limpo.substring(1);
    }
}
```

---

## 🎲 Exercício 02: Gerador de Token Aleatório de 6 Dígitos

### Cenário
Para autenticação em duas etapas (2FA) e recuperação de senhas, precisamos gerar códigos numéricos aleatórios de 6 dígitos (de 100000 até 999999).

```java
import java.util.Random;

public class TokenService {
    public static int gerarToken2FA() {
        Random random = new Random();
        // 900.000 possibilidades começando em 100.000 garante 6 dígitos
        return 100000 + random.nextInt(900000);
    }
}
```

---

## 🚀 Desafio Prático: O Jogo do Adivinhe o Número

Desenvolva um programa que:
1. Sorteie secretamente um número entre 1 e 50 usando `Random`.
2. Peça palpites ao usuário usando caixas de diálogo `JOptionPane.showInputDialog()`.
3. A cada palpite, informe via `JOptionPane.showMessageDialog()` se o número sorteado é **maior** ou **menor** que a tentativa.
4. Quando o usuário acertar, exiba uma mensagem de comemoração com o número total de tentativas!

---

## 🧠 Quiz de Fixação

1. **Por que a classe `String` é considerada imutável em Java?**
   - (A) Porque seus métodos são todos privados.
   - (B) Porque após instanciada, o seu valor em memória não se altera; qualquer alteração produz uma nova String. *(Correta)*
   - (C) Porque não aceita números.

2. **Como devemos comparar o conteúdo de duas variáveis do tipo `String`?**
   - (A) Usando o operador `==`.
   - (B) Usando o método `.equals()`. *(Correta)*
   - (C) Usando `Math.compare()`.

3. **Para que serve o método estático `Math.pow(2, 3)`?**
   - (A) Para calcular 2 vezes 3.
   - (B) Para calcular 2 elevado à potência 3 ($2^3 = 8$). *(Correta)*
   - (C) Para sortear um número entre 2 e 3.

