package pe.nh.demo07.validation;

import java.lang.annotation.*;
import jakarta.validation.*;

@Documented
@Constraint(validatedBy = CategoriaValidaValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.RECORD_COMPONENT})
@Retention(RetentionPolicy.RUNTIME)
public @interface CategoriaValida {
    String message() default "Categoria No Valida";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default{};
}
