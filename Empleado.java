class Persona{
    int edad;
    Persona(int edad){this.edad = edad;}
}

public class Empleado extends Persona{
    String nombre;

    Empleado(String nombre, int edad){
        if (edad < 18 || edad > 67) throw new IllegalArgumentException("Edad");        
        super(edad);
        this.nombre = nombre;        
    }
}
