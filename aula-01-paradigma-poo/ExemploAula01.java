/**
 * ============================================================================
 * CURSO: DESENVOLVIMENTO BACK-END JAVA
 * AULA 01: PARADIGMA DA PROGRAMAÇÃO ORIENTADA A OBJETOS (POO)
 * ============================================================================
 * 
 * Este arquivo demonstra de forma simples e didática:
 * 1. Como declarar uma Classe (o molde conceitual).
 * 2. Como definir Atributos (características/dados).
 * 3. Como definir Métodos (comportamentos/ações).
 * 4. Como instanciar Objetos a partir da classe utilizando a palavra 'new'.
 * 5. Como cada objeto possui seu próprio estado em memória.
 * ============================================================================
 */

// ----------------------------------------------------------------------------
// 1. DEFINIÇÃO DA CLASSE (O Molde / Mundo das Ideias de Platão)
// ----------------------------------------------------------------------------
class Carro {

    // ATRIBUTOS (Características ou 'Predicações' segundo Aristóteles)
    // Representam o que o carro 'tem' ou 'sabe sobre si mesmo'.
    String modelo;
    String cor;
    int ano;
    int velocidadeAtual;
    boolean motorLigado;

    // MÉTODO: Ação para ligar o motor
    public void ligarMotor() {
        if (!motorLigado) {
            motorLigado = true;
            System.out.println("-> [Vrumm!] O motor do " + modelo + " foi ligado com sucesso.");
        } else {
            System.out.println("-> [Aviso] O motor do " + modelo + " já está em funcionamento!");
        }
    }

    // MÉTODO: Ação para acelerar o carro
    // Recebe um parâmetro 'incremento' representando quanto queremos aumentar a velocidade
    public void acelerar(int incremento) {
        // Regra de negócio simples: só acelera se o motor estiver ligado
        if (motorLigado) {
            velocidadeAtual += incremento;
            System.out.println("-> [Acelerando] O " + modelo + " acelerou para " + velocidadeAtual + " km/h.");
        } else {
            System.out.println("-> [Falha] Impossível acelerar o " + modelo + ": o motor está desligado!");
        }
    }

    // MÉTODO: Ação para frear o carro
    public void frear(int decremento) {
        if (velocidadeAtual - decremento >= 0) {
            velocidadeAtual -= decremento;
        } else {
            velocidadeAtual = 0; // O carro não anda para trás ao frear
        }
        System.out.println("-> [Freando] Velocidade do " + modelo + " reduzida para " + velocidadeAtual + " km/h.");
    }

    // MÉTODO: Exibir status atual do objeto no console
    public void exibirStatus() {
        System.out.println("----------------------------------------------");
        System.out.println("Status do Veículo:");
        System.out.println("  Modelo: " + modelo);
        System.out.println("  Cor: " + cor);
        System.out.println("  Ano: " + ano);
        System.out.println("  Motor ligado? " + (motorLigado ? "Sim" : "Não"));
        System.out.println("  Velocidade atual: " + velocidadeAtual + " km/h");
        System.out.println("----------------------------------------------");
    }
}

// ----------------------------------------------------------------------------
// 2. CLASSE PRINCIPAL EXECUTÁVEL (Ponto de entrada: public static void main)
// ----------------------------------------------------------------------------
public class ExemploAula01 {

    public static void main(String[] args) {
        System.out.println("====================================================");
        System.out.println("       AULA 01: INTRODUÇÃO PRÁTICA À POO EM JAVA    ");
        System.out.println("====================================================\n");

        // --------------------------------------------------------------------
        // INSTANCIAÇÃO DO OBJETO 1 (Mundo Sensível: primeira ocorrência real)
        // --------------------------------------------------------------------
        System.out.println("1) Criando o Primeiro Objeto (carro1)...");
        Carro carro1 = new Carro(); // 'new' aloca memória heap para o objeto
        carro1.modelo = "Honda Civic";
        carro1.cor = "Preto";
        carro1.ano = 2022;
        carro1.velocidadeAtual = 0;
        carro1.motorLigado = false;

        // Executando métodos no carro1
        carro1.exibirStatus();
        carro1.acelerar(20); // Tentativa com motor desligado
        carro1.ligarMotor();
        carro1.acelerar(50);
        carro1.frear(15);
        carro1.exibirStatus();

        System.out.println("\n");

        // --------------------------------------------------------------------
        // INSTANCIAÇÃO DO OBJETO 2 (Segunda ocorrência independente)
        // --------------------------------------------------------------------
        System.out.println("2) Criando o Segundo Objeto (carro2)...");
        Carro carro2 = new Carro();
        carro2.modelo = "Volkswagen Fusca";
        carro2.cor = "Azul";
        carro2.ano = 1974;
        carro2.velocidadeAtual = 0;
        carro2.motorLigado = false;

        // Note que carro2 possui estado totalmente isolado de carro1!
        carro2.ligarMotor();
        carro2.acelerar(30);
        carro2.exibirStatus();

        System.out.println("Conclusão: Ambos os carros nasceram da mesma classe 'Carro',");
        System.out.println("mas cada um possui sua própria cor, velocidade e estado em memória!");
    }
}

