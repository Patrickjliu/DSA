// Sets and Hash tables(Also called dictionaries or just hashes) are a way of storing information that stores not by index but by hash function. 

// Please create a java or python script that solves the following problems.

// Create a function called mostFrequent that takes in an array and returns the element within the array that occurs the most often
// Ex. mostFrequent([ 40,50,30,40,50,30,30]) -> 30
// You can assume one value will be more frequent and do not need to account for ties.
// Create a function that is called duplicates that takes in an array and returns true if the array contains any duplicate values
// Ex. duplicates([1, 2, 3, 1]) -> True
// Ex. duplicates([1, 2, 3, 4]) -> False
// Create a function called subSet that takes in two arrays and checks if the second array is a subset of the first array. That is to say all values within the second array appear within the first array.
// Ex. subSet([11, 1, 13, 21, 3, 7], [11, 3, 7, 1]) - > True
// Ex. subSet([10, 5, 2, 23, 19], [19, 5, 3]) - > False
// Both arrays are unsorted and contains no duplicates within themselves.
// Create a function called frequencySort that takes in an array and returns an array sorted such that the most frequent elements are at the front and least frequent are at the back. If two elements share a frequency maintain their order from the original array.
// frequencySort([2, 5, 2, 8, 5, 6, 8, 8]) -> [8, 8, 8, 2, 2, 5, 5, 6] 
// Note that 2 and 5 have the same frequency but because 2 comes first in the original list it is first in the returned list.
// Create a function called twoSum that takes in an array and a target value. Return the indices of the two numbers within the array that add up to the target value
// Ex. twoSum([2, 7, 11, 15], 9) -> [0,1]
// Ex. twoSum([3, 3, 5, 2], 6 -> [0,1]
// You can assume each array has exactly one solution.
// The given array should be assumed to be out of order.

import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        App app = new App();
        
        // Test mostFrequent
        int[] arr1 = {40, 50, 30, 40, 50, 30, 30};
        System.out.println(app.mostFrequent(arr1));

        // Test duplicates
        int[] arr2 = {1, 2, 3, 1};
        System.out.println(app.duplicates(arr2));

        int[] arr3 = {1, 2, 3, 4};
        System.out.println(app.duplicates(arr3));

        // Test subSet
        int[] set1 = {11, 1, 13, 21, 3, 7};
        int[] set2 = {11, 3, 7, 1};
        System.out.println(app.subSet(set1, set2));

        int[] set3 = {10, 5, 2, 23, 19};
        int[] set4 = {19, 5, 3};
        System.out.println(app.subSet(set3, set4));

        // Test frequencySort
        int[] arr4 = {2, 5, 2, 8, 5, 6, 8, 8};
        int[] arr10 = {5, 2, 2, 8, 5, 6, 8, 8};
        System.out.println(Arrays.toString(app.frequencySort(arr10)));

        // Test twoSum
        int[] arr5 = {2, 7, 11, 15};
        int target1 = 9;
        System.out.println(Arrays.toString(app.twoSum(arr5, target1)));

        int[] arr6 = {3, 3, 5, 2};
        int target2 = 6;
        System.out.println(Arrays.toString(app.twoSum(arr6, target2)));
    }
    
    public int[] mostFrequent(int[] nums) {
        HashMap<Integer,Integer>map=new HashMap<>();
        int n=nums.length;
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        Integer temp[]=new Integer[n];
        for(int i=0;i<n;i++){
            temp[i]=nums[i];
        }
        Arrays.sort(temp, new Comparator<Integer>(){
            public int compare(Integer a,Integer b){
                if(map.get(a)==map.get(b)){
                    return b-a;
                }return map.get(a)-map.get(b);
            }
        });
         for(int i=0;i<n;i++){
            nums[i]=temp[i];
        }
       return nums;
    }

    public boolean duplicates(int[] arr) throws Exception {

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }

        return arr.length != set.size();
    }

    public boolean subSet(int[] arr1, int[] arr2) throws Exception {

        HashMap<Integer, Integer> hashTable = new HashMap<>();

        for (int i = 0; i < arr1.length; i++) {
            hashTable.put(arr1[i], 1 + hashTable.getOrDefault(arr1[i], 0));
        }

        for (int i = 0; i < arr2.length; i++){
            if (hashTable.get(arr2[i]) == null){
                return false;
            }
        }
        return true;
    }

    public static int[] frequencySort(int[] arr) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        Map<Integer, Integer> fom = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
            fom.putIfAbsent(num, i);
        }

        List<Integer> list = new ArrayList<>();
        for (int num : arr) {
            list.add(num);
        }

        list.sort((a, b) -> {
            int freqA = frequencyMap.get(a);
            int freqB = frequencyMap.get(b);

            if (freqA != freqB) {
                return freqB - freqA;
            } 
            else {
                return fom.get(a) - fom.get(b);
            }
        });

        return list.stream().mapToInt(i -> i).toArray();
    }

    public int[] twoSum(int[] arr, int target) throws Exception {

        HashMap<Integer, Integer> hashTable = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int sum = target - arr[i];

            if (hashTable.containsKey(sum)) {
                return new int[]{hashTable.get(sum), i};
            }
            hashTable.put(arr[i], i);
            
        }
        throw new IllegalArgumentException("No");
    }
}
