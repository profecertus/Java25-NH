import java.util.List;

class Animal{
    protected String nombre;
    
    Animal(String nombre){ this.nombre = nombre;} //Explicito

    String sonido(){return "....";}

    static void main(){
        //Animal perro = new Perro("Tobby");
        //IO.println(perro.sonido());
        var animales = List.of(new Perro("Tobby"), new Gato("Mia"));
        for(Animal a : animales){
            IO.println(a.sonido());
        }
    }
}

class Perro extends Animal{
    Perro(String nombre){super(nombre);}

    @Override
    String sonido(){return "Guau";}
}

class Gato extends Animal{
    Gato(String nombre){super(nombre);}

    @Override
    String sonido(){return "Miau";}
}