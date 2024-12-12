package ru.cbr.test.lesson3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program2 {
    private static final int MIN_RANDOM_INT = 1;
    private static final int MAX_RANDOM_INT = 10;

    public static void main(String[] args) {

        System.out.println("Программа: вычисление суммы диагоналей массива.");
        int n = 0;
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Введите число N - размер двумерного квадратного массива: ");
            n = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Введенная строка не может быть преобразована в число!");
            System.exit(1);
        }
        int[][] a = new int[n][n];
        fillMatrix(a);
        printMatrix(a);
        System.out.printf("Сумма диагоналей двумерного массива -> %s", calcMatrixDiagonalsSum(a));
    }

    private static void printMatrix(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                System.out.printf("%5d\t", a[i][j]);
            }
            System.out.println();
        }
    }

    private static int calcMatrixDiagonalsSum(int[][] a) {
        int sum = 0;
        int n = a.length;
        for (int i = 0; i < n; i++) {
            sum += a[i][i] + a[n - 1 - i][i];
        }
        return sum;
    }

    private static void fillMatrix(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = (int) (Math.random() * (MAX_RANDOM_INT - MIN_RANDOM_INT) + 1);
            }
        }
    }

    ;
}
