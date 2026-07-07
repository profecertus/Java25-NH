public class CuentaBancaria{    
    private double saldo; //Inicializacion implicita

    public void depositar(double monto){
        if (monto > 0){
            IO.println("Despositando: " + monto);
            saldo += monto;  //saldo = saldo + monto         
        } 
    }

    public double getSaldo() { return saldo;}    

    void main(){
        //Instanciamos la clase
        CuentaBancaria cuentaBancaria = new CuentaBancaria();
        //Hacemos el deposito    
        cuentaBancaria.depositar(30);        
        IO.println("El saldo de su cuenta es: " + cuentaBancaria.getSaldo());
        cuentaBancaria.depositar(130);
        IO.println("El saldo de su cuenta es: " + cuentaBancaria.getSaldo());
    }
}

