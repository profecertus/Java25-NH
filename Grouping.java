import java.util.*;
import java.util.stream.Collectors;

public class Grouping {
    void main(){
        var palabras = List.of("ana", "ada", "bob", "cleo");
        Map<Character,List<String>> porInicial =
            palabras.stream().collect(
              Collectors.groupingBy(s -> s.charAt(0))  
            );

        Map<Boolean, List<String>> porLargo =
            palabras.stream().collect(
                Collectors.partitioningBy(s -> s.length() > 3)
            );

        for(var v : porInicial.entrySet()){
            IO.println(v.getKey() + " -> " + v.getValue());
        }

        for(var v : porLargo.entrySet()){
            IO.println(v.getKey() + " -> " + v.getValue());
        }

    }
}
