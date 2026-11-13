/**
 * ============================================================================
 * CURSO: DESENVOLVIMENTO BACK-END JAVA
 * AULA 05: HERANÇA, CLASSES ABSTRATAS E POLIMORFISMO DINÂMICO
 * ============================================================================
 * 
 * Demonstração prática dos seguintes tópicos:
 * 1. Classe abstrata (abstract class) que não pode ser instanciada diretamente.
 * 2. Método abstrato que define um contrato obrigatório de cálculo de salário.
 * 3. Herança com a palavra-chave extends e delegação ao construtor pai com super().
 * 4. Sobrescrita polimórfica com @Override.
 * 5. Uso do polimorfismo dinâmico: tratando objetos heterogêneos de maneira uniforme.
 * ============================================================================
 */

import java.util.ArrayList;
import java.util.List;

// ----------------------------------------------------------------------------
// 1. SUPERCLASSE ABSTRATA
// ----------------------------------------------------------------------------
abstract class Funcionario {

    private String nome;
    private String matricula;
    private double salarioBase;

    // Construtor da superclasse
    public Funcionario(String nome, String matricula, double salarioBase) {
        this.nome = nome;
        this.matricula = matricula;
        this.salarioBase = salarioBase;
    }

    // MÉTODO ABSTRATO: Cada cargo possui sua própria fórmula de remuneração
    public abstract double calcularSalarioLiquido();

    // Método concreto comum compartilhado por todos os funcionários
    public void exibirDadosBasicos() {
        System.out.printf("Funcionário: %-15s | Matrícula: %-6s | Salário Base: R$ %.2f\n",
                nome, matricula, salarioBase);
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public double getSalarioBase() {
        return salarioBase;
    }
}

// ----------------------------------------------------------------------------
// 2. SUBCLASSE CONCRETA: DESENVOLVEDOR
// ----------------------------------------------------------------------------
class Desenvolvedor extends Funcionario {

    private String nivel; // Junior, Pleno, Senior
    private double bonusProjetos;

    public Desenvolvedor(String nome, String matricula, double salarioBase, String nivel, double bonusProjetos) {
        // Invoca obrigatoriamente o construtor da superclasse Funcionario
        super(nome, matricula, salarioBase);
        this.nivel = nivel;
        this.bonusProjetos = bonusProjetos;
    }

    // Implementação obrigatória do método abstrato
    @Override
    public double calcularSalarioLiquido() {
        // Salário base + bônus de entrega de software
        return getSalarioBase() + bonusProjetos;
    }

    @Override
    public String toString() {
        return String.format("[Dev %s] %s - Salário Final: R$ %.2f", nivel, getNome(), calcularSalarioLiquido());
    }
}

// ----------------------------------------------------------------------------
// 3. SUBCLASSE CONCRETA: GERENTE
// ----------------------------------------------------------------------------
class Gerente extends Funcionario {

    private double participacaoLucros;

    public Gerente(String nome, String matricula, double salarioBase, double participacaoLucros) {
        super(nome, matricula, salarioBase);
        this.participacaoLucros = participacaoLucros;
    }

    @Override
    public double calcularSalarioLiquido() {
        // Salário base + PLR anual proporcional
        return getSalarioBase() + (participacaoLucros / 12.0);
    }

    @Override
    public String toString() {
        return String.format("[Gerente] %s - Salário Final: R$ %.2f", getNome(), calcularSalarioLiquido());
    }
}

// ----------------------------------------------------------------------------
// 4. CLASSE PRINCIPAL EXECUTÁVEL
// ----------------------------------------------------------------------------
public class ExemploAula05 {

    public static void main(String[] args) {
        System.out.println("====================================================");
        System.out.println(" AULA 05: POLIMORFISMO E FOLHA DE PAGAMENTO         ");
        System.out.println("====================================================\n");

        // Polimorfismo na prática:
        // A lista é de 'Funcionario' (tipo genérico da superclasse),
        // mas guarda objetos de tipos concretos diferentes (Desenvolvedor, Gerente)!
        List<Funcionario> folhaPagamento = new ArrayList<>();

        folhaPagamento.add(new Desenvolvedor("Arthur Silva", "DEV01", 5500.0, "Pleno", 1200.0));
        folhaPagamento.add(new Desenvolvedor("Beatriz Ramos", "DEV02", 3500.0, "Junior", 500.0));
        folhaPagamento.add(new Gerente("Carlos Eduardo", "GER01", 11000.0, 24000.0));

        System.out.println("--- Processando Folha de Pagamento Polimorficamente ---");
        double custoTotalEmpresa = 0.0;

        for (Funcionario f : folhaPagamento) {
            f.exibirDadosBasicos();
            // A chamada abaixo invoca a versão correta de calcularSalarioLiquido()
            // de cada classe em tempo de execução dinamicamente!
            double salarioLiquido = f.calcularSalarioLiquido();
            System.out.println("  -> " + f);
            System.out.println("----------------------------------------------------");
            custoTotalEmpresa += salarioLiquido;
        }

        System.out.printf("\nCusto Total da Folha Mensal da Empresa: R$ %.2f\n", custoTotalEmpresa);
        System.out.println("Sucesso! Código extensível e desacoplado através de Polimorfismo.");
    }
}

