package ru.cbr.test.lesson2.session;

import ru.cbr.test.lesson2.exceptions.DrinkNotFoundException;
import ru.cbr.test.lesson2.helpers.DrinkHelper;
import ru.cbr.test.lesson2.models.Drink;

public class Session {
    private int drinkId;
    private int balance;

    public Session(int drinkId, int balance) {
        this.drinkId = drinkId;
        this.balance = balance;
    }
    public Session(int drinkId) {
        this.drinkId = drinkId;
        this.balance = 0;
    }
    public boolean changeBalance(int d) {
        if (balance + d >= 0) {
            balance += d;
            return true;
        }
        else {
            return false;
        }
    }
    public int getBalance() {
        return balance;
    }
    public int getDrinkId() {
        return drinkId;
    }
    public void setDrinkId(int drinkId) {
        this.drinkId = drinkId;
    }
}
