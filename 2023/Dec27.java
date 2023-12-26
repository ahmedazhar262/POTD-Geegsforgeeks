// Anti Diagonal Traversal of Matrix

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static int[] antiDiagonalPattern(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int n = matrix.length;

        for (int i = 0; i < 2 * n - 1; i++) {
            int startRow = (i < n) ? 0 : i - n + 1;
            int startCol = (i < n) ? i : n - 1;

            while (startRow < n && startCol >= 0) {
                result.add(matrix[startRow][startCol]);
                startRow++;
                startCol--;
            }
        }

        int[] resultArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }

        return resultArray;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        int[] result = antiDiagonalPattern(matrix);

        System.out.print("Anti-Diagonal Pattern: ");
        for (int value : result) {
            System.out.print(value + " ");
        }
    }
}
