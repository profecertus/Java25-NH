import java.util.Comparator;
import java.util.List;

public class Generics {
    public static <T extends Comparable<T>> T maximo(List<T> lista){
        return lista.stream()
            .max(Comparator.naturalOrder())
            .orElseThrow();
    }

    void main(){
        var mayor = maximo(List.of(new Prueba("A"), new Prueba("B")));
        //var mayor = maximo(List.of(1,2,3,4,5,6));
        IO.println(mayor);
    }    
}

class Prueba implements Comparable<Prueba>{
    private String letra;

    Prueba(String letra){this.letra = letra;}
    
    public String getLetra(){return letra;}
    public void setLetra(String letra){this.letra = letra;}

    @Override
    public String toString(){
        return this.letra;
    }
    
    @Override
    public int compareTo(Prueba o) {
        return this.letra.compareTo(o.letra);        
    }
}
