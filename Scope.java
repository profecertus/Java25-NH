import java.util.concurrent.StructuredTaskScope;
import java.util.concurrent.StructuredTaskScope.Subtask;

public class Scope {
    void main() throws InterruptedException{
        IO.println("=== JEP 505: Structured Concurrency demo ===\n");

        cargarPerfil();

        IO.println("==============================");
        
        try{
            cargarPerfilConFallo();
        }catch(Exception e){
            IO.println(">> El scope propago el fallo: " + e.getMessage());
        }
    }

    static void cargarPerfil() throws InterruptedException{
        try (var scope = StructuredTaskScope.<String>open()){
            Subtask<String> usuario = scope.fork(() -> buscarUsuario());
            Subtask<String> pedidos = scope.fork(() -> buscarPedidos());

            scope.join();

            IO.println(usuario.get() + " - " + pedidos.get());
        }
    }

    static void cargarPerfilConFallo() throws InterruptedException{
        try(var scope = StructuredTaskScope.<String>open()){
            Subtask<String> ok = scope.fork(() -> buscarUsuario());
            Subtask<String> falla = scope.fork(() -> { 
                throw new RuntimeException("timeout DB pedidos");
            });

            scope.join();

            IO.println(ok.get() + " - " + falla.get());
        }
    }

    static String buscarUsuario() throws InterruptedException{
        Thread.sleep(300);
        return "Usuario: Edwin";
    }

    static String buscarPedidos() throws InterruptedException{
        Thread.sleep(300);
        return "Pedido: 3";
    }
}
