package ru.cbr.test;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Lesson1Part2 {
    public static void main(String[] args) {

        System.out.println("Программа, описывающая введенное число.");

        double d = 0;
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Введите число: ");
            d = sc.nextDouble();
        }
        catch (InputMismatchException e) {
            System.out.println("Введенная строка не может быть преобразована в число!");
            System.exit(1);
        }
        System.out.println("Введенное число: " + getNumberSignDesc(d) + ", " + getEvenSignDesc(d));
    }

    private static String getNumberSignDesc(double d) {
        String desc;
        switch ((int)Math.signum(d)) {
            case -1: desc = "отрицательное"; break;
            case 1: desc = "положительное"; break;
            default: desc = "нулевое";
        }
        return desc;
    }

    private static String getEvenSignDesc(double d) {
        String desc;
        if (d%2 == 0) {
            desc = "четное";
        }
        else {
            desc = "нечетное";
        }
        return desc;
    }

}
