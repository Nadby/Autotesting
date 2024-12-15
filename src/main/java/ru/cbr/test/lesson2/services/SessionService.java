package ru.cbr.test.lesson2.services;

import ru.cbr.test.lesson2.exceptions.DrinkNotFoundException;
import ru.cbr.test.lesson2.exceptions.NotEnoughBalanceException;
import ru.cbr.test.lesson2.repositories.DrinkRepository;
import ru.cbr.test.lesson2.session.Session;

public class SessionService implements ISessionService {
    private final Session session;
    public SessionService(int drinkId) {
        this.session = new Session(drinkId);
    }

    /**
     * {@inheritDoc}
     */
    public boolean process() throws NotEnoughBalanceException {
        if (checkPurchasePossibility()) {
            return session.changeBalance(-1 * getPriceOfSelectedDrink());
        } else {
            throw new NotEnoughBalanceException("недостаточно средств");
        }
    }
    /**
     * {@inheritDoc}
     */
    public void topUpBalance(int sum) {
       session.changeBalance(sum);
    }

    /**
     * {@inheritDoc}
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
     * {@inheritDoc}
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
    /**
     * {@inheritDoc}
     */
    public void printBalance() {
        System.out.printf("текущий баланс: %5d (руб.)\n", getBalance());
    }
    /**
     * {@inheritDoc}
     */
    public int getBalance() {
        return session.getBalance();
    }
    private boolean checkPurchasePossibility()  {
        return session.getBalance() >= getPriceOfSelectedDrink();
    }
}
