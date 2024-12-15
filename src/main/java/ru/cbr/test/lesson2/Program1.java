package ru.cbr.test.lesson2;

import ru.cbr.test.lesson2.exceptions.NotEnoughBalanceException;
import ru.cbr.test.lesson2.helpers.DrinkHelper;
import ru.cbr.test.lesson2.repositories.DrinkRepository;
import ru.cbr.test.lesson2.services.ISessionService;
import ru.cbr.test.lesson2.services.SessionService;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Program1 {

    private static Scanner sc;
    private static ISessionService sessionService;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        showMenu();
        selectDrink();
        topUpBalance();
        process();
        sc.close();
    }

    private static void process() {
        boolean processed;
        try {
            processed = sessionService.process();
            if (processed) {
                System.out.printf("ваш напиток %s готов!\n", sessionService.getNameOfSelectedDrink());
                if (sessionService.getBalance() > 0) {
                    System.out.printf("заберите сдачу %s руб.", sessionService.getBalance());
                }
            } else {
                //транзакция откатывается, возврат средств
                System.out.println("произошла ошибка");
            }
        } catch (NotEnoughBalanceException e) {
            sessionService.printBalance();
            System.out.printf("пополните баланс, не хватает %s руб.\n", sessionService.getPriceOfSelectedDrink() - sessionService.getBalance());
            topUpBalance();
            process();
        }
    }

    private static void selectDrink() {
        System.out.println("выберите напиток из представленных в меню, введя соответствующмй номер:");
        try {
            int drinkId = sc.nextInt();
            if (DrinkHelper.validateDrinkById(drinkId)) {
                System.out.println("отличный выбор!");
                if (sessionService == null) {
                    sessionService = new SessionService(drinkId);
                }
            } else {
                System.out.println("выбран несуществующий номер напитка");
                showMenu();
                selectDrink();
            }
        } catch (InputMismatchException e) {
            System.out.println("введенная строка не может быть преобразована в целое число!");
            sc.next();
            selectDrink();
        }
    }

    private static void topUpBalance() {
        System.out.println("введите сумму пополнения:");
        try {
            int sum = sc.nextInt();
            if (validateSum(sum)) {
                sessionService.topUpBalance(sum);
            }
        } catch (InputMismatchException e) {
            System.out.println("введенная строка не может быть преобразована в целое число!");
            sc.next();
            topUpBalance();
        }
    }

    private static void showMenu() {
        DrinkHelper.printDrinks(DrinkRepository.getAllDrinks());
    }

    private static boolean validateSum(int sum) {
        return sum > 0;
    }
}