import models.File;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
       File arq1 = new File("Receita de pudim");

        System.out.println(arq1.open());

        arq1.edit("Ingredientes: leite condensado, ovo, leite");
        System.out.println(arq1.open());

        arq1.edit(", açucar, água.");
        System.out.println(arq1.open());

        Scanner in = new Scanner(System.in);
        System.out.println("Digite o modo de preparo do pudim: ");
        arq1.edit(in.next());
        System.out.println(arq1.open());

        arq1.rename(" arquivo apagado");
        arq1.clear();
        System.out.println(arq1.open());
    
        JOptionPane.showMessageDialog(null, arq1.getContent(), arq1.getName(), 1);

    }
}


/*public class App {
    public static void main(String[] args) {
        Arquivo arquivo = new Arquivo("meuarquivo.txt", 1024, "Conteúdo do arquivo");

        arquivo.mostrar();
        arquivo.abrir();

        arquivo.editar("Novo conteúdo do arquivo");
        arquivo.renomear("novo_nome.txt");

        System.out.println("Novo nome: " + arquivo.nome);
        System.out.println("Novo conteúdo: " + arquivo.conteudo);
    }
}
    */



