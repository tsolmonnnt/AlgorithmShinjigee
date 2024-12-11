class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] a = new int[n];
        for (int i=0; i<n; i++) {
            if (i<2) a[i] = cost[i];
            else a[i] = cost[i] + Math.min(a[i-1], a[i-2]);
        }
        return Math.min(a[n-1], a[n-2]);
    }
    }