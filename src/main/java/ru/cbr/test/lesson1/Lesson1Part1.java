package ru.cbr.test.lesson1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Lesson1Part1 {
    public static void main(String[] args) {

        System.out.println("Программа поиска минимального числа.");

        double d1 = 0, d2 = 0;
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Введите первое число: ");
            d1 = sc.nextDouble();
            System.out.println("Введите второе число: ");
            d2 = sc.nextDouble();
        }
        catch (InputMismatchException e) {
            System.out.println("Введенная строка не может быть преобразована в число!");
            System.exit(1);
        }
        System.out.println("Минимальное число: " + Math.min(d1, d2));
    }
}