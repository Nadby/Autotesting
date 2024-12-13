package ru.cbr.test.lesson2.models;

public class Drink {
    private final int id;
    private final String name;
    private int price;
    public Drink(int id, String name, int price) {
        this(id, name);
        this.price = price;
    }
    public Drink(int id, String name) {
        this.id = id;
        this.name = name;
        this.price = 0;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getPrice() {
        return price;
    }
}
