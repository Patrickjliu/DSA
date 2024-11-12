/*
 * This source file was generated by the Gradle 'init' task
 */
package testcases;

import java.util.HashMap;
import java.util.Stack;

public class App {

    public int majority(int[] nums) {

        HashMap<Integer, Integer> count = new HashMap<>();
        int majorityElement = nums[0];

        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);

            if (count.get(num) > count.getOrDefault(majorityElement, 0)) {
                majorityElement = num;
            }
        }
        return majorityElement;
    }

    public int rotatedSearch(int[] nums, int target) {

        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;

                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {

            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    public static String removeDuplicates(String str) {

        Stack<Character> stack = new Stack<>();

        for (char ch : str.toCharArray()) {

            if (!stack.isEmpty() && stack.peek() == ch) {
                stack.pop(); // Remove
            } else {
                stack.push(ch); // Add
            }
        }

        StringBuilder result = new StringBuilder();
        for (char ch : stack) {
            result.append(ch);
        }

        return result.toString();
    }

    // public static void main(String[] args) {
    //     System.out.println("Running");
    // }
}


class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}