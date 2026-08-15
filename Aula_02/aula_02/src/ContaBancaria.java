public class ContaBancaria {
    // Atributos
    int numero;
    double saldo;

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


    public boolean sacar (double valor){
        if(valor <= 0 || valor > saldo)
            return false;

        saldo-=valor;
        return true;
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

