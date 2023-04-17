package com.godoro.inheritance;

public class Supplier extends Person {
    private long supplierId;
    private long totalCredit;

    public Supplier(long supplierId, String firstName, String lastName, long totalCredit) {
        super(firstName, lastName);
        this.supplierId = supplierId;
        this.totalCredit = totalCredit;
    }

    public long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(long supplierId) {
        this.supplierId = supplierId;
    }

    public long getTotalCredit() {
        return totalCredit;
    }

    public void setTotalCredit(long totalCredit) {
        this.totalCredit = totalCredit;
    }

    @Override
    public String getGreeting() {
        return "Selam";
    }
}
