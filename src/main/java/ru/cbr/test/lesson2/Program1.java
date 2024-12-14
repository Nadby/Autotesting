package ru.cbr.test.lesson2;

import ru.cbr.test.lesson2.exceptions.NotEnoughBalanceException;
import ru.cbr.test.lesson2.helpers.SessionHelper;
import ru.cbr.test.lesson2.helpers.DrinkHelper;
import ru.cbr.test.lesson2.repositories.DrinkRepository;
import ru.cbr.test.lesson2.services.SessionService;
import ru.cbr.test.lesson2.session.Session;
import java.util.InputMismatchException;
import java.util.Scanner;

// обратную связь оставлять в ветке for-pull-requests
public class Program1 {

    private static Scanner sc;
    private static Session session;
    private static SessionHelper sessionHelper;
    private static SessionService sessionService;

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
                System.out.printf("ваш напиток %s готов!\n", sessionHelper.getNameOfSelectedDrink());
                if (session.getBalance() > 0) {
                    System.out.printf("заберите сдачу %s руб.", session.getBalance());
                }
            } else {
                //транзакция откатывается, возврат средств
                System.out.println("произошла ошибка");
            }
        } catch (NotEnoughBalanceException e) {
            sessionHelper.printBalance();
            System.out.printf("пополните баланс, не хватает %s руб.\n", sessionHelper.getPriceOfSelectedDrink() - session.getBalance());
            topUpBalance();
            process();
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

    private static boolean validateSum(int sum) {
        return sum > 0;
    }

    private static void selectDrink() {
        System.out.println("выберите напиток из представленных в меню, введя соответствующмй номер:");
        try {
            int drinkId = sc.nextInt();
            if (DrinkHelper.validateDrinkById(drinkId)) {
                System.out.println("отличный выбор!");
                if (session == null) {
                    session = new Session(drinkId);
                    sessionHelper = new SessionHelper(session);
                    sessionService = new SessionService(session, sessionHelper);
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

    private static void showMenu() {
        DrinkHelper.printDrinks(DrinkRepository.getAllDrinks());
    }
}