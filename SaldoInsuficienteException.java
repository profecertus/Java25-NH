public class SaldoInsuficienteException extends RuntimeException{
    private final double faltante;

    public SaldoInsuficienteException(double faltante){
        super("Faltan S/. " + faltante);
        this.faltante = faltante;
    }

    public double getFaltante(){
        return faltante;
    }
    
}
