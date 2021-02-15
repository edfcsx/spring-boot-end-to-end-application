package com.edfcsx.springbootendtoendapplication.domain.enums;

public enum CustomerType {

    NATURAL_PERSON(1, "Pessoa Física"),
    LEGAL_PERSON(2, "Pessoa Jurídica");

    private int cod;
    private String description;

    private CustomerType(int cod, String description) {
        this.cod = cod;
        this.description = description;
    }

    public int getCod() {
        return cod;
    }

    public String getDescription() {
        return description;
    }

    public static CustomerType toEnum(Integer cod) {
        if (cod == null) return null;

        for (CustomerType type : CustomerType.values()) {
            if (cod.equals(type.getCod())) {
                return type;
            }
        }

        throw new IllegalArgumentException(String.format("Enum cod %d is invalid", cod));
    }
}
