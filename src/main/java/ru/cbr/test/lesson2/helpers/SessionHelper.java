package ru.cbr.test.lesson2.helpers;

import ru.cbr.test.lesson2.exceptions.DrinkNotFoundException;
import ru.cbr.test.lesson2.repositories.DrinkRepository;
import ru.cbr.test.lesson2.session.Session;

public class SessionHelper {
    private final Session session;
    public SessionHelper(Session session) {
        this.session = session;
    }

    /**
     * Печать баланса
     */
    public void printBalance() {
        System.out.printf("текущий баланс: %5d (руб.)\n", session.getBalance());
    }

    /**
     * Проверка достоточности средств для покупки выбранного напитка
     * @return результат проверки
     */
    public boolean checkPurchasePossibility()  {
        return session.getBalance() >= getPriceOfSelectedDrink();
    }

    /**
     * Получение цены выбранного напитка
     * @return цена, руб.
     */
    public int getPriceOfSelectedDrink() {
        int price = 0;
        try {
            price = DrinkRepository.getDrinkById(session.getDrinkId()).getPrice();
        }
        catch (DrinkNotFoundException e) {
            System.out.printf("не удалось определить цену. не найден напиток с id=%s", session.getDrinkId());
        }
        return price;
    }

    /**
     * Получение наименования выбранного напитка
     * @return наименование выбранного напитка
     */
    public String getNameOfSelectedDrink() {
        String name = "";
        try {
            name = DrinkRepository.getDrinkById(session.getDrinkId()).getName();
        }
        catch (DrinkNotFoundException e) {
            System.out.printf("не удалось определить наименование. не найден напиток с id=%s", session.getDrinkId());
        }
        return name;
    }
}
