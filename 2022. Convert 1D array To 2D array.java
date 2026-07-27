class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        // It is impossible to form an m x n 2D array if total elements don't match
        if (original.length != m * n) {
            return new int[0][0];
        }

        int[][] result = new int[m][n];

        for (int i = 0; i < original.length; i++) {
            result[i / n][i % n] = original[i];
        }

        return result;
    }
}
