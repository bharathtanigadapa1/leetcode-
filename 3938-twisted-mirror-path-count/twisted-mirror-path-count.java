class Solution {
    private static final int MOD = 1_000_000_007;

    public int uniquePaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][][] go = new int[m][n][2];

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                for (int dir = 0; dir < 2; dir++) {
                    go[r][c][dir] = computeTarget(grid, m, n, r, c, dir);
                }
            }
        }

        int[][] dp = new int[m][n];
        dp[0][0] = 1;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (dp[r][c] == 0) continue;

                for (int dir = 0; dir < 2; dir++) {
                    int target = go[r][c][dir];
                    if (target != -1) {
                        int nr = target / n;
                        int nc = target % n;
                        dp[nr][nc] = (dp[nr][nc] + dp[r][c]) % MOD;
                    }
                }
            }
        }

        return dp[m - 1][n - 1];
    }

    private int computeTarget(int[][] grid, int m, int n, int r, int c, int dir) {
        int currR = r;
        int currC = c;
        int currDir = dir;

        while (true) {
            int nr = currR + (currDir == 1 ? 1 : 0);
            int nc = currC + (currDir == 0 ? 1 : 0);

            if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                return -1;
            }

            if (grid[nr][nc] == 0) {
                return nr * n + nc;
            }

            currR = nr;
            currC = nc;
            currDir = 1 - currDir;
        }
    }
}