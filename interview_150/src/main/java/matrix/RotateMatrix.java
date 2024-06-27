package matrix;

public class RotateMatrix {

    // https://leetcode.com/problems/rotate-image/description/
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotateMatrixV1(matrix);
    }

    // https://leetcode.com/problems/rotate-image/description/comments/1574669
    private static void rotateMatrixV1(int[][] matrix) {
        viewMatrix(matrix);
        int n = matrix.length;
        int temp;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        System.out.println();
        viewMatrix(matrix);
        mirrorMatrix(matrix);
    }

    private static void mirrorMatrix(int[][] matrix) {
        int n = matrix.length;
        int temp;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
        System.out.println();
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
