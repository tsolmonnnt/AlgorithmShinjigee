#include <stdio.h>
#include <stdlib.h>

// Function to merge two subarrays
void merge(int* array, int low, int mid, int high) {
    int n1 = mid - low + 1;
    int n2 = high - mid;

    // Allocate memory for temporary arrays
    int* leftPart = (int*)malloc(n1 * sizeof(int));
    int* rightPart = (int*)malloc(n2 * sizeof(int));

    // Copy data to temp arrays
    for (int i = 0; i < n1; i++) {
        leftPart[i] = array[low + i];
    }
    for (int i = 0; i < n2; i++) {
        rightPart[i] = array[mid + 1 + i];
    }

    // Merge the temp arrays back into array[low..high]
    int p1 = 0, p2 = 0, writeInd = low;
    while (p1 < n1 && p2 < n2) {
        if (leftPart[p1] <= rightPart[p2]) {
            array[writeInd++] = leftPart[p1++];
        } else {
            array[writeInd++] = rightPart[p2++];
        }
    }

    // Copy the remaining elements of leftPart[], if any
    while (p1 < n1) {
        array[writeInd++] = leftPart[p1++];
    }

    // Copy the remaining elements of rightPart[], if any
    while (p2 < n2) {
        array[writeInd++] = rightPart[p2++];
    }

    // Free the allocated memory
    free(leftPart);
    free(rightPart);
}

// Function to perform merge sort
void mergeSort(int* array, int low, int high) {
    if (low >= high) {
        return;
    }
    int mid = low + (high - low) / 2;

    mergeSort(array, low, mid);
    mergeSort(array, mid + 1, high);
    merge(array, low, mid, high);
}

// Function to sort the array
void sortArray(int* nums, int numsSize) {
    mergeSort(nums, 0, numsSize - 1);
}

// Driver function to test the sort
int main() {
    int nums[] = {5, 2, 9, 1, 5, 6};
    int numsSize = sizeof(nums) / sizeof(nums[0]);

    sortArray(nums, numsSize);

    printf("Sorted array: ");
    for (int i = 0; i < numsSize; i++) {
        printf("%d ", nums[i]);
    }
    printf("\n");

    return 0;
}
