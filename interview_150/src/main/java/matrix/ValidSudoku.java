package matrix;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    // https://leetcode.com/problems/valid-sudoku/description
    public static void main(String[] args) {
        char[][] matrix = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        System.out.println(isValidSukoduV1(matrix));
    }

    private static boolean isValidSukoduV1(char[][] matrix) {
        // Row Identification : i
        // Column Identification : j
        // Box Identification : i/3, j/3
        Set<String> seen = new HashSet<>();
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++) {
                char number = matrix[i][j];
                if (number != '.') {
                    // The HashSet.add() function returns a boolean result, true if added successfully and false otherwise.
                    // As such, we can just use this boolean return from add() to check if we successfully added.
                    // If any of the 3 (row, column and box) is not added successfully,
                    // then 'board' is not a valid sudoku board.
                    // 1. Store the number in the row.
                    // 2. Store the number in the column.
                    // 3. Store the number in the box.
                    // (Make sure to separate row and column information with a delimiter).
                    if (!seen.add(number + "Row" + i) ||
                            !seen.add(number + "Column" + j) ||
                            !seen.add(number + "Box" + i / 3 + "-" + j / 3))
                        return false;
                }
            }

        return true;
    }
}
