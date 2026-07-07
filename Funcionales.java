import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class Funcionales {
    void main(){
        //SUPPLIER -> no recibre nada, produce T (lazy factory)
        Supplier<List<Persona>> fabrica = () -> List.of(
            new Persona("Juan", 17),
            new Persona("Maria", 25),
            new Persona("Pedro", 15),
            new Persona("Lucia", 40)
        );

        //PREDICATE<T> -> Recibe T, devuelve el boolean
        Predicate<Persona> esMayorDeEdad = p -> p.edad >= 18;
        Predicate<Persona> nombreLargo = p -> p.nombre.length() > 4;
        //Crear el filtro combinando los predicados anteriores
        Predicate<Persona> filtro = esMayorDeEdad.and(nombreLargo);

        //FUNCTION<T,R> -> Recibe T devuelve R
        Function<Persona, String>aTexto = p -> p.nombre.toUpperCase() + "(" + p.edad + ")";

        //CONSUMER<T> -> recibe T, no devuelve nada
        Consumer<String> imprimir = s -> IO.println(" -> " + s);

        //La logica del negocio entrelazados en un pipeline
        List<Persona> personas = fabrica.get();

        personas.stream()
            .filter(filtro)
            .map(aTexto)
            .forEach(imprimir);

        /*IO.println("\n-- manual ---");
        for(Persona p : fabrica.get()){
            if(filtro.test(p)){
                String txt = aTexto.apply(p);
                imprimir.accept(txt);
            }
        }*/
    }    
}

class Persona{
    String nombre;
    int edad;

    Persona(String nombre, int edad){
        this.nombre = nombre;
        this.edad = edad;
    }

    @Override
    public String toString(){
        return nombre + "(" + edad + ")";
    }
}