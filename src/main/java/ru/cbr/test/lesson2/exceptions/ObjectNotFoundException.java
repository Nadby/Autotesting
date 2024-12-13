package ru.cbr.test.lesson2.exceptions;

public class ObjectNotFoundException extends Exception {
    public ObjectNotFoundException() {
    }
    public ObjectNotFoundException(String message) {
        super(message);
    }
}
