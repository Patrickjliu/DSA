// As we get into the swing of things we are revisiting some old and some new problems with Arrays. 

// For each question create a unique function and indicate which question it answers with a comment.

// For function indicate it's best, average, and worst case Time complexities. Either in a comment or docstring tied to the function.

 

// Write a program that takes in an array and performs bubble sort, either returning the new array or modifying the reference array.
// Write the merge sort sorting algorithm.
// Write a Function that takes in a sorted array and a target value. Have the function return the index where the target value should be within the array.
// Write a function that takes in a number of rows as an argument and returns a two dimensional array of the values of pascals triangle.
// Example PascalTriangle(5) ->  [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
// Assume the number of rows is >=1 
// Write a function that takes in a sorted array of elements and a target value. Have the function return the first and last index of the target value within the array as a list. If the target value is not within the array return [-1, -1]

import java.util.Arrays;

class SearchSort {
    public static void main(String[] args) {
        int[] arr = {33, 3, 3, 3, 4, -1, 4, 2, 4, 6, 3, 2};

        // Test BubbleSort
        System.out.println("BubbleSort: " + Arrays.toString(BubbleSort(arr.clone())));

        // Test MergeSort
        int[] mergeSortedArr = arr.clone();
        MergeSort(mergeSortedArr);
        System.out.println("MergeSort: " + Arrays.toString(mergeSortedArr));

        // Test findInsertIndex
        int[] sortedArr = {1, 3, 5, 6};
        System.out.println("InsertIndex: " + findInsertIndex(sortedArr, 5));

        System.out.println("InsertIndex: " + findInsertIndex(sortedArr, 2));

        // Test generatePascalsTriangle
        System.out.println("PascalTriangle: " + Arrays.deepToString(generatePascalsTriangle(5)));

        // Test findFirstAndLastIndex
        int[] sortedArrWithDuplicates = {1, 2, 2, 2, 3, 4, 5};
        System.out.println("FirstAndLastIndex: " + Arrays.toString(findFirstAndLastIndex(sortedArrWithDuplicates, 2)));
        System.out.println("FirstAndLastIndex: " + Arrays.toString(findFirstAndLastIndex(sortedArrWithDuplicates, 6)));

    }

    // Question 1: Bubble Sort
    // Best: O(n), Avg/Worst: O(n^2)
    public static int[] BubbleSort(int[] arr) {
        boolean notSorted;
        do {
            notSorted = false;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i + 1];
                    arr[i + 1] = arr[i];
                    arr[i] = temp;
                    notSorted = true;
                }
            }
        } while (notSorted);
        return arr;
    }

    // Question 2: Merge Sort
    // Best/Avg/Worst: O(n log n)
    public static void MergeSort(int[] arr) {
        if (arr.length > 1) {
            int mid = arr.length / 2;
            int[] left = Arrays.copyOfRange(arr, 0, mid);
            int[] right = Arrays.copyOfRange(arr, mid, arr.length);

            MergeSort(left);
            MergeSort(right);

            merge(arr, left, right);
        }
    }

    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0;
        int j = 0;
        int k = 0;
        
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        while (i < left.length) {
            arr[k++] = left[i++];
        }
        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }

    // Question 3: Find Insert Index
    // Best: O(1), Avg/Worst: O(log n)
    public static int findInsertIndex(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    // Question 4: Pascal's Triangle
    // Best/Avg/Worst: O(n^2)
    public static int[][] generatePascalsTriangle(int rows) {
        int[][] triangle = new int[rows][];

        for (int i = 0; i < rows; i++) {
            triangle[i] = new int[i + 1];
            triangle[i][0] = 1; 
            triangle[i][i] = 1; 

            for (int j = 1; j < i; j++) {
                triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
            }
        }
        return triangle;
    }

    // Question 5: Find First and Last Index
    // Best: O(1), Avg/Worst: O(log n)
    public static int[] findFirstAndLastIndex(int[] arr, int target) {
        int[] result = {-1, -1};
        int left = 0, right = arr.length - 1;
    
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                result[0] = mid; // maybe first index
                right = mid - 1; // Keep looking left
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
    
        left = 0;
        right = arr.length - 1;
    
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                result[1] = mid; // maybe last index
                left = mid + 1; // Keep going right
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
    
        return result;
    }
}