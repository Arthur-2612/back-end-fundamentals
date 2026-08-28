package Arquivo_back;

public class Arquivo{
    private String name;
    private String content;
    private int size;

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setContent(String content){
        this.content = content;
    }

    public String getContent(){
        return this.content;
    }

    public void setSize(int size){
        this.size = size;
    }

    public int getSize(){
        return this.size;
    }

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
