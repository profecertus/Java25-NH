public class Manejo {
    int divisor = 10;
    void main(){
        try{
            for(int i = divisor; i>=1; i--){
                int r = 10 /i;
                procesar(r);
            }
            
        }catch (ArithmeticException e){
            IO.println("División Inválida: " + e.getMessage());
            e.printStackTrace();
        }catch(Exception e){
            IO.println("Fallo inesperado"  + e.getMessage());
        }finally{ //Siempre se va ejecutar
            IO.print("No se preocupe estamos trabajando en el Error..");
        }        
    }

    void procesar(float r){
        if(r>0){
            IO.println("Operación Correcta " + r);
        }
    }
    
}
