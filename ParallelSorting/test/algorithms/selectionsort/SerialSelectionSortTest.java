package algorithms.selectionsort;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SerialSelectionSortTest {

    @Test
    void emptyArray() {
        SerialSelectionSort sorter = new SerialSelectionSort();
        int[] array = TestArrayFactory.empty();
        int[] expected = new int[0];
        sorter.sort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    void lengthOneArray() {
        SerialSelectionSort sorter = new SerialSelectionSort();
        int[] array = TestArrayFactory.single();
        int[] expected = {42};
        sorter.sort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    void lengthTwoArraySorted() {
        SerialSelectionSort sorter = new SerialSelectionSort();
        int[] array = TestArrayFactory.twoSorted();
        int[] expected = {3, 7};
        sorter.sort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    void lengthTwoArrayUnsorted() {
        SerialSelectionSort sorter = new SerialSelectionSort();
        int[] array = TestArrayFactory.twoUnsorted();
        int[] expected = {3, 7};
        sorter.sort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    void longArrayOddLength() {
        SerialSelectionSort sorter = new SerialSelectionSort();
        int[] array = TestArrayFactory.longOddUnsorted();
        int[] expected = TestArrayFactory.sortedCopy(array);
        sorter.sort(array);
        assertArrayEquals(expected, array);
        assertTrue(array.length >= 100 && array.length % 2 == 1);
    }

    @Test
    void longArrayEvenLength() {
        SerialSelectionSort sorter = new SerialSelectionSort();
        int[] array = TestArrayFactory.longEvenUnsorted();
        int[] expected = TestArrayFactory.sortedCopy(array);
        sorter.sort(array);
        assertArrayEquals(expected, array);
        assertTrue(array.length >= 100 && array.length % 2 == 0);
    }

    @Test
    void reversedLongArrayOddLength() {
        SerialSelectionSort sorter = new SerialSelectionSort();
        int[] array = TestArrayFactory.longOddReversed();
        int[] expected = TestArrayFactory.sortedCopy(array);
        sorter.sort(array);
        assertArrayEquals(expected, array);
        assertTrue(array.length >= 100 && array.length % 2 == 1);
    }

    @Test
    void sortedLongArrayEvenLength() {
        SerialSelectionSort sorter = new SerialSelectionSort();
        int[] array = TestArrayFactory.longEvenSorted();
        int[] expected = TestArrayFactory.sortedCopy(array);
        sorter.sort(array);
        assertArrayEquals(expected, array);
        assertTrue(array.length >= 100 && array.length % 2 == 0);
    }

    @Test
     void sortedLongArrayOddLength() {
        SerialSelectionSort sorter = new SerialSelectionSort();
        int[] array = TestArrayFactory.longOddSorted();
        int[] expected = TestArrayFactory.sortedCopy(array);
        sorter.sort(array);
        assertArrayEquals(expected, array);
        assertTrue(array.length >= 100 && array.length % 2 == 1);
    }
}