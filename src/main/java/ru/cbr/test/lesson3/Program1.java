package ru.cbr.test.lesson3;

import ru.cbr.test.lesson3.sort.SortHelper;
import ru.cbr.test.lesson3.sort.SortResult;

import java.util.Arrays;
import java.util.Locale;

public class Program1 {

    private static final int ARRAY_SIZE = 100;
    private static final int MIN_RANDOM_INT = 1;
    private static final int MAX_RANDOM_INT = 10000;

    public static void main(String[] args) {

        int[] intArray = new int[ARRAY_SIZE];
        int[] intArray2 = new int[ARRAY_SIZE];
        int[] intArray3 = new int[ARRAY_SIZE];

        fillRandomIntArray(intArray);

        System.arraycopy(intArray, 0, intArray2, 0, intArray.length);
        System.arraycopy(intArray, 0, intArray3, 0, intArray.length);

        if (intArray.length <= 100) {
            System.out.println("Исходный массив:\n" + Arrays.toString(intArray));
        }
        //сортировка пузырьком
        SortResult bubbleSortResult = SortHelper.sortBubble(intArray);
        System.out.println("\nСортировка пузырьком:");
        if (intArray.length <= 100) {
            System.out.println(Arrays.toString(intArray));
        }
        System.out.printf(Locale.US,"\tвремя -> %,d нс\n\tколичество проходов по циклам -> %,d\n\tколичество перестановок -> %,d",
                bubbleSortResult.getTime(), bubbleSortResult.getLoopCount(), bubbleSortResult.getMoveCount());

        //сортировка побитным сравнением
        SortResult bitsSortMethodResult = SortHelper.sortBitsMethod(intArray2);
        System.out.println("\n\nСортировка побитным сравнением:");
        if (intArray2.length <= 100) {
            System.out.println(Arrays.toString(intArray2));
        }
        System.out.printf(Locale.US,"\tвремя -> %,d нс\n\tколичество проходов по циклам -> %,d\n\tколичество перестановок -> %,d",
                bitsSortMethodResult.getTime(), bitsSortMethodResult.getLoopCount(), bitsSortMethodResult.getMoveCount());

        //сортировка Java
        SortResult sortJavaResult = SortHelper.sortJava(intArray3);
        System.out.println("\n\nСортировка Java:");
        if (intArray3.length <= 100) {
            System.out.println(Arrays.toString(intArray3));
        }
        System.out.printf(Locale.US,"\tвремя -> %,d нс\n\tколичество проходов по циклам -> %,d\n\tколичество перестановок -> %,d",
                sortJavaResult.getTime(), sortJavaResult.getLoopCount(), sortJavaResult.getMoveCount());

    }
    private static void fillRandomIntArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * (MAX_RANDOM_INT - MIN_RANDOM_INT) + 1);
        }
    }
}