package ru.cbr.test.lesson3.sort;

import java.util.Arrays;

public class SortHelper {
    /**
     * Реализация пузырьковой сортировки
     *
     * @param array целочесленный массив для сортировки
     * @return показатели - затраченное время (нс), количество проходов по циклам, количество перемещений
     */
    public static SortResult sortBubble(int[] array) {

        long time = System.nanoTime();
        int i;
        int n;
        int temp;
        int moveCount = 0, loopCount = 0, m = 0;

        n = array.length - 1;
        while (n > 0) {
            for (i = 0; i < n; i++) {
                loopCount++;
                if (array[i] > array[i + 1]) {
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    moveCount++;
                    m = i + 1;
                }
            }
            n = --m;
        }
        return new SortResult(System.nanoTime() - time, loopCount, moveCount);
    }

    /**
     * Реализация сортировки методом побитного сравнения
     *
     * @param array целочесленный массив для сортировки
     * @return показатели - затраченное время (нс), количество проходов по циклам, количество перемещений
     */
    public static SortResult sortBitsMethod(int[] array) {

        long time = System.nanoTime();
        int size = array.length;
        int i = 0, bit = 0;
        int moveCount = 0, loopCount = 0;
        int m = array[0];
        int[] b = new int[array.length];

        for (i = 1; i < size; i++) {
            if (array[i] > m) {
                m = array[i];
            }
            loopCount++;
        }
        while (m >> bit > 0) {
            int[] bucket = new int[2];
            for (i = 0; i < size; i++) {
                bucket[(array[i] >> bit) & 1]++;
                loopCount++;
            }
            bucket[1] += bucket[0];
            for (i = size - 1; i >= 0; i--) {
                int p = (array[i] >> bit) & 1;
                b[bucket[p] - 1] = array[i];
                bucket[p]--;
                loopCount++;
            }
            for (i = 0; i < size; i++) {
                array[i] = b[i];
                moveCount++;
                loopCount++;
            }
            bit++;
        }
        return new SortResult(System.nanoTime() - time, loopCount, moveCount);
    }

    /**
     * Классическая сортировки Java - обертка
     *
     * @param array целочесленный массив для сортировки
     * @return показатели - затраченное время (нс), количество проходов по циклам = -1, количество перемещений = -1
     */
    public static SortResult sortJava(int[] array) {
        long time = System.nanoTime();
        Arrays.sort(array);
        return new SortResult(System.nanoTime() - time, -1, -1);
    }
}
