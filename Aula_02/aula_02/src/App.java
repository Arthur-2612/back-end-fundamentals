public class App {
    public static void main(String[] args) throws Exception {
        ContaBancaria c1 = new ContaBancaria(1234, 0);
        ContaBancaria c2 = new ContaBancaria(4321);

        c1.depositar(100);
        c1.depositar(4321, 1000);
        c1.sacar(30);

        System.out.println(c1.getSaldo());
        System.out.println(c1.getNumero());

    }
}
