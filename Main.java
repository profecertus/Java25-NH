class Cuenta{
    private final String titular;
    private double saldo;

    public Cuenta(String titular, double saldoInicial){
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    public void depositar(double monto){        
        if(monto <=0) throw new IllegalArgumentException("El monto debe ser positivo");
        saldo += monto;
        System.out.printf("Déposito de S/. %.2f -> saldo: S/. %.2f%n", monto, saldo);
    }

    public void retirar(double monto) throws SaldoInsuficienteThrowable{
        if(monto <= 0 ) throw new IllegalArgumentException("El monto debe ser positivo");

        if(monto > saldo){
            throw new SaldoInsuficienteThrowable(monto - saldo);
        }
        saldo -= monto;
        System.out.printf("Retiro de S/. %.2f -> saldo: S/. %.2f%n", monto, saldo);
    }

    /*public void retirar(double monto){
        if(monto <= 0) throw new IllegalArgumentException("El monto debe se positivo");
        if(monto>saldo){
            throw new SaldoInsuficienteException(monto - saldo);
        }
        saldo -= monto;
        System.out.printf("Retiro de S/. %.2f -> saldo: S/. %.2f%n", monto, saldo);
    }*/

    public double getSaldo(){return saldo;}
    public String getTitular(){return titular;}
}

public class Main {
    void main(){
        Cuenta cuenta = new Cuenta("Edwin", 100.0);
        IO.println("Cuenta de " + cuenta.getTitular() + " | saldo inicial: S/. " + cuenta.getSaldo());
        
        try{
            cuenta.depositar(50.0);
            cuenta.retirar(30.0);
            cuenta.retirar(500.0);
        }catch(SaldoInsuficienteThrowable e){
            IO.println("No se puede retirar: " + e.getMessage());
            System.out.printf(" Te faltan exactamente S/. %.2f%n", e.getFaltante());
        }
        

        IO.println("Saldo Final: S/. " + cuenta.getSaldo());
    }
}
