# 📝 Caderno de Exercícios & Desafios: Aula 02 (Encapsulamento)

Pratique os conceitos de visibilidade, encapsulamento, construtores e o método `toString()` resolvendo os desafios propostos abaixo.

---

## 🎯 Exercício 01: Modelagem da Classe `Funcionario`

### Contexto
Todo sistema de Recursos Humanos e Folha de Pagamento necessita de controle estrito sobre dados de colaboradores.

### Requisitos:
1. Crie os seguintes atributos privados:
   - `id` (int)
   - `nome` (String)
   - `departamento` (String)
   - `salario` (double)
2. Crie dois construtores:
   - Um que receba todos os atributos.
   - Um sobrecarregado que receba `id`, `nome` e defina departamento como `"Geral"` e salário inicial como `1500.00`.
3. Crie os métodos:
   - `aplicarAumento(double porcentagem)`: aumenta o salário pelo percentual informado (validar se `porcentagem > 0`).
   - `toString()`: retorna os dados legíveis e formatados.
4. **Atenção:** O atributo `id` não deve possuir `setId()` (imutabilidade de chave primária).

---

## 🚀 Desafio Backend: Transferência Bancária entre Contas

### Cenário
Adicione à classe `ContaBancaria` um método que permita transferir um valor de uma conta de origem para uma conta de destino:

```java
public boolean transferir(double valor, ContaBancaria contaDestino) {
    if (this.sacar(valor)) {
        contaDestino.depositar(valor);
        System.out.println("-> [Transferência] R$ " + valor + " transferido de " + this.getTitular() + " para " + contaDestino.getTitular());
        return true;
    }
    System.out.println("-> [Falha] Transferência não realizada por falta de saldo!");
    return false;
}
```

### 💡 Reflexão de Engenharia de Software
Por que a operação acima é vantajosa?
- **Reuso de Regras:** O método `transferir()` não precisou reinventar a lógica de débito ou checagem de saldo; ele simplesmente reutilizou `sacar()` e `depositar()`, mantendo o princípio **DRY** (*Don't Repeat Yourself*).

---

## 🧠 Quiz de Fixação

1. **Por que atributos de entidades devem ser `private`?**
   - (A) Para tornar o código mais lento e seguro.
   - (B) Para proteger os dados contra modificações diretas e arbitrárias, forçando o uso de regras de negócio em métodos públicos. *(Correta)*
   - (C) Porque o Java não permite atributos públicos.

2. **O que acontece se uma classe não declarar explicitamente nenhum construtor?**
   - (A) O compilador Java cria automaticamente um construtor padrão vazio sem parâmetros. *(Correta)*
   - (B) O código não compila.
   - (C) A classe é apagada do disco.

3. **Para que serve a notação `@Override`?**
   - (A) Para avisar o desenvolvedor e o compilador que estamos intencionalmente sobrescrevendo um método herdado da superclasse. *(Correta)*
   - (B) Para transformar um método em público.
   - (C) Para reiniciar a execução do programa.
