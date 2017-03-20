import java.util.Arrays;

/*
Given an array of size n, find the majority element. The majority element is the element that appears more than [n/2] times.

You may assume that the array is non-empty and the majority element always exist in the array.
 */
public class LC169 {
    public static void main(String[] args) {
        System.out.println(new LC169().majorityElement(new int[] {}));
    }
    
    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
    
    public int majorityElement(int[] nums) {
        // field validations
        int h = nums[0];
        int c = 1;
        
        for (int i = 1; i < nums.length; i++) {
            if (c == 0) {
                h = nums[i];
                c = 1;
            } else if (h == nums[i]) {
                c++;
            } else {
                c--;
            }
        }
        return h;
    }
}
