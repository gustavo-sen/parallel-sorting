package algorithms.countingsort;

import algorithms.selectionsort.TestArrayFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SerialCountingSortTest {

    @Test
    void emptyArray() {
        SerialCountingSort sorter = new SerialCountingSort();
        int[] array = TestArrayFactory.empty();
        int[] expected = new int[0];
        sorter.sort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    void lengthOneArray() {
        SerialCountingSort sorter = new SerialCountingSort();
        int[] array = TestArrayFactory.single();
        int[] expected = {42};
        sorter.sort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    void lengthTwoArraySorted() {
        SerialCountingSort sorter = new SerialCountingSort();
        int[] array = TestArrayFactory.twoSorted();
        int[] expected = {3, 7};
        sorter.sort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    void lengthTwoArrayUnsorted() {
        SerialCountingSort sorter = new SerialCountingSort();
        int[] array = TestArrayFactory.twoUnsorted();
        int[] expected = {3, 7};
        sorter.sort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    void longArrayOddLength() {
        SerialCountingSort sorter = new SerialCountingSort();
        int[] array = TestArrayFactory.longOddUnsorted();
        int[] expected = TestArrayFactory.sortedCopy(array);
        sorter.sort(array);
        assertArrayEquals(expected, array);
        assertTrue(array.length >= 100 && array.length % 2 == 1);
    }

    @Test
    void longArrayEvenLength() {
        SerialCountingSort sorter = new SerialCountingSort();
        int[] array = TestArrayFactory.longEvenUnsorted();
        int[] expected = TestArrayFactory.sortedCopy(array);
        sorter.sort(array);
        assertArrayEquals(expected, array);
        assertTrue(array.length >= 100 && array.length % 2 == 0);
    }

    @Test
    void reversedLongArrayOddLength() {
        SerialCountingSort sorter = new SerialCountingSort();
        int[] array = TestArrayFactory.longOddReversed();
        int[] expected = TestArrayFactory.sortedCopy(array);
        sorter.sort(array);
        assertArrayEquals(expected, array);
        assertTrue(array.length >= 100 && array.length % 2 == 1);
    }

    @Test
    void sortedLongArrayEvenLength() {
        SerialCountingSort sorter = new SerialCountingSort();
        int[] array = TestArrayFactory.longEvenSorted();
        int[] expected = TestArrayFactory.sortedCopy(array);
        sorter.sort(array);
        assertArrayEquals(expected, array);
        assertTrue(array.length >= 100 && array.length % 2 == 0);
    }

    @Test
    void sortedLongArrayOddLength() {
        SerialCountingSort sorter = new SerialCountingSort();
        int[] array = TestArrayFactory.longOddSorted();
        int[] expected = TestArrayFactory.sortedCopy(array);
        sorter.sort(array);
        assertArrayEquals(expected, array);
        assertTrue(array.length >= 100 && array.length % 2 == 1);
    }
}
