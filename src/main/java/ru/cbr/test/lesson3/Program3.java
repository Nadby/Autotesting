package ru.cbr.test.lesson3;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Program3 {

    public static void main(String[] args) {

        System.out.println("Программа: вывод чисел Фибоначчи");
        int n = 0;
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Введите целое число N, до которого следует вывести числа Фибоначчи: ");
            n = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Введенная строка не может быть преобразована в число!");
            System.exit(1);
        }
        int[] a = new int[n];
        getFibonacciNumbers(a);
        printFibonacciNumbers(a);
    }

    private static void printFibonacciNumbers(int[] a) {
        System.out.println("Числа Фибоначчи: " + Arrays.toString(a));
    }

    private static void getFibonacciNumbers(int[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i] = getFibonacciNumber(i + 1);
        }
    }

    private static int getFibonacciNumber(int n) {
        if (n < 2) {
            return n;
        } else {
            return getFibonacciNumber(n - 1) + getFibonacciNumber(n - 2);
        }
    }
}
