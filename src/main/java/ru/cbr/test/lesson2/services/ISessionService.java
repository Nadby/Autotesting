package ru.cbr.test.lesson2.services;

import ru.cbr.test.lesson2.exceptions.NotEnoughBalanceException;

public interface ISessionService {
    /**
     * Непосредственная покупка напитка
     * @return успешность покупки напитка
     * @throws NotEnoughBalanceException
     */
    boolean process () throws NotEnoughBalanceException;

    /**
     * Пополнение баланса
     * @param sum сумма пополнения баланса
     */
    void topUpBalance(int sum);
}
