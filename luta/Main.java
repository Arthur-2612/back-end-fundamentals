public class Main {

    public static void main(String[] args) {

        Personagem jogador = new Personagem("Arthur");
        Personagem inimigo = new Personagem("Goblin");

        jogador.mostrarStatus();
        inimigo.mostrarStatus();

        jogador.atacar(inimigo);

        System.out.println();

        inimigo.atacar(jogador);
    }
}