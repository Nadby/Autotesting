package ru.cbr.test.lesson2.exceptions;

public class DrinkNotFoundException extends ObjectNotFoundException {
    public DrinkNotFoundException(String message) {
        super(message);
    }
}
