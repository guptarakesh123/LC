/*
Given an array of integers, every element appears twice except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
*/
public class LC136 {
    public static void main(String[] args) {
        System.out.println(new LC136().singleNumber(new int[] {1,1,2,2,45,67,67}));
    }
    
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("bad input");
        }
        int n = nums[0];
        
        for(int i = 1; i < nums.length; i++){
            n = n ^ nums[i];
        }
        
        return n;
    }
}
