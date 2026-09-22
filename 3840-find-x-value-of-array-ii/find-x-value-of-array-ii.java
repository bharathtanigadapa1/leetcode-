class Solution {
    static class Node {
        int prod;
        int[] cnt;

        Node(int k) {
            this.prod = 1;
            this.cnt = new int[k];
        }
    }

    private Node[] tree;
    private int[] nums;
    private int n, k;

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        this.nums = nums;
        this.n = nums.length;
        this.k = k;
        this.tree = new Node[4 * n];

        build(1, 0, n - 1);

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int idx = queries[i][0];
            int val = queries[i][1];
            int start = queries[i][2];
            int targetX = queries[i][3];

            // Step 1: Update nums[idx] = val
            update(1, 0, n - 1, idx, val);

            // Step 2: Query range [start, n - 1]
            Node queryNode = query(1, 0, n - 1, start, n - 1);

            // Step 3: Get count for remainder targetX
            result[i] = queryNode.cnt[targetX];
        }

        return result;
    }

    private Node merge(Node left, Node right) {
        if (left == null) return right;
        if (right == null) return left;

        Node parent = new Node(k);
        parent.prod = (left.prod * right.prod) % k;

        // Copy prefix counts from left child
        for (int r = 0; r < k; r++) {
            parent.cnt[r] = left.cnt[r];
        }

        // Add prefix counts extended from left into right child
        for (int r = 0; r < k; r++) {
            int newRem = (left.prod * r) % k;
            parent.cnt[newRem] += right.cnt[r];
        }

        return parent;
    }

    private void build(int node, int l, int r) {
        if (l == r) {
            tree[node] = new Node(k);
            int rem = nums[l] % k;
            tree[node].prod = rem;
            tree[node].cnt[rem] = 1;
            return;
        }
        int mid = (l + r) / 2;
        build(2 * node, l, mid);
        build(2 * node + 1, mid + 1, r);
        tree[node] = merge(tree[2 * node], tree[2 * node + 1]);
    }

    private void update(int node, int l, int r, int idx, int val) {
        if (l == r) {
            nums[idx] = val;
            tree[node] = new Node(k);
            int rem = val % k;
            tree[node].prod = rem;
            tree[node].cnt[rem] = 1;
            return;
        }
        int mid = (l + r) / 2;
        if (idx <= mid) {
            update(2 * node, l, mid, idx, val);
        } else {
            update(2 * node + 1, mid + 1, r, idx, val);
        }
        tree[node] = merge(tree[2 * node], tree[2 * node + 1]);
    }

    private Node query(int node, int l, int r, int ql, int qr) {
        if (ql <= l && r <= qr) {
            return tree[node];
        }
        int mid = (l + r) / 2;
        if (qr <= mid) {
            return query(2 * node, l, mid, ql, qr);
        }
        if (ql > mid) {
            return query(2 * node + 1, mid + 1, r, ql, qr);
        }
        Node leftResult = query(2 * node, l, mid, ql, qr);
        Node rightResult = query(2 * node + 1, mid + 1, r, ql, qr);
        return merge(leftResult, rightResult);
    }
}
