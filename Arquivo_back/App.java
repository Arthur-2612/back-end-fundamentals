package Arquivo_back;

public class App {
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
