import java.util.*;

class Solution {
    private static class Interval {
        int l, r, weight, originalIndex;

        Interval(int l, int r, int weight, int originalIndex) {
            this.l = l;
            this.r = r;
            this.weight = weight;
            this.originalIndex = originalIndex;
        }
    }

    private static class Result {
        long weightSum;
        List<Integer> sortedIndices;

        Result(long weightSum, List<Integer> sortedIndices) {
            this.weightSum = weightSum;
            this.sortedIndices = sortedIndices;
        }
    }

    private Interval[] sortedByL;
    private int[] nextValidIndex;
    private Result[][] memo;
    private int n;

    public int[] maximumWeight(List<List<Integer>> intervals) {
        n = intervals.size();
        sortedByL = new Interval[n];

        for (int i = 0; i < n; i++) {
            List<Integer> interval = intervals.get(i);
            sortedByL[i] = new Interval(interval.get(0), interval.get(1), interval.get(2), i);
        }

        // Sort by left boundary 'l'. If equal, by original index.
        Arrays.sort(sortedByL, (a, b) -> {
            if (a.l != b.l) return Integer.compare(a.l, b.l);
            return Integer.compare(a.originalIndex, b.originalIndex);
        });

        // Precompute next non-overlapping interval index
        nextValidIndex = new int[n];
        for (int i = 0; i < n; i++) {
            nextValidIndex[i] = binarySearch(i);
        }

        memo = new Result[n + 1][5];

        Result bestResult = solve(0, 0);

        int[] ans = new int[bestResult.sortedIndices.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = bestResult.sortedIndices.get(i);
        }
        return ans;
    }

    private Result solve(int idx, int count) {
        if (count == 4 || idx == n) {
            return new Result(0, new ArrayList<>());
        }

        if (memo[idx][count] != null) {
            return memo[idx][count];
        }

        // Option 1: Skip current interval
        Result skip = solve(idx + 1, count);

        // Option 2: Pick current interval
        Result nextResult = solve(nextValidIndex[idx], count + 1);

        long pickWeight = sortedByL[idx].weight + nextResult.weightSum;
        List<Integer> pickIndices = new ArrayList<>(nextResult.sortedIndices);
        
        // Insert original index into sorted order using Binary Search
        int origIdx = sortedByL[idx].originalIndex;
        int insertPos = Collections.binarySearch(pickIndices, origIdx);
        if (insertPos < 0) insertPos = -(insertPos + 1);
        pickIndices.add(insertPos, origIdx);

        Result pick = new Result(pickWeight, pickIndices);

        // Choose best choice based on max weight, then lexicographical order
        Result chosen = compareChoices(skip, pick);
        memo[idx][count] = chosen;
        return chosen;
    }

    private Result compareChoices(Result r1, Result r2) {
        if (r1.weightSum > r2.weightSum) return r1;
        if (r2.weightSum > r1.weightSum) return r2;

        // Weights are equal -> Compare sorted index lists lexicographically
        List<Integer> l1 = r1.sortedIndices;
        List<Integer> l2 = r2.sortedIndices;

        int minLen = Math.min(l1.size(), l2.size());
        for (int i = 0; i < minLen; i++) {
            if (!l1.get(i).equals(l2.get(i))) {
                return l1.get(i) < l2.get(i) ? r1 : r2;
            }
        }

        return l1.size() <= l2.size() ? r1 : r2;
    }

    private int binarySearch(int idx) {
        int targetR = sortedByL[idx].r;
        int low = idx + 1, high = n, ans = n;

        while (low <= high && low < n) {
            int mid = low + (high - low) / 2;
            if (sortedByL[mid].l > targetR) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}