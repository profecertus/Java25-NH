import java.util.*;
import java.util.stream.Collectors;

public class Collect {
    void main(){
        var nombres = List.of("jose", "giuliano", "estefani");
        String csv = nombres.stream()
            .collect(Collectors.joining(","));

        var setMayuscula = nombres.stream()
            .map(String::toUpperCase)
            .collect(Collectors.toSet());
        IO.println(csv);
        IO.println(setMayuscula);
    }
    
}
