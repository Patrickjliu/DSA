import java.util.*;

public class App {
    private ArrayList<Integer> heap;
    private boolean isMinHeap;

    public App (boolean isMinHeap) {
        heap = new ArrayList<>();
        this.isMinHeap = isMinHeap;
    }

    public void add(int value) {
        heap.add(value);
        heapifyUp(heap.size() - 1);
    }

    public int pop() {
        
        if (heap.isEmpty()) {
            throw new NoSuchElementException("Heap is empty");
        }
    
        int topValue = heap.get(0);
        
        if (heap.size() > 1) {

            heap.set(0, heap.remove(heap.size() - 1));
            heapifyDown(0);
        } else {
            heap.remove(0);
        }
    
        return topValue;
    }

    public int length() {
        return heap.size();
    }

    public static App heapify(int[] arr, boolean isMinHeap) {

        App customHeap = new App(isMinHeap);
        
        for (int value : arr) {
            customHeap.add(value);
        }
        
        return customHeap;
    }

    private void heapifyUp(int index) {

        int parent = (index - 1) / 2;

        while (index > 0 && compare(heap.get(index), heap.get(parent))) {
            Collections.swap(heap, index, parent);
            index = parent;
            parent = (index - 1) / 2;
        }
    }

    private void heapifyDown(int index) {

        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;

        int extreme = index;

        if (leftChild < heap.size() && compare(heap.get(leftChild), heap.get(extreme))) {
            extreme = leftChild;
        }
        
        if (rightChild < heap.size() && compare(heap.get(rightChild), heap.get(extreme))) {
            extreme = rightChild;
        }
        
        if (extreme != index) {
            
            Collections.swap(heap, index, extreme);
            heapifyDown(extreme);
        }
    }

    private boolean compare(int child, int parent) {
        if (isMinHeap) {
            return child < parent;
        }

        return child > parent;
    }

    public static int stoneGame(int[] stones) {
        App maxHeap = new App(false);
        
        for (int stone : stones) {
            maxHeap.add(stone);
        }

        while (maxHeap.length() > 1) {
            int y = maxHeap.pop();
            int x = maxHeap.pop();

            if (y != x) {
                maxHeap.add(y - x);
            }
        }
        
        if (maxHeap.length() == 0) {
            return 0;
        } else {
            return maxHeap.pop();
        }
    }

    public static int nthLargest(int[] arr, int n) {
        if (arr.length < n) {
            return Arrays.stream(arr).min().getAsInt();
        }

        App minHeap = new App(true);

        for (int num : arr) {
            minHeap.add(num);

            if (minHeap.length() > n) {
                minHeap.pop();
            }
        }
        
        return minHeap.pop();
    }

    public static int minSum(int[] digits) {

        Arrays.sort(digits);

        int num1 = 0, num2 = 0;

        for (int i = 0; i < digits.length; i++) {

            if (i % 2 == 0) {
                num1 = num1 * 10 + digits[i];
            } else {
                num2 = num2 * 10 + digits[i];
            }
        }

        return num1 + num2;
    }

    public static void main(String[] args) {
        App minHeap = new App(true);
        minHeap.add(10);
        minHeap.add(20);
        minHeap.add(5);
        System.out.println("MiniH pop " + minHeap.pop());

        App maxHeap = new App(false);
        maxHeap.add(10);
        maxHeap.add(20);
        maxHeap.add(5);
        System.out.println("MaxHeap pop " + maxHeap.pop());

        int[] stones = {2, 7, 4, 1, 8, 1};
        System.out.println("Stone Game: " + stoneGame(stones));

        int[] arr = {1, 3, 5, 6, 7, 2, 20};
        System.out.println("4th LE " + nthLargest(arr, 4));

        int[] digits = {1, 5, 7, 2, 3, 8};
        System.out.println("MinSum  " + minSum(digits));
    }
}
