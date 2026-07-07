public record Punto(int x, int y, int z){
    public Punto{
        if (x < 0 || y < 0 || z < 0) throw new IllegalArgumentException("negativo");
    }

    static void main(){
        Punto p1 = new Punto(3,4, 5);
        Punto p2 = new Punto(3,4, 5);
        IO.println("El valor de X en p1 es: " + p1.x);
        IO.println(p1.equals(p2));
    }
}

