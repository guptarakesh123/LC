import java.util.Arrays;

/*
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

 */
public class LC016 {
    public static void main(String[] args) {
        int[] nums = { 0,2,1,-3 };
        int target = 1;
        System.out.println(new LC016().threeSumClosest(nums, target));
    }
    
    public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length < 3){
            throw new IllegalArgumentException("input integer array incorrect");
        }
        Arrays.sort(nums);
        int closestSum = Integer.MAX_VALUE;
        if (target < 0) {
            closestSum = Integer.MIN_VALUE;
        } else {
            closestSum = Integer.MAX_VALUE;
        }
        
        for (int i = 0; i + 2 < nums.length; ) {
            
            int j = i + 1;
            int k = nums.length - 1;
            
            
            while (j < k) {
                int currSum = nums[i] + nums[j] + nums[k];
                
                if (currSum < target) {
                    while(j < k && nums[j] == nums[++j]);
                } else if (currSum > target) {
                    while(j < k && nums[k] == nums[--k]);
                } else {
                    return currSum;
                }
                if (Math.abs(currSum - target) < Math.abs(closestSum - target)) {
                    closestSum = currSum;
                }
            }
            
            while(i + 2 < nums.length && nums[i] == nums[++i]);
        }
        return closestSum;
    }
}
