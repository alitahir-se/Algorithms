/*
 * Time Complexity = O(n^2)
 * Space Complexity = O(1) // thus it is in-place sorting
 * Improved Time Complexity for comparison from n^2 to logn
 */
package Sort;

import java.util.Arrays;

/**
 *
 * @author Ali Tahir
 */
public class BinaryInsertionSort {

    public static void main(String[] args) {

        int[] arr = {12, 13, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        binaryInsertionSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();

    }

    public static void binaryInsertionSort(int[] arr) {

        int key, j;
        for (int i = 1; i < arr.length; i++) {
            key = arr[i];

            j = Math.abs(Arrays.binarySearch(arr, 0, i, key) + 1);

            for (int k = i; k > j; k--) {
                arr[k] = arr[k - 1];
            }

            arr[j] = key;

        }

    }
}
