// Anti Diagonal Traversal of Matrix

class Solution
{
    public int[] antiDiagonalPattern(int[][] matrix)
    {
        // Code here
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
}
