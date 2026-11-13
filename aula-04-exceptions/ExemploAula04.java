/**
 * ============================================================================
 * CURSO: DESENVOLVIMENTO BACK-END JAVA
 * AULA 04: TRATAMENTO DE EXCEÇÕES (TRY / CATCH / FINALLY E CUSTOM EXCEPTIONS)
 * ============================================================================
 * 
 * Demonstração prática dos seguintes tópicos:
 * 1. Captura de exceções matemáticas e conversão (ArithmeticException, NumberFormatException).
 * 2. Criação de uma classe de Exceção Customizada de Negócio (SaldoInsuficienteException).
 * 3. Utilização do bloco 'finally' para liberação de recursos.
 * 4. Uso de throw para disparar erros intencionalmente baseados em regras de validação.
 * ============================================================================
 */

// ----------------------------------------------------------------------------
// 1. EXCEÇÃO CUSTOMIZADA (Regra de Negócio Específica)
// ----------------------------------------------------------------------------
class SaldoInsuficienteException extends Exception {

    private double saldoAtual;
    private double valorSaque;

    public SaldoInsuficienteException(double saldoAtual, double valorSaque) {
        super("Operação Recusada: Saldo de R$ " + saldoAtual + " é insuficiente para o saque de R$ " + valorSaque);
        this.saldoAtual = saldoAtual;
        this.valorSaque = valorSaque;
    }

    public double getSaldoAtual() {
        return saldoAtual;
    }

    public double getValorSaque() {
        return valorSaque;
    }
}

// ----------------------------------------------------------------------------
// 2. MODELO DE CONTA ROBUSTA COM LANÇAMENTO DE EXCEÇÕES
// ----------------------------------------------------------------------------
class ContaSegura {

    private String titular;
    private double saldo;

    public ContaSegura(String titular, double saldoInicial) {
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    /**
     * Realiza saque ou dispara SaldoInsuficienteException caso não haja fundos.
     * Note a cláusula 'throws' declarando o perigo na assinatura!
     */
    public void sacar(double valor) throws SaldoInsuficienteException {
        if (valor <= 0) {
            // IllegalArgumentException é padrão da linguagem (Unchecked)
            throw new IllegalArgumentException("O valor do saque precisa ser maior que zero!");
        }

        if (valor > this.saldo) {
            // Dispara nossa Checked Exception customizada
            throw new SaldoInsuficienteException(this.saldo, valor);
        }

        this.saldo -= valor;
        System.out.println("-> [Saque Concluído] R$ " + valor + " retirado com sucesso. Saldo restante: R$ " + this.saldo);
    }

    public double getSaldo() {
        return saldo;
    }

    public String getTitular() {
        return titular;
    }
}

// ----------------------------------------------------------------------------
// 3. CLASSE EXECUTÁVEL DEMO
// ----------------------------------------------------------------------------
public class ExemploAula04 {

    public static void main(String[] args) {
        System.out.println("====================================================");
        System.out.println(" AULA 04: TRATAMENTO ROBUSTO DE EXCEÇÕES EM JAVA    ");
        System.out.println("====================================================\n");

        // --------------------------------------------------------------------
        // CENÁRIO 1: Tratando conversão inválida de String para Número
        // --------------------------------------------------------------------
        System.out.println("--- 1) Tratando NumberFormatException ---");
        String entradaUsuario = "120ABC"; // Erro comum de digitação

        try {
            System.out.println("Tentando converter '" + entradaUsuario + "' em número inteiro...");
            int valor = Integer.parseInt(entradaUsuario);
            System.out.println("Valor convertido: " + valor);
        } catch (NumberFormatException e) {
            System.out.println("-> [Tratamento] Entrada inválida! O texto contém caracteres não numéricos.");
            System.out.println("-> [Log de Erro] Mensagem técnica: " + e.getMessage());
        }

        System.out.println("\n");

        // --------------------------------------------------------------------
        // CENÁRIO 2: Tratando Exceção Customizada de Negócio
        // --------------------------------------------------------------------
        System.out.println("--- 2) Testando ContaSegura e SaldoInsuficienteException ---");
        ContaSegura conta = new ContaSegura("Arthur", 300.0);

        try {
            System.out.println("Saldo inicial da conta: R$ " + conta.getSaldo());
            
            // Saque 1: Válido
            conta.sacar(100.0);

            // Saque 2: Inválido (saldo é 200, tentando sacar 500)
            System.out.println("Tentando sacar R$ 500,00...");
            conta.sacar(500.0);

        } catch (SaldoInsuficienteException e) {
            System.out.println("-> [Alerta de Negócio] " + e.getMessage());
            System.out.println("-> Sugestão: Faça um depósito antes de tentar sacar novamente.");
        } catch (IllegalArgumentException e) {
            System.out.println("-> [Erro de Parâmetro] " + e.getMessage());
        } finally {
            // Bloco que executa impreterivelmente
            System.out.println("-> [Finally] Sessão bancária encerrada com segurança no banco de dados.");
        }

        System.out.println("\nO programa finalizou sem travar! Demonstração de resiliência concluída.");
    }
}
