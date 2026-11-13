# 📝 Caderno de Exercícios & Desafios: Aula 04 (Exceptions)

Aprenda a construir sistemas resilientes e tolerantes a falhas praticando os exercícios abaixo.

---

## 🎯 Exercício 01: Validador de Idade para Cadastro de Motorista

### Cenário
Em um sistema de locação de veículos ou aplicativo de transporte, o motorista precisa obrigatoriamente ter pelo menos 18 anos.

### Requisitos:
1. Crie uma exceção personalizada `IdadeInvalidaException` que herde de `Exception`.
2. Crie uma classe `ValidadorMotorista` com o método:
   ```java
   public static void validarIdade(int idade) throws IdadeInvalidaException
   ```
3. Se a idade for menor que 18, dispare a exceção com uma mensagem explicativa.
4. No método `main`, simule a chamada com idades válidas e inválidas dentro de um bloco `try-catch`.

---

## 🎯 Exercício 02: Calculadora Segura com Múltiplos `catch`

Construa uma rotina que receba duas strings digitadas pelo usuário, faça a conversão para inteiros e efetue a divisão:
- Capture `NumberFormatException` caso o usuário digite letras ou símbolos.
- Capture `ArithmeticException` caso o denominador seja zero.
- Utilize um bloco `finally` para imprimir `"Operação finalizada"`.

---

## 🚀 Desafio Backend: Sistema de Login com Bloqueio por Tentativas

Modele uma classe `Autenticador` que:
1. Receba usuário e senha.
2. Dispare `UsuarioNaoEncontradoException` se o usuário não existir.
3. Dispare `SenhaIncorretaException` caso a senha esteja errada.
4. Se o usuário errar a senha 3 vezes consecutivas, dispare `ContaBloqueadaException`.

---

## 🧠 Quiz de Fixação

1. **Qual bloco é executado SEMPRE, independentemente de ter ocorrido uma exceção ou não?**
   - (A) `catch`
   - (B) `try`
   - (C) `finally` *(Correta)*

2. **Qual é a diferença entre `throw` e `throws`?**
   - (A) `throw` é usado para disparar uma exceção no corpo do método; `throws` é usado na assinatura para avisar que o método pode disparar aquela exceção. *(Correta)*
   - (B) Não há diferença, são sinônimos.
   - (C) `throws` lança o erro e `throw` captura.

3. **Por que erros da classe `Error` (como `OutOfMemoryError`) não devem ser capturados com `catch`?**
   - (A) Porque representam falhas graves e irrecuperáveis da Máquina Virtual Java (JVM) onde a memória ou integridade do sistema operacional se esgotou. *(Correta)*
   - (B) Porque o compilador proíbe a palavra Error.
   - (C) Porque eles não herdam de Throwable.

