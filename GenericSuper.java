import java.util.ArrayList;
import java.util.List;

public class GenericSuper {
    
    public static void agregar(List<? super Prueba> destino){
        destino.add(new Prueba("Z"));
        destino.add(new Prueba("X"));
    }

    void main(){
        List<Prueba> pruebas = new ArrayList<>();
        agregar(pruebas);
        IO.println(pruebas);

    }
}

class Prueba{
    private String letra;
    Prueba(String letra){ this.letra = letra;}
    public String getLetra(){return letra;}
    public void setLetra(String letra){ this.letra = letra;}

    @Override
    public String toString(){return this.letra;}
}
