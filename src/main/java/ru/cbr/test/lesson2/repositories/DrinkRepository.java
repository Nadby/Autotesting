package ru.cbr.test.lesson2.repositories;

import ru.cbr.test.lesson2.exceptions.DrinkNotFoundException;
import ru.cbr.test.lesson2.models.Drink;
import java.util.Arrays;

public class DrinkRepository {
    public static Drink[] drinks = new Drink[3];

    static  {
        drinks[0] = new Drink(1, "Капучино", 100);
        drinks[1] = new Drink(2, "Лате", 120);
        drinks[2] = new Drink(3, "Эспрессо", 80);
    }

    /**
     * Получение напитка Drink по идентификатору
     * @param drinkId идентификатор напитка
     * @return напиток Drink
     * @throws DrinkNotFoundException
     */
    public static Drink getDrinkById(int drinkId) throws DrinkNotFoundException {
        return Arrays.stream(drinks)
                .filter(x -> x.getId() == drinkId)
                .findFirst()
                .orElseThrow(() -> new DrinkNotFoundException("не найден напиток с идентификатором " + drinkId));
    }

    /**
     * Получение всех напитков
     * @return массив напитков
     */
    public static Drink[] getAllDrinks() {
        return drinks;
    }
}
