package pe.nh.demo07.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.*;

public class CategoriaValidaValidator implements ConstraintValidator<CategoriaValida, String> {
    public static final Set<String> CATEGORIAS = Set.of("tech", "oficina", "hogar", "otros");

    @Override
    public boolean isValid(String categoria, ConstraintValidatorContext context){
        if (categoria == null || categoria.isBlank()){
            return true;
        }
        return CATEGORIAS.contains(categoria.toLowerCase());
    }
}
