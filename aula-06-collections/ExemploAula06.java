/**
 * ============================================================================
 * CURSO: DESENVOLVIMENTO BACK-END JAVA
 * AULA 06: JAVA COLLECTIONS FRAMEWORK (LIST, SET E MAP)
 * ============================================================================
 * 
 * Demonstração prática dos seguintes tópicos:
 * 1. Uso de List e ArrayList para manter listas ordenadas com duplicatas permitidas.
 * 2. Uso de Set e HashSet para garantir unicidade absoluta de elementos (sem duplicados).
 * 3. Uso de Map e HashMap para buscas ultrarrápidas baseadas em pares chave-valor.
 * 4. Técnicas modernas de iteração com foreach e Streams.
 * ============================================================================
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ExemploAula06 {

    public static void main(String[] args) {
        System.out.println("====================================================");
        System.out.println(" AULA 06: EXPLORANDO O JAVA COLLECTIONS FRAMEWORK   ");
        System.out.println("====================================================\n");

        // --------------------------------------------------------------------
        // 1. LIST (ArrayList): Sequência ordenada de elementos
        // --------------------------------------------------------------------
        System.out.println("--- 1) Trabalhando com List<String> (ArrayList) ---");
        List<String> linguagensBackend = new ArrayList<>();

        linguagensBackend.add("Java");
        linguagensBackend.add("Python");
        linguagensBackend.add("C#");
        linguagensBackend.add("Java"); // List aceita elementos duplicados normalmente!

        System.out.println("Tamanho da lista: " + linguagensBackend.size());
        System.out.println("Elemento na posição 0: " + linguagensBackend.get(0));

        System.out.println("Listando todas as linguagens:");
        for (int i = 0; i < linguagensBackend.size(); i++) {
            System.out.println("  Índice [" + i + "]: " + linguagensBackend.get(i));
        }

        System.out.println("\n");

        // --------------------------------------------------------------------
        // 2. SET (HashSet): Coleção matemática de elementos únicos
        // --------------------------------------------------------------------
        System.out.println("--- 2) Trabalhando com Set<String> (HashSet) ---");
        Set<String> emailsCadastrados = new HashSet<>();

        emailsCadastrados.add("arthur@email.com");
        emailsCadastrados.add("camila@email.com");
        emailsCadastrados.add("lucas@email.com");
        
        // Tentativa de adicionar e-mail repetido:
        boolean adicionouDuplicado = emailsCadastrados.add("arthur@email.com");
        System.out.println("Conseguiu reinserir 'arthur@email.com'? " + adicionouDuplicado + " (Bloqueado pelo Set!)");
        System.out.println("Total de e-mails únicos: " + emailsCadastrados.size());

        System.out.println("E-mails únicos cadastrados:");
        for (String email : emailsCadastrados) {
            System.out.println("  -> " + email);
        }

        System.out.println("\n");

        // --------------------------------------------------------------------
        // 3. MAP (HashMap): Dicionário de Chave -> Valor
        // --------------------------------------------------------------------
        System.out.println("--- 3) Trabalhando com Map<String, Double> (HashMap) ---");
        // Chave: Código SKU do Produto (String) | Valor: Preço Unitário (Double)
        Map<String, Double> tabelaPrecos = new HashMap<>();

        tabelaPrecos.put("PROD-001", 3500.00); // Notebook
        tabelaPrecos.put("PROD-002", 250.00);  // Teclado Mecânico
        tabelaPrecos.put("PROD-003", 180.00);  // Mouse Gamer

        System.out.println("Consultando preço do item 'PROD-002' via chave:");
        Double precoTeclado = tabelaPrecos.get("PROD-002");
        System.out.println("  -> Preço: R$ " + precoTeclado);

        System.out.println("\nVarrendo todas as entradas do mapa (Entry Set):");
        for (Map.Entry<String, Double> entrada : tabelaPrecos.entrySet()) {
            System.out.printf("  SKU: %-10s | Valor: R$ %.2f\n", entrada.getKey(), entrada.getValue());
        }

        System.out.println("\nColeções dominadas com sucesso!");
    }
}

