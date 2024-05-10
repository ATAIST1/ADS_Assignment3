package org.example;
import java.sql.SQLOutput;
import java.util.Random;

public class Main {
    public static void mergeSort(int[] array) {
        if (array.length <= 1) {
            return;
        }

        int mid = array.length / 2;
        int[] leftArray = new int[mid];
        int[] rightArray = new int[array.length - mid];
        System.arraycopy(array, 0, leftArray, 0, mid);
        System.arraycopy(array, mid, rightArray, 0, array.length - mid);
        mergeSort(leftArray);
        mergeSort(rightArray);
        merge(array, leftArray, rightArray);
    }

    private static void merge(int[] array, int[] leftArray, int[] rightArray) {
        int leftIndex = 0, rightIndex = 0, arrayIndex = 0;

        while (leftIndex < leftArray.length && rightIndex < rightArray.length) {
            if (leftArray[leftIndex] <= rightArray[rightIndex]) {
                array[arrayIndex++] = leftArray[leftIndex++];
            } else {
                array[arrayIndex++] = rightArray[rightIndex++];
            }
        }
        while (leftIndex < leftArray.length) {
            array[arrayIndex++] = leftArray[leftIndex++];
        }
        while (rightIndex < rightArray.length) {
            array[arrayIndex++] = rightArray[rightIndex++];
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
    public static void main(String[] args) {

        int[] array1000 = generateRandomArray(1000);
        int[] array5000 = generateRandomArray(5000);
        int[] array10000 = generateRandomArray(10000);
        mergeSort(array5000);
        int[] sorted = array5000;
        long start = System.nanoTime();
        mergeSort(sorted);
        printArr(sorted);
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