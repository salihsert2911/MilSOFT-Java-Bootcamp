package com.godoro.inheritance;

public class Customer extends Person {
    private long customerId;
    private double totalDebt;

    public Customer(long customerId, String firstName, String lastName, double totalDebt) {
        super(firstName, lastName);
        this.customerId = customerId;
        this.totalDebt = totalDebt;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public double getTotalDebt() {
        return totalDebt;
    }

    public void setTotalDebt(double totalDebt) {
        this.totalDebt = totalDebt;
    }

    @Override
    public String getFullName() {
        return lastName + ", " + firstName;
    }

    @Override
    public String getGreeting() {
        return "Merhaba";
    }
}
