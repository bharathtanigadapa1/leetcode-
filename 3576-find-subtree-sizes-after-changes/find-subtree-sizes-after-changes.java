class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;

        List<Integer>[] tree = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            tree[parent[i]].add(i);
        }

        int[] newParent = parent.clone();

        List<Integer>[] stacks = new ArrayList[26];
        for (int i = 0; i < 26; i++) {
            stacks[i] = new ArrayList<>();
        }

        dfsFind(0, tree, s, stacks, newParent);

        List<Integer>[] newTree = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            newTree[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            newTree[newParent[i]].add(i);
        }

        int[] ans = new int[n];
        dfsSize(0, newTree, ans);

        return ans;
    }

    private void dfsFind(int u,
                         List<Integer>[] tree,
                         String s,
                         List<Integer>[] stacks,
                         int[] newParent) {

        int idx = s.charAt(u) - 'a';

        if (!stacks[idx].isEmpty()) {
            newParent[u] = stacks[idx]
                    .get(stacks[idx].size() - 1);
        }

        stacks[idx].add(u);

        for (int v : tree[u]) {
            dfsFind(v, tree, s, stacks, newParent);
        }

        stacks[idx].remove(stacks[idx].size() - 1);
    }

    private int dfsSize(int u,
                        List<Integer>[] tree,
                        int[] ans) {

        int size = 1;

        for (int v : tree[u]) {
            size += dfsSize(v, tree, ans);
        }

        ans[u] = size;
        return size;
    }
}