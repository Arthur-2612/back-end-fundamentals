package models;

/**
 * Modelo de Arquivo em Memória (In-Memory Virtual File).
 * Demonstra encapsulamento estrito, controle de estado e cálculo automático
 * do tamanho do arquivo em bits com base no conteúdo textual.
 */
public class File {

    // Atributos privados garantindo o encapsulamento
    private String name;
    private String content;
    private int size; // Tamanho em bits

    /**
     * Construtor que inicializa um arquivo vazio com nome especificado.
     * @param name Nome do arquivo
     */
    public File(String name) {
        this.name = name;
        this.content = "";
        updateSize();
    }

    /**
     * Retorna a visualização formatada dos metadados e conteúdo do arquivo.
     */
    public String open() {
        return "📄 Nome do arquivo: " + name +
               "\n📝 Conteúdo: " + (content.isEmpty() ? "(arquivo vazio)" : content) +
               "\n📊 Tamanho: " + size + " bits (" + (size / 8) + " bytes)";
    }

    /**
     * Concatena novo texto ao arquivo e recalcula seu tamanho.
     * @param newContent Texto a ser adicionado
     */
    public void edit(String newContent) {
        if (newContent != null) {
            this.content += newContent;
            updateSize();
        }
    }

    /**
     * Renomeia o arquivo garantindo que o novo nome não seja nulo ou vazio.
     * @param newName Novo nome desejado
     * @return true se renomeado com sucesso, false se nome for inválido
     */
    public boolean rename(String newName) {
        if (newName == null) {
            return false;
        }
        String sanitized = newName.trim();
        if (sanitized.isEmpty()) {
            return false;
        }

        this.name = sanitized;
        return true;
    }

    /**
     * Limpa todo o conteúdo do arquivo e zera seu tamanho.
     */
    public void clear() {
        this.content = "";
        updateSize();
    }

    /**
     * Método auxiliar privado para atualização do tamanho (8 bits por caractere UTF-16/ASCII aproximado).
     */
    private void updateSize() {
        this.size = this.content.length() * 8;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    public int getSize() {
        return size;
    }
}
