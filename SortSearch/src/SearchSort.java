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
        int[] arr = {33, 3, 3, 3, 4, -1, 4,2,4,6,3,2};
        // BubbleSort(arr);
        MergeSort(arr);
        System.out.println(Arrays.toString(arr));

    }

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

    public static int[] MergeSort(int[] arr) {
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
}

// SearchSort x = new SearchSort();