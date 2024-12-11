class Solution:
    def minCostClimbingStairs(self, cost):
        n = len(cost)
        a = [0] * n
        for i in range(n):
            if i < 2:
                a[i] = cost[i]
            else:
                a[i] = cost[i] + min(a[i-1], a[i-2])
        return min(a[n-1], a[n-2])
