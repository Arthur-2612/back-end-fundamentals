import java.util.Random;

public class Personagem {

    private String nome;
    private int vida;
    private int ataque;
    private int defesa;

    // Construtor
    public Personagem(String nome) {
        this.nome = nome;
        this.vida = 100;

        Random random = new Random();

        // Ataque entre 20 e 30
        this.ataque = random.nextInt(11) + 20;

        // Defesa entre 10 e 15
        this.defesa = random.nextInt(6) + 10;
    }

    // Método de ataque
    public void atacar(Personagem oponente) {

        int dano = this.ataque - oponente.defesa;

        // Evita dano negativo
        if (dano < 0) {
            dano = 0;
        }

        oponente.vida -= dano;

        System.out.println(this.nome + " atacou " + oponente.nome);
        System.out.println("Dano causado: " + dano);
        System.out.println("Vida de " + oponente.nome + ": " + oponente.vida);
    }

    // Apenas para visualizar os atributos
    public void mostrarStatus() {
        System.out.println("Nome: " + nome);
        System.out.println("Vida: " + vida);
        System.out.println("Ataque: " + ataque);
        System.out.println("Defesa: " + defesa);
        System.out.println();
    }
}