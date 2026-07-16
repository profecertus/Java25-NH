package pe.nh.demo07.exception;

public class RecursoNoEncontradoException extends RuntimeException {
    public RecursoNoEncontradoException(String mensaje){
        super(mensaje);
    }
}
