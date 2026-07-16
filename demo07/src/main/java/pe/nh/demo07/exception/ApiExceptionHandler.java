package pe.nh.demo07.exception;

import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError validacion(MethodArgumentNotValidException ex){
        var detalles = ex.getBindingResult().getFieldErrors().stream()
            .collect(
                Collectors.toMap(
                    error -> error.getField(),
                    error -> error.getDefaultMessage() == null?
                            "valor invalido":error.getDefaultMessage(),
                    (primero, _) -> primero)
                );
        return ApiError.deValidacion(HttpStatus.BAD_REQUEST, detalles);
    }

    @ExceptionHandler(RecursoNoEncontradoException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiError noEncontrado(RecursoNoEncontradoException ex){
        return ApiError.de(HttpStatus.NOT_FOUND, ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiError inesperado(Exception ex){
        var mensaje = switch(ex){
            case IllegalArgumentException e -> "Argumento invalido: " + e.getMessage();
            case NullPointerException _ -> "Referencia nula inesperada";
            default -> "Error interno del servidor";
        };
        return ApiError.de(HttpStatus.INTERNAL_SERVER_ERROR, mensaje);
    }
}
