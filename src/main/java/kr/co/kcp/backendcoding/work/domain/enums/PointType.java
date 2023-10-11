package kr.co.kcp.backendcoding.work.domain.enums;

public enum PointType{
    CODE_A("A"),
    CODE_B("B"),
    CODE_C("C"),
    CODE_D("D"),
    CODE_E("E"),
    CODE_F("F"),
    CODE_G("G");

    String value;

    PointType(String value) {
        this.value = value;
    }

    public String getName() {
        return this.name();
    }

    public String getValue(){
        return this.value;
    }
}
