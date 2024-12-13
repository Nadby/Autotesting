package ru.cbr.test.lesson2.helpers;

import ru.cbr.test.lesson2.exceptions.DrinkNotFoundException;
import ru.cbr.test.lesson2.models.Drink;

import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

public class DrinkHelper {
    private static Drink[] drinks = new Drink[3];
    static  {
        drinks[0] = new Drink(1, "Капучино", 100);
        drinks[1] = new Drink(2, "Лате", 120);
        drinks[2] = new Drink(3, "Эспрессо", 80);
    }
    public static void printDrinks(Drink[] drinks) {
        System.out.println("Меню:");
        for (Drink drink : drinks) {
            System.out.printf("%3d\t%15s\t%5d\n", drink.getId(), drink.getName(), drink.getPrice());
        }
    }
    public static Drink getDrinkById(int drinkId) throws DrinkNotFoundException {
        return Arrays.stream(drinks)
                .filter(x -> x.getId() == drinkId)
                .findFirst()
                .orElseThrow(() -> new DrinkNotFoundException("не найден напиток с идентификатором " + drinkId));
    }
    public static Drink[] getAllDrinks() {
        return drinks;
    }
    public boolean validateDrinkById(int id) {
        try {
            Drink drink = getDrinkById(id);
        }
        catch (DrinkNotFoundException e) {
            System.out.println("неверный выбор напитка");
            return false;
        }
        return true;
    }
}
