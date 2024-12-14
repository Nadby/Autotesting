package ru.cbr.test.lesson2.helpers;

import ru.cbr.test.lesson2.models.Drink;
import ru.cbr.test.lesson2.repositories.DrinkRepository;
import java.util.Arrays;

public class DrinkHelper {
    /**
     * Печать напитков (меню)
     * @param drinks массив напитков
     */
    public static void printDrinks(Drink[] drinks) {
        System.out.println("Меню:");
        for (Drink drink : drinks) {
            System.out.printf("%3d\t%15s\t%5d\n", drink.getId(), drink.getName(), drink.getPrice());
        }
    }

    /**
     * Проверка напитка, выбранного пользователем
     * Проверка осуществляется перед дальнейшими действиями (готовка, подача)
     * @param id идентификатор напитка
     * @return успешность проверки
     */
    //здесь должна быть реализована валидация по бизнес-требованиям
    //например, меню могут не успеть обновить, а молоко для изготовления капучино может закончиться
    //в качестве заглушки сделана проверка на существование напитка по id
    public static boolean validateDrinkById(int id) {
        return Arrays.stream(DrinkRepository.drinks)
                .anyMatch(x -> x.getId() == id);
    }
}
