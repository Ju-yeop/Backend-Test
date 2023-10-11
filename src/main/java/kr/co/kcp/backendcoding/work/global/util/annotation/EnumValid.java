package kr.co.kcp.backendcoding.work.global.util.annotation;

import jakarta.validation.Constraint;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kr.co.kcp.backendcoding.work.global.util.EnumValidValidator;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EnumValidValidator.class)
public @interface EnumValid {
    String message() default "해당 필드의 타입에서 지원하지 않는 값입니다.";

    Class[] groups() default {};

    Class<? extends Enum> enumClass();

    Class[] payload() default {};
}
