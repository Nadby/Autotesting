package ru.cbr.test.lesson2;

import ru.cbr.test.lesson2.helpers.SessionHelper;
import ru.cbr.test.lesson2.helpers.DrinkHelper;
import ru.cbr.test.lesson2.session.Session;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Program1 {
    private static Session session;
    private static SessionHelper sessionHelper;
    private DrinkHelper drinkHelper;
    private static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        showWelcome();
        sc.close();
    }

    private static void showWelcome() {
        showMenu();
        choiceDrink();
        process();
    }

    private static void process() {
        if (checkBalance()) {
            if (session.changeBalance(-1 * sessionHelper.getPriceOfSelectedDrink())) {
                System.out.printf("ваш напиток %s готов!\n", sessionHelper.getNameOfSelectedDrink());
                if (session.getBalance() > 0) {
                    System.out.printf("заберите сдачу %s руб.", session.getBalance());
                }

            } else {
                System.out.println("ошибка при оплате");
            }
        } else {
            showBalance();
            System.out.printf("пополните баланс, не хватает %s руб.\n", sessionHelper.getPriceOfSelectedDrink() - session.getBalance());
            topUpBalance();
            process();
        }
    }

    private static void topUpBalance() {
        System.out.println("введите сумму пополнения:");
        try {
            int sum = sc.nextInt();
            if (sum > 0) {
                session.changeBalance(sum);
            }
        } catch (InputMismatchException e) {
            System.out.println("введенная строка не может быть преобразована в целое число!");
            sc.next();
            topUpBalance();
        }
    }

    private static boolean checkBalance() {
        return sessionHelper.checkBalance();
    }

    private static void choiceDrink() {
        System.out.println("выберите напиток из представленных в меню, введя соответствующмй номер:");
        try {
            int drinkId = sc.nextInt();
            if (new DrinkHelper().validateDrinkById(drinkId)) {
                System.out.println("отличный выбор!");
                if (session == null) {
                    session = new Session(drinkId);
                    sessionHelper = new SessionHelper(session);
                } else {
                    session.setDrinkId(drinkId);
                }
            } else {
                showMenu();
                choiceDrink();
            }
        } catch (InputMismatchException e) {
            System.out.println("введенная строка не может быть преобразована в целое число!");
            sc.next();
            choiceDrink();
        }
    }

    private static void showBalance() {
        sessionHelper.printBalance();
    }

    private static void showMenu() {
        DrinkHelper.printDrinks(DrinkHelper.getAllDrinks());
    }

}