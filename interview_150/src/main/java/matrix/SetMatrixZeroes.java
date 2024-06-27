package matrix;

import java.util.Arrays;

public class SetMatrixZeroes {

    // https://leetcode.com/problems/set-matrix-zeroes/description
    public static void main(String[] args) {
        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        //setMatrixZerosV1(matrix);
        setMatrixZerosV2(matrix);
    }

    // Time - O(mn), Space - O(m+n)
    // https://leetcode.com/problems/set-matrix-zeroes/solutions/2525398/all-approaches-from-brute-force-to-optimal-with-easy-explanation
    private static void setMatrixZerosV1(int[][] matrix) {
        viewMatrix(matrix);
        System.out.println();
        int n = matrix[0].length, m = matrix.length;
        int[] rows = new int[m], cols = new int[n];
        Arrays.fill(rows, 1);
        Arrays.fill(cols, 1);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = 0;
                    cols[j] = 0;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rows[i] == 0 || cols[j] == 0)
                    matrix[i][j] = 0;
            }
        }
        viewMatrix(matrix);
    }

    // Time - O(mn), Space - O(1)
    // https://leetcode.com/problems/set-matrix-zeroes/solutions/2525398/all-approaches-from-brute-force-to-optimal-with-easy-explanation
    private static void setMatrixZerosV2(int[][] matrix) {
        viewMatrix(matrix);
        System.out.println();
        int m = matrix[0].length, n = matrix.length;
        boolean isRow = false, isCol = false;

        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0)
                isCol = true;
        }

        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 0)
                isRow = true;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (isCol) {
            for (int i = 0; i < m; i++)
                matrix[0][i] = 0;
        }

        if (isRow) {
            for (int i = 0; i < n; i++)
                matrix[i][0] = 0;
        }

        viewMatrix(matrix);
    }

    private static void viewMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
