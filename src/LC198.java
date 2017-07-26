import java.util.HashMap;
import java.util.Map;

/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 */
public class LC198 {
    public static void main(String[] args) {
        System.out.println(new LC198().rob(new int[] { 1, 30, 2 }));
        System.out.println(new LC198().rob(new int[] { 29, 30, 2 }));
        
        int[] n = { 104, 209, 137, 52, 158, 67, 213, 86, 141, 110, 151, 127, 238, 147, 169, 138, 240, 185, 246, 225,
                147, 203, 83, 83, 131, 227, 54, 78, 165, 180, 214, 151, 111, 161, 233, 147, 124, 143 };
        System.out.println(new LC198().rob(n));
    }
    
    public int rob(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("input can't be null");
        }
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int n1 = 0;
        int n2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((i & 1) == 1) {
                n1 = Math.max(nums[i] + n1, n2);
            } else {
                n2 = Math.max(n1, nums[i] + n2);
            }
        }
        return Math.max(n1, n2);
    }
    public int rob3(int[] nums) {
        int a = 0;
        int b = 0;
        
        for (int i=0; i<nums.length; i++)
        {
            if (i%2==0)
            {
                a = Math.max(a+nums[i], b);
            }
            else
            {
                b = Math.max(a, b+nums[i]);
            }
        }
        
        return Math.max(a, b);
    }
    
    public int rob2(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("input can't be null");
        }
        if (nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int n1 = robHelper(nums, 1, map);
        int n2 = nums[0] + robHelper(nums, 2, map);
        return Math.max(n1, n2);
    }
    
    private int robHelper(int[] nums, int i, Map<Integer, Integer> map) {
        if (i >= nums.length) {
            return 0;
        }
        Integer maxVal = map.get(i);
        if (maxVal == null) {
            int n1 = robHelper(nums, i + 1, map);
            int n2 = nums[i] + robHelper(nums, i + 2, map);
            maxVal = Math.max(n1, n2);
            map.put(i, maxVal);
            return Math.max(n1, n2);
        } else {
            return maxVal;
        }
    }
}
