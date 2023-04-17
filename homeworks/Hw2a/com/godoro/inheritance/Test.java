package com.godoro.inheritance;

public class Test {
    public static void main(String[] args) {
        Customer customer = new Customer(301, "Cem", "Karaca", 6540);
        customer.setEmailAddress("cem@godoro.com");

        Person person = new Customer(302, "Barış", "Manço", 7620);
        person.setEmailAddress("baris@godoro.com");

        Supplier supplier = new Supplier(701, "Fikret", "Kızılok", 8795);
        supplier.setEmailAddress("fikret@godoro.com");

        Employee employee = new Employee(401, "Edip", "Akbayram", 5000);
        employee.setEmailAddress("edip@godoro.com");

        System.out.println(customer.getGreeting() + " " + customer.getFullName());
        System.out.println(person.getGreeting() + " " + person.getFullName());
        System.out.println(supplier.getGreeting() + " " + supplier.getFullName());
        System.out.println(employee.getGreeting() + " " + employee.getFullName());

        sendMail(customer);
        sendMail(person);
        sendMail(supplier);
        sendMail(employee);
    }

    private static void sendMail(Person person) {
        System.out.println();
        System.out.println("Kime: " + person.getEmailAddress());
        System.out.println("Konu: " + person.getGreeting());
        System.out.println("Gövde: " + person.getFullName());
    }
}
