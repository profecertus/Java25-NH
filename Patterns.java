record Punto(int x, int y){}
record Linea(Punto a, Punto b){}

public class Patterns{
    static void main(){
        Punto p1 = new Punto(10,5);
        Punto p2 = new Punto(23,24);
        Object o = new Linea(p1, p2);
        if(o instanceof Linea(Punto(var x1, var y1), Punto(var x2, var y2))){
            IO.println(x1 + ", " + y1 + " -> " + x2 + ", " + y2);
        }
    }    
}