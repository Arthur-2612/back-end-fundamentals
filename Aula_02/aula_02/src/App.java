public class App {
    public static void main(String[] args) throws Exception {
        ContaBancaria c1 = new ContaBancaria(1234, 0);

        if (c1.depositar(100)) {
            System.out.println("Depósito realizado com sucesso.");
        }else {
            System.out.println("Falha ao realizar depósito.");
        }

        if (c1.depositar(4321, 1000)){
            System.out.println("Depósito realizado com sucesso.");
        }else {
            System.out.println("Falha ao realizar depósito.");
        }
        
        c1.sacar(30);

        System.out.println(c1.getSaldo());
        System.out.println(c1.getNumero());

    }
}
