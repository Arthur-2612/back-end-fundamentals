/**
 * Classe principal que orquestra a simulação da batalha em turnos.
 * Executa o loop de combate até que um dos heróis seja derrotado.
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("==================================================");
        System.out.println("       ARENA MEDIEVAL: SIMULADOR DE COMBATE       ");
        System.out.println("==================================================");

        Personagem jogador = new Personagem("Arthur, o Paladino");
        Personagem inimigo = new Personagem("Goblin Furioso");

        System.out.println("\n--- STATUS INICIAIS DOS COMBATENTES ---");
        jogador.mostrarStatus();
        inimigo.mostrarStatus();

        System.out.println("\n🔥 O COMBATE COMEÇOU! PREPAREM-SE!\n");

        int turno = 1;
        while (jogador.estaVivo() && inimigo.estaVivo()) {
            System.out.println(">>>>>>>>>> TURNO " + turno + " <<<<<<<<<<");

            // Turno do Jogador
            jogador.atacar(inimigo);
            System.out.println();

            // Se o inimigo foi derrotado, encerra sem revidar
            if (!inimigo.estaVivo()) {
                System.out.println("💀 " + inimigo.getNome() + " sucumbiu aos ferimentos!");
                break;
            }

            // Turno do Inimigo
            inimigo.atacar(jogador);
            System.out.println();

            if (!jogador.estaVivo()) {
                System.out.println("💀 " + jogador.getNome() + " caiu em combate...");
                break;
            }

            turno++;
        }

        System.out.println("==================================================");
        System.out.println("                FIM DA BATALHA                    ");
        System.out.println("==================================================");
        if (jogador.estaVivo()) {
            System.out.println("🏆 VITÓRIA! " + jogador.getNome() + " venceu a batalha após " + turno + " rodadas!");
        } else {
            System.out.println("☠️ DERROTA! " + inimigo.getNome() + " triunfou na arena.");
        }
    }
}
