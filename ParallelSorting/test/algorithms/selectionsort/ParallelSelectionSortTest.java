package algorithms.selectionsort;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ParallelSelectionSortTest {

    @Test
    void emptyArray() {
        ParallelSelectionSort sorter = new ParallelSelectionSort();
        int[] array = TestArrayFactory.empty();
        int[] expected = new int[0];
        sorter.sort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    void lengthOneArray() {
        ParallelSelectionSort sorter = new ParallelSelectionSort();
        int[] array = TestArrayFactory.single();
        int[] expected = {42};
        sorter.sort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    void lengthTwoArraySorted() {
        ParallelSelectionSort sorter = new ParallelSelectionSort();
        int[] array = TestArrayFactory.twoSorted();
        int[] expected = {3, 7};
        sorter.sort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    void lengthTwoArrayUnsorted() {
        ParallelSelectionSort sorter = new ParallelSelectionSort();
        int[] array = TestArrayFactory.twoUnsorted();
        int[] expected = {3, 7};
        sorter.sort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    void longArrayOddLength() {
        ParallelSelectionSort sorter = new ParallelSelectionSort();
        int[] array = TestArrayFactory.longOddUnsorted();
        int[] expected = TestArrayFactory.sortedCopy(array);
        sorter.sort(array);
        assertArrayEquals(expected, array);
        assertTrue(array.length >= 100 && array.length % 2 == 1);
    }

    @Test
    void longArrayEvenLength() {
        ParallelSelectionSort sorter = new ParallelSelectionSort();
        int[] array = TestArrayFactory.longEvenUnsorted();
        int[] expected = TestArrayFactory.sortedCopy(array);
        sorter.sort(array);
        assertArrayEquals(expected, array);
        assertTrue(array.length >= 100 && array.length % 2 == 0);
    }

    @Test
    void reversedLongArrayOddLength() {
        ParallelSelectionSort sorter = new ParallelSelectionSort();
        int[] array = TestArrayFactory.longOddReversed();
        int[] expected = TestArrayFactory.sortedCopy(array);
        sorter.sort(array);
        assertArrayEquals(expected, array);
        assertTrue(array.length >= 100 && array.length % 2 == 1);
    }

    @Test
    void sortedLongArrayEvenLength() {
        ParallelSelectionSort sorter = new ParallelSelectionSort();
        int[] array = TestArrayFactory.longEvenSorted();
        int[] expected = TestArrayFactory.sortedCopy(array);
        sorter.sort(array);
        assertArrayEquals(expected, array);
        assertTrue(array.length >= 100 && array.length % 2 == 0);
    }

    @Test
    void sortedLongArrayOddLength() {
        ParallelSelectionSort sorter = new ParallelSelectionSort();
        int[] array = TestArrayFactory.longOddSorted();
        int[] expected = TestArrayFactory.sortedCopy(array);
        sorter.sort(array);
        assertArrayEquals(expected, array);
        assertTrue(array.length >= 100 && array.length % 2 == 1);
    }
}