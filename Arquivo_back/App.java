package Arquivo_back;

public class App{
    public static void main(String[] args) {
        Arquivo arquivo = new Arquivo();
        arquivo.name = "meuarquivo.txt";    
        arquivo.size = 1024;
        arquivo.content = "Conteúdo do arquivo";

    System.out.println("Nome do arquivo: " + arquivo.name);
    System.out.println("Tamanho do arquivo: " + arquivo.size + " bytes");
    System.out.println("Conteúdo do arquivo: " + arquivo.content);

    System.out.println(arquivo.open());

    arquivo.edit("Novo conteúdo do arquivo");
    System.out.println("Conteúdo do arquivo pós edição: " + arquivo.content);

    arquivo.rename("novo_nome.txt");
    System.out.println("Novo nome do arquivo: " + arquivo.name);
        }
    }
