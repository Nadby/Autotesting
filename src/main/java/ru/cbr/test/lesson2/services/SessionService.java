package ru.cbr.test.lesson2.services;

import ru.cbr.test.lesson2.exceptions.NotEnoughBalanceException;
import ru.cbr.test.lesson2.helpers.SessionHelper;
import ru.cbr.test.lesson2.session.Session;

public class SessionService implements ISessionService {
    private final Session session;
    private final SessionHelper sessionHelper;
    public SessionService(Session session, SessionHelper sessionHelper) {
        this.session = session;
        this.sessionHelper = sessionHelper;
    }

    /**
     * {@inheritDoc}
     */
    public boolean process() throws NotEnoughBalanceException {
        if (sessionHelper.checkPurchasePossibility()) {
            return session.changeBalance(-1 * sessionHelper.getPriceOfSelectedDrink());
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
}
