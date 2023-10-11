package kr.co.kcp.backendcoding.work.domain.enums;


import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.stream.Stream;

public enum PaymentType {
    AA01("CARD"),
    AA02("CASH");

    String value;

    PaymentType(String value){
        this.value = value;
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static PaymentType findByType(String type) {
        return Stream.of(PaymentType.values())
                .filter(c -> c.value.equals(type))
                .findFirst()
                .orElse(null);
    }
}
