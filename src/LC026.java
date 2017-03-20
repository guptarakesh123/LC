import java.util.Arrays;

/*
Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
*/

public class LC026 {
    public static void main(String[] args) {
        int[] nums = {1, 1,2};
        System.out.println(new LC026().removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("null input");
        }
        if (nums.length <= 1) {
            return nums.length;
        }
        int k = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[i-1]){
                nums[k++] = nums[i];
            }
        }
        return k;
    }
    public int removeDuplicates1(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("null input");
        }
        if (nums.length <= 1) {
            return nums.length;
        }
        int[] t = new int[nums.length];
        int length = 1;
        t[0] = nums[0];
        int k = 0;
        for (int i = 1; i < nums.length; i++) {
            if (t[k] != nums[i]) {
                t[++k] = nums[i]; 
                length++;
            }
        }
        for(int i = 1; i < length; i++){
            nums[i] = t[i];
        }
        return length;
    }
}
