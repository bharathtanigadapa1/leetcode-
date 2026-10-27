class Solution {
    public String[] createGrid(int m, int n) {
        String[] result = new String[m];

        // Row 0 is completely free (all '.')
        StringBuilder firstRow = new StringBuilder();
        for (int j = 0; j < n; j++) {
            firstRow.append('.');
        }
        result[0] = firstRow.toString();

        // Remaining rows are all obstacles ('#') except the last column ('.')
        StringBuilder remainingRow = new StringBuilder();
        for (int j = 0; j < n - 1; j++) {
            remainingRow.append('#');
        }
        remainingRow.append('.');
        
        String otherRows = remainingRow.toString();
        for (int i = 1; i < m; i++) {
            result[i] = otherRows;
        }

        return result;
    }
}