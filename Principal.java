
sealed interface Pago permits Tarjeta, Efectivo {}

public class Principal {
    String describir(Pago p) {
        return switch (p) {
            case Tarjeta t -> "Tarjeta " + t.num();
            case Efectivo e when e.monto()> 1000 -> "Efectivo GRANDE: " + e.monto();
            case Efectivo e -> "Efectivo: " + e.monto();
        };
    }

    void main(){
        IO.println(describir(new Tarjeta("1234")));
        IO.println(describir(new Efectivo(50.0)));
        IO.println(describir(new Efectivo(5000.0)));
    }
}

record Tarjeta(String num) implements Pago {};

record Efectivo(double monto) implements Pago {};
