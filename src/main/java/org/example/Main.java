package org.example;
import java.sql.SQLOutput;
import java.util.Random;
import java.util.Arrays;

public class Main {
    public static void heapSort(int[] array) {
        int n = array.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapify(array, i, 0);
        }
    }

    private static void heapify(int[] array, int n, int i) {
        int largest = i;
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;
        if (leftChild < n && array[leftChild] > array[largest]) {
            largest = leftChild;
        }
        if (rightChild < n && array[rightChild] > array[largest]) {
            largest = rightChild;
        }
        if (largest != i) {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;
            heapify(array, n, largest);
        }
    }
    private static int[] generateRandomArray(int size) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(10000); // Adjust the bound as needed
        }
        return array;
    }
    private static int[] generateReverseSortedArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = size - i;
        }
        return array;
    }
    private static int[] generateIdenticalElementsArray(int size, int numIdenticalElements) {
        int[] array = new int[size];
        Arrays.fill(array, 0, numIdenticalElements, 10); // Fill first numIdenticalElements with the same value
        for (int i = numIdenticalElements; i < size; i++) {
            array[i] = i; // Fill the rest of the array with increasing values
        }
        return array;
    }
    public static void main(String[] args) {

        int[] array1000 = generateRandomArray(1000);
        int[] array5000 = generateRandomArray(5000);
        int[] array10000 = generateRandomArray(10000);
        int[] arrayReverse1000 = generateReverseSortedArray(1000);
        int[] arrayReverse5000 = generateReverseSortedArray(5000);
        int[] arrayReverse10000 = generateReverseSortedArray(10000);
        int[] arrayIdentical1000 = generateIdenticalElementsArray(1000, 500);
        int[] arrayIdentical5000 = generateIdenticalElementsArray(5000, 2500);
        int[] arrayIdentical10000 = generateIdenticalElementsArray(10000, 5000);
        long start = System.nanoTime();
        heapSort(arrayIdentical10000);
        printArr(arrayIdentical10000);
        System.out.println();
        long duration = (System.nanoTime() - start) / 1000000;
        System.out.println(duration + "ms");
    }
    public static void printArr(int[] arr)
    {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}