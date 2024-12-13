package ru.cbr.test.lesson2.helpers;

import ru.cbr.test.lesson2.exceptions.DrinkNotFoundException;
import ru.cbr.test.lesson2.session.Session;

import java.math.BigInteger;

public class SessionHelper {
    private final Session session;
    public SessionHelper(Session session) {
        this.session = session;
    }

    public void printBalance() {
        System.out.printf("текущий баланс: %5d (руб.)\n", session.getBalance());
    }

    public boolean checkBalance()  {
        return session.getBalance() >= getPriceOfSelectedDrink();
    }
    public int getPriceOfSelectedDrink() {
        int price = 0;
        try {
            price = DrinkHelper.getDrinkById(session.getDrinkId()).getPrice();
        }
        catch (DrinkNotFoundException e) {
            System.out.printf("не удалось определить цену. не найден напиток с id=%s", session.getDrinkId());
        }
        return price;
    }

    public String getNameOfSelectedDrink() {
        String name = "";
        try {
            name = DrinkHelper.getDrinkById(session.getDrinkId()).getName();
        }
        catch (DrinkNotFoundException e) {
            System.out.printf("не удалось определить наименование. не найден напиток с id=%s", session.getDrinkId());
        }
        return name;
    }
}
