package kr.co.kcp.backendcoding.work.global.util;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import kr.co.kcp.backendcoding.work.global.util.annotation.EnumValid;

public class EnumValidValidator implements ConstraintValidator<EnumValid, Enum> {
    private List<Object> enumValues;

    @Override
    public void initialize(EnumValid constraintAnnotation) {
        Class<? extends Enum> enumClass = constraintAnnotation.enumClass();
        enumValues =  Arrays.stream(enumClass.getEnumConstants()).collect(Collectors.toList());
    }

    @Override
    public boolean isValid(Enum value, ConstraintValidatorContext context) {
        return value != null && enumValues.contains(value);
    }
}
