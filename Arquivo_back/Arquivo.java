package Arquivo_back;

public class Arquivo{
    String name;
    int size;
    String content;

    // metodos

    public String open(){
        return "Arquivo aberto";
    }

    public void edit(String newContent){
        this.content = newContent;
    }

    public boolean rename(String newName){
        this.name = newName;
        return true;
    }
}
