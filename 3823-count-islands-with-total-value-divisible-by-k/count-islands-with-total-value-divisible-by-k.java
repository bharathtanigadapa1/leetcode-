class Solution {
    public int countIslands(int[][] grid, int k) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] > 0) {
                    long totalSum = dfs(grid, r, c, rows, cols);
                    if (totalSum % k == 0) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    private long dfs(int[][] grid, int r, int c, int rows, int cols) {
        // Base bounds and land check
        if (r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] == 0) {
            return 0;
        }

        // Add current cell value and mark as visited by setting to 0
        long sum = grid[r][c];
        grid[r][c] = 0;

        // Traverse 4-directionally
        sum += dfs(grid, r + 1, c, rows, cols);
        sum += dfs(grid, r - 1, c, rows, cols);
        sum += dfs(grid, r, c + 1, rows, cols);
        sum += dfs(grid, r, c - 1, rows, cols);

        return sum;
    }
}