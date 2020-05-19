/*
 * Time Complexity = O(log n)
 * Space Complexity Recursive = O(log n) // recursive stack is used
 * Recurence Relation: T(n/2) + c 
 */
package FindPeak;

/**
 *
 * @author Ali Tahir
 */
public class FindingPeak_1D {

    public static void main(String[] args) {

        int arr[] = {4,3,7,8,12,11};

        int result = findOneDPeak(arr, 0, arr.length - 1);

        System.out.println("Peak found at index: " + result);
        System.out.println("Peak Value: " + arr[result]);

    }

    // start = left and end = right
    public static int findOneDPeak(int[] arr, int start, int end) {

        int mid = (start + end) / 2;

        if ((mid == 0 || arr[mid] > arr[mid - 1]) && (mid == arr.length - 1 || arr[mid] > arr[mid + 1])) {
            return mid;
        }

        if (mid > 0 && arr[mid] < arr[mid - 1]) {
            return findOneDPeak(arr, start, mid - 1);
        } else {
            return findOneDPeak(arr, mid + 1, end);
        }

    }

}
