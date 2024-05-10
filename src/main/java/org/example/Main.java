package org.example;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void insertionSort(int[] array) {
        int n = array.length;
        for (int i = 1; i < n; ++i) {
            int key = array [i];
            int j =   i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array [j];
                j--;
            }
            array [j + 1] = key;
        }
    }
    public static void main(String[] args) {
        int[] array = {12, 11, 13, 5, 6, 7};

        insertionSort(array);
        printArr(array);
    }
    public static void printArr(int[] arr)
    {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}