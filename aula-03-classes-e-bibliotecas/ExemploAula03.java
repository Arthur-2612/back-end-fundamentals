/**
 * ============================================================================
 * CURSO: DESENVOLVIMENTO BACK-END JAVA
 * AULA 03: CLASSES JAVA, STRING, RANDOM, JOPTIONPANE E MATH
 * ============================================================================
 * 
 * Demonstração prática dos seguintes tópicos:
 * 1. Métodos e imutabilidade da classe java.lang.String.
 * 2. Comparação correta com equals() vs ==.
 * 3. Geração de números aleatórios com java.util.Random.
 * 4. Operações matemáticas com métodos estáticos da classe java.lang.Math.
 * 5. Caixas de diálogo interativas com javax.swing.JOptionPane.
 * ============================================================================
 */

import java.util.Random;
import javax.swing.JOptionPane;

public class ExemploAula03 {

    public static void main(String[] args) {
        System.out.println("====================================================");
        System.out.println(" AULA 03: EXPLORANDO AS BIBLIOTECAS ESSENCIAIS JAVA ");
        System.out.println("====================================================\n");

        // --------------------------------------------------------------------
        // 1. MANIPULAÇÃO DA CLASSE STRING
        // --------------------------------------------------------------------
        System.out.println("--- 1) Trabalhando com a Classe String ---");
        String fraseOriginal = "  Desenvolvimento Back-End em Java!  ";

        System.out.println("Frase Original: '" + fraseOriginal + "'");
        System.out.println("Tamanho (length): " + fraseOriginal.length());
        
        // Remoção de espaços nas bordas
        String fraseLimpa = fraseOriginal.trim();
        System.out.println("Após trim(): '" + fraseLimpa + "'");

        // Caixa alta e baixa
        System.out.println("Maiúsculas: " + fraseLimpa.toUpperCase());
        System.out.println("Minúsculas: " + fraseLimpa.toLowerCase());

        // Verificação e substituição
        System.out.println("Contém a palavra 'Java'? " + fraseLimpa.contains("Java"));
        String fraseModificada = fraseLimpa.replace("Java", "Spring Boot");
        System.out.println("Após replace: " + fraseModificada);

        // Comparação de igualdade: NUNCA use '==' para comparar strings de conteúdo!
        String s1 = new String("Java");
        String s2 = new String("Java");
        System.out.println("Comparação por endereço (s1 == s2): " + (s1 == s2) + " (Falso, são objetos distintos no Heap!)");
        System.out.println("Comparação por valor (s1.equals(s2)): " + s1.equals(s2) + " (Verdadeiro, mesmo conteúdo!)");

        System.out.println("\n");

        // --------------------------------------------------------------------
        // 2. GERAÇÃO DE NÚMEROS COM A CLASSE RANDOM
        // --------------------------------------------------------------------
        System.out.println("--- 2) Geração de Números com Random ---");
        Random gerador = new Random();

        // Sorteia um número inteiro de 0 a 99 (+ 1 para ficar entre 1 e 100)
        int numeroSorteado = gerador.nextInt(100) + 1;
        System.out.println("Número aleatório entre 1 e 100: " + numeroSorteado);

        // Simulando o lançamento de um dado de 6 faces
        int dado = gerador.nextInt(6) + 1;
        System.out.println("Rolando um dado de 6 lados (D6): " + dado);

        // Simulando cara ou coroa (boolean)
        boolean caraOuCoroa = gerador.nextBoolean();
        System.out.println("Lançando moeda: " + (caraOuCoroa ? "CARA" : "COROA"));

        System.out.println("\n");

        // --------------------------------------------------------------------
        // 3. MÉTODOS ESTÁTICOS DA CLASSE MATH
        // --------------------------------------------------------------------
        System.out.println("--- 3) Utilidades Matemáticas com Math ---");
        double raio = 5.0;
        double areaCirculo = Math.PI * Math.pow(raio, 2);
        System.out.println("Área de um círculo com raio 5: " + String.format("%.2f", areaCirculo));

        double raiz = Math.sqrt(81.0);
        System.out.println("Raiz quadrada de 81: " + raiz);

        int maximo = Math.max(150, 280);
        System.out.println("Maior entre 150 e 280: " + maximo);

        System.out.println("\n");

        // --------------------------------------------------------------------
        // 4. INTERAÇÃO GRÁFICA COM JOPTIONPANE
        // --------------------------------------------------------------------
        System.out.println("--- 4) Demonstração do JOptionPane ---");
        try {
            // Exibição de mensagem informativa na interface gráfica
            JOptionPane.showMessageDialog(null, 
                "Parabéns! Você completou o módulo de utilitários da Aula 03.\nNúmero da sorte: " + numeroSorteado, 
                "Back-End Java Fundamentals", 
                JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Diálogo JOptionPane exibido com sucesso!");
        } catch (Exception e) {
            // Em caso de ambiente headless (sem display gráfico conectado)
            System.out.println("Aviso: Ambiente de terminal detectado (modo headless). Diálogo JOptionPane simulado via console.");
        }
    }
}

