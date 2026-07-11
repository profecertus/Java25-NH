import java.util.concurrent.StructuredTaskScope;

public class Perfil {
    record PerfilDTO(String user, int pedidos, double saldo){}

    void main() throws Exception{
        IO.println("=== JEP 505 ===\n");

        long inicio = System.currentTimeMillis();
        PerfilDTO perfil = cargarPerfil();
        long ms = System.currentTimeMillis() - inicio;

        IO.println("Resultado Combinado: " + perfil);
        IO.println("Tiempo total: " + ms + " ms (aprox la subtarea mas lenta");
    }

    static PerfilDTO cargarPerfil() throws Exception{
        try(var scope = StructuredTaskScope.open()){
            var u = scope.fork(() -> api_usuario());
            var p = scope.fork(() -> api_pedidos());
            var s = scope.fork(() -> api_saldo());

            scope.join();

            return new PerfilDTO(u.get(),p.get(),s.get());
        }
    }

    static String api_usuario() throws InterruptedException{
        Thread.sleep(200);
        return "Edwin";
    }

    static int api_pedidos() throws InterruptedException{
        Thread.sleep(500);
        return 3;
    }

    static double api_saldo() throws InterruptedException{
        Thread.sleep(300);
        return 1520.75;
    }
}
