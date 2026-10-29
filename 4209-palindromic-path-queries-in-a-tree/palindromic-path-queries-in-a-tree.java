import java.util.*;

class Solution {
    private int n;
    private List<Integer>[] adj;
    private int[] in, out;
    private int timer = 0;
    private int[][] up;
    private int[] depth;
    private int maxLog;
    private int[] nodeMask;
    private int[] bit; // Fenwick tree for subtree updates

    private void addBit(int idx, int val) {
        for (; idx <= n; idx += idx & -idx) {
            bit[idx] ^= val;
        }
    }

    private void updateRange(int l, int r, int val) {
        addBit(l, val);
        addBit(r + 1, val);
    }

    private int queryBit(int idx) {
        int res = 0;
        for (; idx > 0; idx -= idx & -idx) {
            res ^= bit[idx];
        }
        return res;
    }

    private void dfs(int u, int p, int d) {
        timer++;
        in[u] = timer;
        depth[u] = d;
        up[u][0] = p;

        for (int i = 1; i < maxLog; i++) {
            up[u][i] = up[up[u][i - 1]][i - 1];
        }

        for (int v : adj[u]) {
            if (v != p) {
                dfs(v, u, d + 1);
            }
        }
        out[u] = timer;
    }

    private int getLca(int u, int v) {
        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        for (int i = maxLog - 1; i >= 0; i--) {
            if (depth[u] - (1 << i) >= depth[v]) {
                u = up[u][i];
            }
        }

        if (u == v) return u;

        for (int i = maxLog - 1; i >= 0; i--) {
            if (up[u][i] != up[v][i]) {
                u = up[u][i];
                v = up[v][i];
            }
        }

        return up[u][0];
    }

    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
        this.n = n;
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        maxLog = 32 - Integer.numberOfLeadingZeros(n);
        up = new int[n][maxLog];
        depth = new int[n];
        in = new int[n];
        out = new int[n];
        bit = new int[n + 2];
        nodeMask = new int[n];

        dfs(0, 0, 0);

        for (int i = 0; i < n; i++) {
            int mask = 1 << (s.charAt(i) - 'a');
            nodeMask[i] = mask;
            updateRange(in[i], out[i], mask);
        }

        List<Boolean> result = new ArrayList<>();

        for (String q : queries) {
            String[] parts = q.split(" ");
            if (parts[0].equals("update")) {
                int u = Integer.parseInt(parts[1]);
                char newChar = parts[2].charAt(0);
                int oldMask = nodeMask[u];
                int newMask = 1 << (newChar - 'a');
                int diff = oldMask ^ newMask;

                nodeMask[u] = newMask;
                updateRange(in[u], out[u], diff);
            } else {
                int u = Integer.parseInt(parts[1]);
                int v = Integer.parseInt(parts[2]);

                int lca = getLca(u, v);
                int pathXor = queryBit(in[u]) ^ queryBit(in[v]) ^ nodeMask[lca];

                // Check if pathXor has at most one bit set
                boolean isPalindrome = (pathXor == 0) || ((pathXor & (pathXor - 1)) == 0);
                result.add(isPalindrome);
            }
        }

        return result;
    }
}