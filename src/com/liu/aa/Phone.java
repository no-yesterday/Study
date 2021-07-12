package com.liu.aa;

public class Phone {
    private static Phone ourInstance = new Phone();

    public static Phone getInstance() {
        return ourInstance;
    }

    private Phone() {
    }

    public static void main(String[] args) {
        Phone phone = Phone.getInstance();
        Phone phone1 = Phone.getInstance();
        System.out.println(phone);
        System.out.println(phone1);
    }
}
