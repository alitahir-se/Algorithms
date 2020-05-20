/*
 * Time Complexity = O(nlog m)
 * Space Complexity = O(n) //out of place  
 * Recurence Relation: 2T(n/2) + cn 
 */
package Sort;

/**
 *
 * @author Ali Tahir
 */
public class MergeSort {

    public static void main(String[] args) {

        int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        mergeSort(arr, 0, arr.length - 1);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();

    }

    public static void mergeSort(int[] arr, int start, int end) {

        if (start < end) {

            int mid = (start + end) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, end, mid);

        }
    }

    public static void merge(int[] arr, int start, int end, int mid) {

        int leftSize = mid - start + 1;
        int rightSize = end - mid;
        int left[] = new int[leftSize];
        int right[] = new int[rightSize];

        for (int i = 0; i < leftSize; i++) {
            left[i] = arr[start + i];
        }

        for (int j = 0; j < rightSize; j++) {
            right[j] = arr[mid + j + 1];
        }

        int i = 0, j = 0, k = start;

        while (i < leftSize && j < rightSize) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }

        }

        while (i < leftSize) {
            arr[k++] = left[i++];
        }

        while (j < rightSize) {
            arr[k++] = right[j++];
        }

    }

}
