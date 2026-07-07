public class SaldoInsuficienteThrowable extends Throwable {
    private final double faltante;

    //Constructor Simple
    public SaldoInsuficienteThrowable(double faltante){
        super("Faltan S/. " + faltante);
        this.faltante = faltante;
    }

    //Constructor con causa (cause chaining)
    public SaldoInsuficienteThrowable(double faltante, Throwable causa){
        super("Faltan S/. " + faltante, causa);
        this.faltante = faltante;
    }

    public double getFaltante(){return faltante;}

}
