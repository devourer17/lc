package matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    // https://leetcode.com/problems/spiral-matrix/description
    public static void main(String[] args) {
        int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        viewSpiralMatrixV1(matrix1).stream().forEach(System.out::print);
        System.out.println();
        int[][] matrix2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        viewSpiralMatrixV2(matrix2).stream().forEach(System.out::print);
    }

    private static List<Integer> viewSpiralMatrixV2(int[][] matrix) {
        List<Integer> results = new ArrayList<>();
        int rows = matrix.length, columns = matrix[0].length;
        int top = 0, bottom = rows - 1, left = 0, right = columns - 1;
        while (true) {
            //Move Right
            for (int i = left; i <= right; i++)
                results.add(matrix[top][i]);
            top++;
            if (top > bottom) break;

            //Move Down
            for (int i = top; i <= bottom; i++)
                results.add(matrix[i][right]);
            right--;
            if (left > right) break;

            //Move Left
            for (int i = right; i >= left; i--)
                results.add(matrix[bottom][i]);
            bottom--;
            if (top > bottom) break;

            //Move Up
            for (int i = bottom; i >= top; i--)
                results.add(matrix[i][left]);
            left++;
            if (left > right) break;

        }
        return results;
    }

    private static List<Integer> viewSpiralMatrixV1(int[][] matrix) {
        List<Integer> results = new ArrayList<>();
        int row = 0, col = 0, direction = 1, totalElements = matrix.length * matrix[0].length;
        //Right - 01, Left - 10
        //Top - 00, Bottom - 11
        List<Integer> rs = addNumbers(results, matrix, row, col, direction, totalElements);
        return results;
    }

    private static List<Integer> addNumbers(List<Integer> results, int[][] matrix, int row, int col, int direction, int totalElements) {
        if (results.size() < totalElements) {
            if (direction == 1) {
                int currentColumn = col;
                for (int i = currentColumn; i < matrix[row].length; i++) {
                    if (matrix[row][i] != Integer.MIN_VALUE) {
                        results.add(matrix[row][i]);
                        matrix[row][i] = Integer.MIN_VALUE;
                        col = i;
                    }
                }
                return addNumbers(results, matrix, row++, col, 11, totalElements);
            } else if (direction == 11) {
                int currentRow = row;
                for (int i = currentRow; i < matrix.length; i++) {
                    if (matrix[i][col] != Integer.MIN_VALUE) {
                        results.add(matrix[i][col]);
                        matrix[i][col] = Integer.MIN_VALUE;
                        row = i;
                    }
                }
                return addNumbers(results, matrix, row, col--, 10, totalElements);
            } else if (direction == 10) {
                int currentColumn = col;
                for (int i = currentColumn; i >= 0; i--) {
                    if (matrix[row][i] != Integer.MIN_VALUE) {
                        results.add(matrix[row][i]);
                        matrix[row][i] = Integer.MIN_VALUE;
                        col = i;
                    }
                }
                return addNumbers(results, matrix, row--, col, 0, totalElements);
            } else if (direction == 0) {
                int currentRow = row;
                for (int i = currentRow; i >= 0; i--) {
                    if (matrix[i][col] != Integer.MIN_VALUE) {
                        results.add(matrix[i][col]);
                        matrix[i][col] = Integer.MIN_VALUE;
                        row = i;
                    }
                }
                return addNumbers(results, matrix, row, col--, 1, totalElements);
            }
        }
        return results;
    }
}
