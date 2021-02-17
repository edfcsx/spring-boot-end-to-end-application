package com.edfcsx.springbootendtoendapplication.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_payments_credit_card")
public class PaymentWithCard extends Payment {

    private static final long serialVersionUID = 1L;

    private Integer installments;

    public PaymentWithCard() {}

    public PaymentWithCard(Integer id, Integer status, Order order, Integer installments) {
        super(id, status, order);
        this.installments = installments;
    }

    public Integer getInstallments() {
        return installments;
    }

    public void setInstallments(Integer installments) {
        this.installments = installments;
    }
}
