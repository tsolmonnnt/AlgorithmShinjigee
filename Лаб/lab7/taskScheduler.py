class Solution:
    def sort(self, arr):
        arr.sort()

    def isallequal(self, arr):
        for i in range(26):
            if arr[i] != 0:
                return False
        return True

    def leastInterval(self, tasks, k):
        arr = [0] * 26  
        
        for ch in tasks:
            arr[ord(ch) - ord('A')] += 1
        
        self.sort(arr)
        
        x = k + 1  
        y = 25 
        ans = 0 

        while arr[25] != 0:  
            while x > 0:
                if y >= 0 and arr[y] != 0:
                    arr[y] -= 1
                    if self.isallequal(arr):
                        return ans + 1
                y -= 1
                x -= 1
                ans += 1
            
            x = k + 1
            y = 25
            self.sort(arr)
        
        return ans