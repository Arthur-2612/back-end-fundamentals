package Arquivo_back;

public class App{
    public static void main(String[] args) {
        Arquivo arquivo = new Arquivo();
        arquivo.setName("meuarquivo.txt");
        arquivo.setSize(1024);
        arquivo.setContent("Conteúdo do arquivo");

        System.out.println("Nome do arquivo: " + arquivo.getName());
        System.out.println("Tamanho do arquivo: " + arquivo.getSize() + " bytes");
        System.out.println("Conteúdo do arquivo: " + arquivo.getContent());

        System.out.println(arquivo.open());

        arquivo.edit("Novo conteúdo do arquivo");
        System.out.println("Conteúdo do arquivo pós edição: " + arquivo.getContent());

        arquivo.rename("novo_nome.txt");
        System.out.println("Novo nome do arquivo: " + arquivo.getName());
    }
}
