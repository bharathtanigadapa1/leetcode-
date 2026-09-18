import java.util.*;

class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();
        int[] l = new int[26];
        int[] r = new int[26];
        Arrays.fill(l, -1);
        Arrays.fill(r, -1);

        // Step 1: Find first and last occurrences of each character
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            if (l[c] == -1) l[c] = i;
            r[c] = i;
        }

        List<String> res = new ArrayList<>();
        int rightmost = -1;

        // Step 2 & 3: Find valid intervals and pick greedily
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            if (i == l[c]) { // Only process from the first appearance of character
                int newRight = checkSubstring(s, i, l, r);
                if (newRight != -1) {
                    if (i > rightmost) {
                        res.add(""); // Placeholder for next non-overlapping substring
                    }
                    rightmost = newRight;
                    res.set(res.size() - 1, s.substring(i, rightmost + 1));
                }
            }
        }
        return res;
    }

    private int checkSubstring(String s, int i, int[] l, int[] r) {
        int right = r[s.charAt(i) - 'a'];
        for (int j = i; j <= right; j++) {
            int c = s.charAt(j) - 'a';
            if (l[c] < i) return -1; // Invalid if it references an earlier character start
            right = Math.max(right, r[c]);
        }
        return right;
    }
}