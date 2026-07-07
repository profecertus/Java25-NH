import java.util.*;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Pool {
    void main() {
        var pool = Executors.newFixedThreadPool(10);
        List<Future<String>> tareas = new ArrayList<>();

        // Enviar las 10 tareas
        for (int i = 0; i < 10; i++) {
            final int id = i + 1;
            Future<String> tarea = pool.submit(() -> {
                Thread.sleep(100);
                return "listo " + id;
            });
            tareas.add(tarea);
        }

        try {
            for(Future<String> tarea:tareas){
                IO.println(tarea.get());
            }
        } catch (CancellationException e) {
            IO.println("Se cancelaron los hilos");
        } catch (ExecutionException e) {
            IO.println("Error de ejecucion");
        } catch (InterruptedException e) {
            IO.println("El hilo se interrumpio");
        } finally {
            pool.shutdown();
        }

    }
}
