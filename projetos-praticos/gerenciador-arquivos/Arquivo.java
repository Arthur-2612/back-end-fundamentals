package Arquivo_back;

public class Arquivo {
    String nome;
    int tamanho;
    String conteudo;

    public Arquivo(String nome, int tamanho, String conteudo) {
        this.nome = nome;
        this.tamanho = tamanho;
        this.conteudo = conteudo;
    }

    public void abrir() {
        System.out.println("Arquivo " + nome + " aberto.");
    }

    public void editar(String novoConteudo) {
        this.conteudo = novoConteudo;
    }

    public void renomear(String novoNome) {
        this.nome = novoNome;
    }

    public void mostrar() {
        System.out.println("Nome: " + nome);
        System.out.println("Tamanho: " + tamanho + " bytes");
        System.out.println("Conteúdo: " + conteudo);
    }
}
