/*
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 */
public class LC053 {
    public static void main(String[] args) {
        System.out.println(new LC053().maxSubArray2(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));
        System.out.println(new LC053().maxSubArray2(new int[] { -2, -1}));
    }
    
    public int maxSubArray(int[] nums) {
        int largestSum = Integer.MIN_VALUE;
        int currentSum = 0;
        for(int i  = 0; i < nums.length; i++){
            if(currentSum + nums[i] > 0){
                currentSum = currentSum + nums[i];
                if(currentSum > largestSum){
                    largestSum = currentSum;
                }
            } else {
                currentSum = 0;
            }
            if(nums[i] > largestSum){
                largestSum = nums[i];
            }
        }
        return largestSum;
    }
    
    public int maxSubArray2(int[] nums) {
        int largestSum = nums[0];
        int currentSum = nums[0];
        for(int i  = 1; i < nums.length; i++){
            if(currentSum < 0){
                currentSum = nums[i];
            } else {
                currentSum += nums[i];
            }
            if(currentSum > largestSum){
                largestSum = currentSum;
            }
        }
        return largestSum;
    }
}
