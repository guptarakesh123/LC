/*
Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

For example,
Given nums = [0, 1, 3] return 2.
 */
public class LC268 {
    public static void main(String[] args) {
        System.out.println(new LC268().missingNumber(new int[] { 0, 1, 3 }));
    }
    
    public int missingNumber(int[] nums) {
        int n = 0;
        for(int i = 0; i < nums.length; i++){
            n = n ^ i;
            n = n ^ nums[i];
        }
        n = n^nums.length;
        
        return n;
    }
}
