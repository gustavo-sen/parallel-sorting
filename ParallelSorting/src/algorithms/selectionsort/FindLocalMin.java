package algorithms.selectionsort;

import java.lang.Math;

public class FindLocalMin implements Runnable {
    int[] array;
    int start;
    int end;
    int minIndex = -1;
    int minValue = Integer.MAX_VALUE;

    private void validateConfig(int[] array, int start, int end) {
        if (array == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }

        if (start < 0 || start >= array.length) {
            throw new IllegalArgumentException("Start index out of bounds");
        }

        if (end < 0 || end > array.length) {
            throw new IllegalArgumentException("End index out of bounds");
        }
    }
    
    public FindLocalMin(int[] array, int start, int end) {
        validateConfig(array, start, end);

        this.array = array;
        this.start = start;
        this.end = end;
    }
    
    public FindLocalMin() {
        this.array = null;
        this.start = 0;
        this.end = 0;
    }
    
    public void config(int[] array, int start, int end) {
        validateConfig(array, start, end);

        this.array = array;
        this.start = start;
        this.end = end;
    }

    public int getMinIndex() {
        if (this.minIndex == -1) {
            throw new IllegalStateException("Min index not found yet");
        }
        return this.minIndex;
    }

    public int getMinValue() {
        if (this.minValue == Integer.MAX_VALUE) {
            throw new IllegalStateException("Min value not found yet or its out of bounds");
        }
        return this.minValue;
    }
    
    @Override
    public void run() {
        this.minIndex = this.start;
        for (int i = this.start; i <= this.end; i++) {
            if (this.array[i] < this.array[this.minIndex]) {
                this.minIndex = i;
                this.minValue = this.array[i];
            }
        }
    }
}
