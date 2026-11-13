import java.util.Random;

/**
 * Representa um Personagem no Simulador de Combate em Turnos.
 * Demonstra encapsulamento, atributos privados, construtor com sorteio aleatório
 * de status e regras de cálculo de dano.
 */
public class Personagem {

    private String nome;
    private int vida;
    private int vidaMaxima;
    private int ataque;
    private int defesa;

    /**
     * Construtor que inicializa o combatente com valores base e bônus aleatórios.
     * @param nome Nome do combatente (ex: "Arthur", "Goblin")
     */
    public Personagem(String nome) {
        this.nome = nome;
        this.vida = 100;
        this.vidaMaxima = 100;

        Random random = new Random();

        // Ataque sorteado entre 20 e 30
        this.ataque = random.nextInt(11) + 20;

        // Defesa sorteada entre 10 e 15
        this.defesa = random.nextInt(6) + 10;
    }

    /**
     * Executa o ataque contra um oponente alvo, calculando o dano líquido.
     * @param oponente O personagem adversário
     * @return O valor do dano líquido desferido
     */
    public int atacar(Personagem oponente) {
        int dano = this.ataque - oponente.defesa;

        // Dano não pode ser negativo (defesa superior apenas anula o dano)
        if (dano < 0) {
            dano = 0;
        }

        oponente.vida -= dano;
        if (oponente.vida < 0) {
            oponente.vida = 0;
        }

        System.out.println("⚔️ " + this.nome + " atacou " + oponente.nome + " com poder de " + this.ataque + "!");
        System.out.println("🛡️ " + oponente.nome + " defendeu com " + oponente.defesa + " pontos.");
        System.out.println("💥 Dano líquido causado: " + dano);
        System.out.println("❤️ Vida restante de " + oponente.nome + ": " + oponente.vida + "/" + oponente.vidaMaxima);

        return dano;
    }

    /**
     * Verifica se o combatente ainda possui pontos de vida ativos.
     */
    public boolean estaVivo() {
        return this.vida > 0;
    }

    /**
     * Exibe no terminal a ficha de status completa do combatente.
     */
    public void mostrarStatus() {
        System.out.println("----------------------------------------");
        System.out.println("👤 Combatente: " + nome);
        System.out.println("❤️  Vida:    " + vida + "/" + vidaMaxima);
        System.out.println("⚔️  Ataque:  " + ataque);
        System.out.println("🛡️  Defesa:  " + defesa);
        System.out.println("----------------------------------------");
    }

    // Getters e Setters
    public String getNome() { return nome; }
    public int getVida() { return vida; }
    public int getVidaMaxima() { return vidaMaxima; }
    public int getAtaque() { return ataque; }
    public int getDefesa() { return defesa; }
}
