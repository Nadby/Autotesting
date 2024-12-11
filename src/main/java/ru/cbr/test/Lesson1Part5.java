package ru.cbr.test;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Lesson1Part5 {
    public static void main(String[] args) {

        System.out.println("Программа определения високосного года.");
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Введите год");
            int year = sc.nextInt();
            String isLeapYearAsString = getIsLeapYear(year) ? "является високосным" : "не является високосным";
            System.out.println("Введенный год " + isLeapYearAsString);
        }
        catch (InputMismatchException e) {
            System.out.println("Введенная строка не может быть преобразована в целое число!");
            System.exit(1);
        }
    }

    private static boolean getIsLeapYear(int year) {
        return (year % 4 == 0) || (year % 150 == 0);
    }

}
