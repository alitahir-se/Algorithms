/*
 * n = rows, m = columns
 * Time Complexity = O(nlog m)
 * Space Complexity Recursive = O(m/2) // recursive stack is used
 * Recurence Relation: T(n,m/2) + O(n) 
 */
package FindPeak;

/**
 *
 * @author Ali Tahir
 */
public class FindingPeak_2D {

    public static void main(String[] args) {

        int[][] arr = {{10, 8, 10, 10, 11},
        {14, 13, 12, 11, 21},
        {15, 9, 11, 8, 17},
        {16, 9, 9, 15, 18}};

        int n = 4; // rows
        int m = 5; // columns

        Tuple t = findTwoDPeak(arr, n, m, m / 2);

        System.out.println("Peak found at index: " + "(" + t.rowIndex + "," + t.colIndex + ")");
        System.out.println("Peak Value: " + arr[t.rowIndex][t.colIndex]);

    }

    public static int findMax(int[][] arr, int rows, int mid) {
        int maxIndex = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < rows; i++) {
            if (arr[i][mid] > max) {
                max = arr[i][mid];
                maxIndex = i;
            }

        }

        return maxIndex;
    }

    public static Tuple findTwoDPeak(int[][] arr, int rows, int columns, int mid) {

        int maxIndex = findMax(arr, rows, mid);
        int max = arr[maxIndex][mid];

        if (mid == 0 || mid == columns - 1) {
            return new Tuple(maxIndex, mid);
        }

        if (max >= arr[maxIndex][mid - 1] && max >= arr[maxIndex][mid + 1]) {
            return new Tuple(maxIndex, mid);
        }

        if (arr[maxIndex][mid - 1] > max) {
            return findTwoDPeak(arr, rows, columns, mid - (int) Math.ceil((double) mid / 2));
        } else {
            return findTwoDPeak(arr, rows, columns, mid + (int) Math.ceil((double) mid / 2));
        }

    }

}
