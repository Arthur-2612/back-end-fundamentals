import models.File;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 * Ponto de entrada do Gerenciador de Arquivos em Memória.
 * Demonstra a instanciação da classe models.File, operações de edição,
 * renomeação e exibição tanto no console quanto via diálogo gráfico (JOptionPane).
 */
public class App {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("       GERENCIADOR DE ARQUIVOS EM MEMÓRIA         ");
        System.out.println("==================================================");

        // Criação do arquivo virtual
        File arq1 = new File("receita_de_pudim.txt");
        System.out.println("\n[1] Arquivo recém-criado:");
        System.out.println(arq1.open());

        // Edição do conteúdo inicial
        System.out.println("\n[2] Adicionando ingredientes...");
        arq1.edit("Ingredientes: 1 lata de leite condensado, 3 ovos, 500ml de leite");
        System.out.println(arq1.open());

        // Adicionando calda
        System.out.println("\n[3] Adicionando calda...");
        arq1.edit("\nCalda: 1 xícara de açúcar, 1/2 xícara de água.");
        System.out.println(arq1.open());

        // Renomeando arquivo com validação
        System.out.println("\n[4] Renomeando o arquivo...");
        boolean sucesso = arq1.rename("pudim_da_vovo.txt");
        System.out.println("Renomeado com sucesso? " + sucesso);
        System.out.println(arq1.open());

        // Exibição em janela gráfica swing
        System.out.println("\n[5] Apresentando resultado em janela de diálogo...");
        JOptionPane.showMessageDialog(
            null,
            arq1.open(),
            "Visualizador: " + arq1.getName(),
            JOptionPane.INFORMATION_MESSAGE
        );

        System.out.println("Operação concluída com sucesso!");
    }
}
