/*
 * n = rows, m = columns
 * Time Complexity = O(n^2)
 * Space Complexity = O(1) 
 */
package FindPeak;

/**
 *
 * @author Ali Tahir
 */
public class GreedyAscent {

    public static void main(String[] args) {

        int[][] arr = {{10, 8, 10, 10, 11},
        {14, 13, 12, 11, 21},
        {15, 9, 11, 8, 17},
        {16, 9, 9, 15, 18}};

        int n = 4; // rows
        int m = 5; // columns

        Tuple t = greedyAscent(arr, n / 2, m / 2);

        System.out.println("Peak found at index: " + "(" + t.rowIndex + "," + t.colIndex + ")");
        System.out.println("Peak Value: " + arr[t.rowIndex][t.colIndex]);

    }

    // arr.length = no. of rows , arr[0].length = no. of columns
    public static Tuple greedyAscent(int[][] arr, int row, int col) {

        if (row > 0 && arr[row - 1][col] > arr[row][col]) {
            return greedyAscent(arr, row - 1, col);
        } else if (row < arr.length - 1 && arr[row + 1][col] > arr[row][col]) {
            return greedyAscent(arr, row + 1, col);
        } else if (col > 0 && arr[row][col - 1] > arr[row][col]) {
            return greedyAscent(arr, row, col - 1);
        } else if (col < arr[0].length - 1 && arr[row][col + 1] > arr[row][col]) {
            return greedyAscent(arr, row, col + 1);
        }

        return new Tuple(row, col);

    }
}
