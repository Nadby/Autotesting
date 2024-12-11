package ru.cbr.test;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Lesson1Part4 {
    public static void main(String[] args) {

        System.out.println("Программа вывода прогрессии чисел.");
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Выберите тип прогрессии: \n1. Арифметическая.\n2. Геометрическая.");
            byte type = sc.nextByte();
            System.out.println("Введите количество выводимых членов прогрессии:");
            int n = sc.nextInt();
            if (type == 1) {
                System.out.println("Введите первый элемент: ");
                int a1 = sc.nextInt();
                System.out.println("Введите разность: ");
                int d = sc.nextInt();
                int[] arr = getAlgProgress(a1, d, n);
                System.out.println(Arrays.toString(arr));
            }
            else if (type == 2) {
                System.out.println("Введите первый элемент: ");
                int b1 = sc.nextInt();
                System.out.println("Введите знаменатель: ");
                int q = sc.nextInt();
                int[] arr = getGeoProgress(b1, q, n);
                System.out.println(Arrays.toString(arr));
            }
            else {
                System.out.println("Выбран неверный тип прогрессии.");
                System.exit(2);
            }
        }
        catch (InputMismatchException e) {
            System.out.println("Введенная строка не может быть преобразована в целое число!");
            System.exit(1);
        }
    }

    private static int[] getAlgProgress(int a1, int d, int n) {
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = a1 + i * d;
        }
        return res;
    }
    private static int[] getGeoProgress(int b1, int q, int n) {
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = b1 * (int)Math.pow(q, i);
        }
        return res;
    }

}
