public interface Repositorio<T>{
    void guardar(T t);
    default boolean existe(T t){return false;}
    static String version(){ return "1.0";}
}