import java.util.*;

public class Conjuntos {
    Set<Persona> unicos = new HashSet<Persona>();

    void main(){
        unicos.add(new Persona("Juan"));
        unicos.add(new Persona("Juan"));
        unicos.add(new Persona("Juan"));
        unicos.add(new Persona("Juan"));        
        //IO.println(unicos.size());
        //IO.println(unicos);
        for(Persona p : unicos){
            IO.println(p);
        }

        //var ordenado = new TreeSet<>(unicos);
        //IO.println(ordenado);
    }
}

class Persona{
    String nombre;
    Persona(String nombre){this.nombre = nombre;}
    @Override
    public String toString(){
        return this.nombre;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Persona p = (Persona) o;
        return Objects.equals(nombre, p.nombre);
    }

    @Override
    public int hashCode(){
        return Objects.hash(nombre);
    }
}