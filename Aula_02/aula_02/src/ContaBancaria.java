public class ContaBancaria {
    // Atributos
    private int numero;
    private double saldo;

    // Construtor
    public ContaBancaria(int numero, double saldo){
        this.numero = numero;
        this.saldo = saldo;
    }

    // Metodos
    public boolean depositar (double valor){
        if(valor<=0)
            return false;

        saldo+=valor;
        return true;
}

    public boolean depositar(int numero, double valor){
        if(numero != this.numero)
            return false;

        return depositar(valor);
    }


    public boolean sacar (double valor){
        if(valor <= 0 || valor > saldo)
            return false;

        saldo-=valor;
        return true;
    }

    // Getters e Setters
    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    // toString
    @Override
    public String toString() {
        return "ContaBancaria{" +
                "numero=" + numero +
                ", saldo=" + saldo +
                '}';
    }
}

