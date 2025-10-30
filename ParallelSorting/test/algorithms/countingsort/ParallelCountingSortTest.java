package algorithms.countingsort;

import algorithms.selectionsort.TestArrayFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParallelCountingSortTest {

    @Test
    void emptyArray() {
        ParallelCountingSort sorter = new ParallelCountingSort();
        int[] array = TestArrayFactory.empty();
        int[] expected = new int[0];
        sorter.sort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    void lengthOneArray() {
        ParallelCountingSort sorter = new ParallelCountingSort();
        int[] array = TestArrayFactory.single();
        int[] expected = {42};
        sorter.sort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    void lengthTwoArraySorted() {
        ParallelCountingSort sorter = new ParallelCountingSort();
        int[] array = TestArrayFactory.twoSorted();
        int[] expected = {3, 7};
        sorter.sort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    void lengthTwoArrayUnsorted() {
        ParallelCountingSort sorter = new ParallelCountingSort();
        int[] array = TestArrayFactory.twoUnsorted();
        int[] expected = {3, 7};
        sorter.sort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    void longArrayOddLength() {
        ParallelCountingSort sorter = new ParallelCountingSort();
        int[] array = TestArrayFactory.longOddUnsorted();
        int[] expected = TestArrayFactory.sortedCopy(array);
        sorter.sort(array);
        assertArrayEquals(expected, array);
        assertTrue(array.length >= 100 && array.length % 2 == 1);
    }

    @Test
    void longArrayEvenLength() {
        ParallelCountingSort sorter = new ParallelCountingSort();
        int[] array = TestArrayFactory.longEvenUnsorted();
        int[] expected = TestArrayFactory.sortedCopy(array);
        sorter.sort(array);
        assertArrayEquals(expected, array);
        assertTrue(array.length >= 100 && array.length % 2 == 0);
    }

    @Test
    void reversedLongArrayOddLength() {
        ParallelCountingSort sorter = new ParallelCountingSort();
        int[] array = TestArrayFactory.longOddReversed();
        int[] expected = TestArrayFactory.sortedCopy(array);
        sorter.sort(array);
        assertArrayEquals(expected, array);
        assertTrue(array.length >= 100 && array.length % 2 == 1);
    }

    @Test
    void sortedLongArrayEvenLength() {
        ParallelCountingSort sorter = new ParallelCountingSort();
        int[] array = TestArrayFactory.longEvenSorted();
        int[] expected = TestArrayFactory.sortedCopy(array);
        sorter.sort(array);
        assertArrayEquals(expected, array);
        assertTrue(array.length >= 100 && array.length % 2 == 0);
    }

    @Test
    void sortedLongArrayOddLength() {
        ParallelCountingSort sorter = new ParallelCountingSort();
        int[] array = TestArrayFactory.longOddSorted();
        int[] expected = TestArrayFactory.sortedCopy(array);
        sorter.sort(array);
        assertArrayEquals(expected, array);
        assertTrue(array.length >= 100 && array.length % 2 == 1);
    }
}
