/**
 * ============================================================================
 * CURSO: DESENVOLVIMENTO BACK-END JAVA
 * AULA 02: ESTRUTURA DE UMA CLASSE, ENCAPSULAMENTO E MÉTODOS PADRÕES
 * ============================================================================
 * 
 * Demonstração prática dos seguintes tópicos:
 * 1. Modificadores de acesso privados (private) para garantir encapsulamento.
 * 2. Construtores com sobrecarga (overloading) para inicialização flexível.
 * 3. Métodos Getters e Setters com regras de proteção de dados.
 * 4. Métodos de negócio com retorno booleano (sucesso/falha de transação).
 * 5. Sobrescrita de toString() com a anotação @Override.
 * ============================================================================
 */

class ContaBancaria {

    // ------------------------------------------------------------------------
    // ATRIBUTOS PRIVADOS (Encapsulamento: protegidos contra alteração externa direta)
    // ------------------------------------------------------------------------
    private int numero;
    private String titular;
    private double saldo;

    // ------------------------------------------------------------------------
    // CONSTRUTOR 1: Construtor completo (recebe número, titular e saldo inicial)
    // ------------------------------------------------------------------------
    public ContaBancaria(int numero, String titular, double saldoInicial) {
        this.numero = numero;
        this.titular = titular;
        // Validação no nascimento do objeto: impede saldo negativo inicial
        if (saldoInicial >= 0) {
            this.saldo = saldoInicial;
        } else {
            this.saldo = 0.0;
            System.out.println("-> [Aviso] Saldo inicial não pode ser negativo. Inicializado com R$ 0,00.");
        }
    }

    // ------------------------------------------------------------------------
    // CONSTRUTOR 2: Construtor sobrecarregado (Overloaded)
    // Inicializa a conta apenas com número e titular, delegando para o Construtor 1
    // com saldo zero por padrão.
    // ------------------------------------------------------------------------
    public ContaBancaria(int numero, String titular) {
        this(numero, titular, 0.0); // 'this(...)' chama o outro construtor da própria classe
    }

    // ------------------------------------------------------------------------
    // MÉTODOS DE NEGÓCIO (Regras que operam sobre o estado da conta)
    // ------------------------------------------------------------------------

    /**
     * Realiza um depósito na conta.
     * @param valor Quantia em dinheiro a depositar (deve ser positiva).
     * @return true se o depósito foi efetuado, false se valor inválido.
     */
    public boolean depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            System.out.println("-> [Depósito] R$ " + valor + " creditado na conta de " + titular);
            return true;
        } else {
            System.out.println("-> [Erro] O valor do depósito deve ser maior que zero!");
            return false;
        }
    }

    /**
     * Realiza um saque da conta, validando se há saldo suficiente.
     * @param valor Quantia a sacar.
     * @return true se o saque for permitido e realizado, false caso contrário.
     */
    public boolean sacar(double valor) {
        if (valor <= 0) {
            System.out.println("-> [Erro] O valor do saque deve ser positivo!");
            return false;
        }

        if (this.saldo >= valor) {
            this.saldo -= valor;
            System.out.println("-> [Saque] R$ " + valor + " debitado com sucesso da conta de " + titular);
            return true;
        } else {
            System.out.println("-> [Erro] Saldo insuficiente para sacar R$ " + valor + "! Saldo atual: R$ " + this.saldo);
            return false;
        }
    }

    // ------------------------------------------------------------------------
    // GETTERS & SETTERS (Métodos de acesso controlado aos atributos)
    // ------------------------------------------------------------------------

    public int getNumero() {
        return this.numero;
    }

    public String getTitular() {
        return this.titular;
    }

    public void setTitular(String novoTitular) {
        // Validação: impede titular vazio ou nulo
        if (novoTitular != null && !novoTitular.trim().isEmpty()) {
            this.titular = novoTitular;
        } else {
            System.out.println("-> [Erro] Nome do titular não pode ser vazio!");
        }
    }

    public double getSaldo() {
        return this.saldo;
    }
    // OBS: Não criamos 'setSaldo' porque o saldo só deve mudar via depositar() e sacar()!

    // ------------------------------------------------------------------------
    // SOBRESCRITA DO MÉTODO toString()
    // ------------------------------------------------------------------------
    @Override
    public String toString() {
        return String.format("ContaBancaria [Nº: %d | Titular: %-15s | Saldo: R$ %.2f]",
                this.numero, this.titular, this.saldo);
    }
}

// ----------------------------------------------------------------------------
// CLASSE EXECUTÁVEL COM MÉTODO MAIN
// ----------------------------------------------------------------------------
public class ExemploAula02 {

    public static void main(String[] args) {
        System.out.println("====================================================");
        System.out.println(" AULA 02: CONSTRUTORES, ENCAPSULAMENTO E TOSTRING   ");
        System.out.println("====================================================\n");

        // 1. Criando conta com construtor completo
        ContaBancaria conta1 = new ContaBancaria(1001, "Arthur Silva", 500.0);
        System.out.println("Conta 1 criada: " + conta1);

        // 2. Criando conta com construtor sobrecarregado (saldo inicial zero)
        ContaBancaria conta2 = new ContaBancaria(1002, "Mariana Costa");
        System.out.println("Conta 2 criada: " + conta2);

        System.out.println("\n--- Testando Operações Bancárias ---");
        conta1.depositar(250.0);
        conta1.sacar(100.0);
        conta1.sacar(900.0); // Tentativa além do saldo disponível

        conta2.depositar(1200.0);
        conta2.sacar(300.0);

        System.out.println("\n--- Status Final das Contas ---");
        System.out.println(conta1);
        System.out.println(conta2);
    }
}

