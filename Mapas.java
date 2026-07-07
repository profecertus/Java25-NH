import java.util.*;

public class Mapas {
    Map<String, Persona> agenda = new HashMap<>();
    void main(){
        /*Map<String, Integer> edades = new HashMap<String, Integer>();
        edades.put("Ana",30 );
        edades.put("Luis", 25);
        
        for(var e:edades.entrySet()){
            IO.println(e.getKey() + " -> " + e.getValue());
        }*/
        agenda.put("12345678", new Persona("Juan"));
        agenda.put("23456789", new Persona("Maria"));
        agenda.put("34567890", new Persona("Juan Perez"));

        IO.println(agenda.size());
        IO.println(agenda.get("23456789"));
        IO.println(agenda);
    }
}

class Persona{
    String nombre;
    Persona(String nombre){this.nombre = nombre;}
    @Override public String toString(){return this.nombre;}
}
