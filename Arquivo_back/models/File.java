package models;

/*public class Arquivo {
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

    private void updateSize(){
        size = conteudo.lenght() * 8;
        }

    public void mostrar() {
        System.out.println("Nome: " + nome);
        System.out.println("Tamanho: " + tamanho + " bytes");
        System.out.println("Conteúdo: " + conteudo);
    }
}
*/


public class File {
    // Attributes
    private String name;
    private String content;
    private int size;
    
    // Constructor
    public File(String name) {
        this.name = name;
        this.content = "";
        updateSize();
    }
    
    // Methodes
    public String open(){
        return "Nome do arquivo: " + name +
                "\nConteudo: " + content + 
                "\nTamanho: " + size + " bits";
    }

    public void edit(String newContent){
        content += newContent;
        updateSize();
    }

    public boolean rename(String newName){
        newName = newName.trim();
        if(newName.isEmpty())
            return false;

        name = newName;
        return true;
    }

    public void clear(){
        content = "";
        updateSize();
    }

    private void updateSize(){
        size = content.length()*8;
    }

}