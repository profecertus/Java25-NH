package pe.nh.demo07.exception;

import java.util.Map;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public record ApiError(
    String timestamp,
    int status,
    String error,
    String mensaje,
    Map<String, String> detalles
) 
{
    public static ApiError de(HttpStatus estado, String mensaje){
        return new ApiError(
            LocalDateTime.now().toString(),
            estado.value(), 
            estado.getReasonPhrase(), 
            mensaje, 
            null);
    }

    public static ApiError deValidacion(HttpStatus estado, Map<String,String> detalles){
        return new ApiError(
            LocalDateTime.now().toString(),
            estado.value(),
            estado.getReasonPhrase(),
            "La solicitud contiene campos invalidos",
            detalles
        );
    }
}
