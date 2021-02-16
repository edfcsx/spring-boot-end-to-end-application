package com.edfcsx.springbootendtoendapplication.domain.enums;

public enum PaymentStatus {

    PENDING(0, "Pendente"),
    PAID(1, "Pago"),
    CANCELLED(2, "Cancelado");

    private int cod;
    private String description;

    PaymentStatus(int cod, String description) {
        this.cod = cod;
        this.description = description;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static PaymentStatus toEnum(Integer cod) {
        if (cod == null) return null;

        for (PaymentStatus paymentStatus : PaymentStatus.values()) {
            if (cod.equals(paymentStatus.getCod())) return paymentStatus;
        }

        throw new IllegalArgumentException(String.format("Enum cod: %d is invalid", cod));
    }
}
