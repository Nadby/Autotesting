package ru.cbr.test;

public class Lesson1Part3 {
    public static void main(String[] args) {

        System.out.println("Программа: таблица умножения.");
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                System.out.printf("%3d", j*i);
            }
            System.out.println();
        }
    }
}
