import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class Virtuales {
    void main() throws InterruptedException{
        AtomicInteger completadas = new AtomicInteger(0);
        AtomicLong sumaRespuestas = new AtomicLong(0);

        long inicio = System.currentTimeMillis();
        try (var exec = Executors.newVirtualThreadPerTaskExecutor()){
            for(int i = 0; i < 10000; i++){
                exec.submit(() -> {
                    try{
                        Thread.sleep(1000);
                        long r = consultaApi();
                        sumaRespuestas.addAndGet(r);
                        completadas.incrementAndGet();
                        return r;
                    }catch(InterruptedException e){
                        Thread.currentThread().interrupt();
                        return -1L;
                    }
                });
            }
        }
        long fin = System.currentTimeMillis();

        IO.println("Tareas Completadas: " + completadas.get());
        IO.println("Suma de Respuestas: " + sumaRespuestas.get()); 
        IO.println("Tiempo total (ms)" + (fin - inicio));
    }


    static long consultaApi(){
        return 42L;
    }
}
