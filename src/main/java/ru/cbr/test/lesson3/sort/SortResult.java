package ru.cbr.test.lesson3.sort;

public class SortResult {
    /**
     * время, затраченное на сортировку, наносекунд
     */
    private final long time;
    /**
     * количество проходов по циклам
     */
    private final int loopCount;
    /**
     * количество перестановок в процессе сортировки
     */
    private final int moveCount;

    public SortResult(long time, int loopCount, int moveCount) {
        this.time = time;
        this.loopCount = loopCount;
        this.moveCount = moveCount;
    }

    public long getTime() {
        return time;
    }

    public int getLoopCount() {
        return loopCount;
    }

    public int getMoveCount() {
        return moveCount;
    }
}
