import java.lang.ScopedValue;

public class Contexto {
    static final ScopedValue<String> USUARIO = ScopedValue.newInstance();  
    
    void main() throws InterruptedException{
        IO.println("=== JEP 506: Scoped Value demo ===\n");

        ScopedValue.where(USUARIO, "Edwin").run(() -> {
            procesarSolicitud();
        });

        ScopedValue.where(USUARIO, "Sofia").run(() -> {
            procesarSolicitud();
        });

        IO.println("\nFuera del ambito, isBound() = " + USUARIO.isBound());
    }

    static void procesarSolicitud(){
        IO.println("Procesnado solicitud de: " + USUARIO.get());
        auditar();
    }

    static void auditar(){
        IO.println("[auditoria] accion registrada por: " + USUARIO.get());
    }
}
