#include <stdio.h>

int countInRange(int* nums, int val, int left, int right) {
    int count = 0;
    for (int i = left; i <= right; i++) {
        if (nums[i] == val) {
            count++;
        }
    }
    return count;
}

int majorityElementRec(int* nums, int left, int right) {
    if (left == right) {
        return nums[left];
    }
    
    int mid = left + (right - left) / 2;
    
    int leftMajority = majorityElementRec(nums, left, mid);
    int rightMajority = majorityElementRec(nums, mid + 1, right);
    
    if (leftMajority == rightMajority) {
        return leftMajority;
    }
    
    int leftCount = countInRange(nums, leftMajority, left, right);
    int rightCount = countInRange(nums, rightMajority, left, right);
    
    return leftCount > rightCount ? leftMajority : rightMajority;
}

int majorityElement(int* nums, int numsSize) {
    return majorityElementRec(nums, 0, numsSize - 1);
}

// Driver function to test the majorityElement function
int main() {
    int nums[] = {2, 2, 1, 1, 1, 2, 2};
    int numsSize = sizeof(nums) / sizeof(nums[0]);
    
    int result = majorityElement(nums, numsSize);
    printf("Majority Element: %d\n", result);
    
    return 0;
}
