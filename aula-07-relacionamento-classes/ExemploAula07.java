/**
 * ============================================================================
 * CURSO: DESENVOLVIMENTO BACK-END JAVA
 * AULA 07: RELACIONAMENTOS ENTRE CLASSES (AGREGAÇÃO, COMPOSIÇÃO E DEPENDÊNCIA)
 * ============================================================================
 * 
 * Demonstração prática dos seguintes tópicos:
 * 1. Agregação: Relacionamento Todo-Parte fraco onde as partes existem independentemente (Time e Jogadores).
 * 2. Composição: Relacionamento Todo-Parte forte onde o ciclo de vida é dependente (Pedido e Itens).
 * 3. Dependência: Uso transitório de uma classe por outra dentro de um método (Serviço de Impressão).
 * ============================================================================
 */

import java.util.ArrayList;
import java.util.List;

// ----------------------------------------------------------------------------
// PARTE 1: EXEMPLO DE AGREGAÇÃO (Ciclo de Vida Independente)
// ----------------------------------------------------------------------------
class Jogador {

    private String nome;
    private int numeroCamisa;

    public Jogador(String nome, int numeroCamisa) {
        this.nome = nome;
        this.numeroCamisa = numeroCamisa;
    }

    public String getNome() {
        return nome;
    }

    public int getNumeroCamisa() {
        return numeroCamisa;
    }
}

class TimeFutebol {

    private String nomeClube;
    // Agregação: o time TEM uma lista de jogadores, mas os jogadores existem fora dele!
    private List<Jogador> elenco;

    public TimeFutebol(String nomeClube) {
        this.nomeClube = nomeClube;
        this.elenco = new ArrayList<>();
    }

    public void contratarJogador(Jogador jogador) {
        this.elenco.add(jogador);
        System.out.println("-> " + jogador.getNome() + " (#" + jogador.getNumeroCamisa() + ") contratado pelo " + nomeClube);
    }

    public void listarElenco() {
        System.out.println("Elenco do " + nomeClube + ":");
        for (Jogador j : elenco) {
            System.out.println("  - Camisa " + j.getNumeroCamisa() + ": " + j.getNome());
        }
    }
}

// ----------------------------------------------------------------------------
// PARTE 2: EXEMPLO DE COMPOSIÇÃO (Ciclo de Vida Dependente)
// ----------------------------------------------------------------------------
class ItemPedido {

    private String produto;
    private double preco;

    // Construtor com visibilidade controlada: itens só nascem a partir do Pedido
    public ItemPedido(String produto, double preco) {
        this.produto = produto;
        this.preco = preco;
    }

    public String getProduto() {
        return produto;
    }

    public double getPreco() {
        return preco;
    }
}

class Pedido {

    private int numeroPedido;
    // Composição: os itens pertencem com exclusividade a este pedido!
    private List<ItemPedido> itens;

    public Pedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
        this.itens = new ArrayList<>();
    }

    // Na composição, o próprio pedido cria a instância do item internamente
    public void adicionarItem(String produto, double preco) {
        ItemPedido item = new ItemPedido(produto, preco);
        this.itens.add(item);
    }

    public double calcularTotal() {
        double total = 0.0;
        for (ItemPedido item : itens) {
            total += item.getPreco();
        }
        return total;
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }
}

// ----------------------------------------------------------------------------
// PARTE 3: EXEMPLO DE DEPENDÊNCIA (Uso temporário / acoplamento fraco)
// ----------------------------------------------------------------------------
class ImpressoraFiscalService {

    // Dependência: o serviço não armazena o Pedido como atributo,
    // apenas o 'usa' temporariamente como parâmetro de um método!
    public void imprimirComprovante(Pedido pedido) {
        System.out.println("\n--- [CUPOM FISCAL] ---");
        System.out.println("Pedido Nº: " + pedido.getNumeroPedido());
        for (ItemPedido item : pedido.getItens()) {
            System.out.printf("  Item: %-15s | R$ %.2f\n", item.getProduto(), item.getPreco());
        }
        System.out.printf("TOTAL A PAGAR: R$ %.2f\n", pedido.calcularTotal());
        System.out.println("----------------------\n");
    }
}

// ----------------------------------------------------------------------------
// CLASSE PRINCIPAL EXECUTÁVEL
// ----------------------------------------------------------------------------
public class ExemploAula07 {

    public static void main(String[] args) {
        System.out.println("====================================================");
        System.out.println(" AULA 07: RELACIONAMENTOS E ESTRUTURAÇÃO DE OBJETOS ");
        System.out.println("====================================================\n");

        // 1. DEMONSTRANDO AGREGAÇÃO
        System.out.println("--- 1) Agregação (Ciclo de Vida Independente) ---");
        // Jogadores nascem independentemente de qualquer time:
        Jogador j1 = new Jogador("Vinicius Jr", 7);
        Jogador j2 = new Jogador("Rodrygo", 11);

        TimeFutebol time = new TimeFutebol("Real Madrid");
        time.contratarJogador(j1);
        time.contratarJogador(j2);
        time.listarElenco();

        System.out.println("\n");

        // 2. DEMONSTRANDO COMPOSIÇÃO
        System.out.println("--- 2) Composição (Ciclo de Vida Dependente) ---");
        Pedido pedido1 = new Pedido(9876);
        pedido1.adicionarItem("Teclado Mecânico", 250.0);
        pedido1.adicionarItem("Mousepad Gigante", 75.0);
        pedido1.adicionarItem("Headset Gamer", 320.0);

        // 3. DEMONSTRANDO DEPENDÊNCIA
        ImpressoraFiscalService impressora = new ImpressoraFiscalService();
        impressora.imprimirComprovante(pedido1);

        System.out.println("Relacionamentos compreendidos e executados com sucesso!");
    }
}

