import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC018 {
    public static void main(String[] args) {
        int[] nums = { 1, 0, -1, 0, -2, 2 };
        int target = 0;

        System.out.println(new LC018().fourSum(nums, target));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null) {
            throw new IllegalArgumentException("null input");
        }

        List<List<Integer>> ll = new ArrayList<>();

        if (nums.length < 4) {
            return ll;
        }
        
        Arrays.sort(nums);
        
        for(int i = 0; i + 3 < nums.length;){
            for(int j = i + 1; j + 2 < nums.length;){
                
                int low = j + 1, high = nums.length - 1;
                
                while(low < high){
                    if(nums[i] + nums[j] + nums[low] + nums[high] == target){
                        List<Integer> l = Arrays.asList(nums[i], nums[j], nums[low], nums[high]);
                        ll.add(l);
                        
                        while(low < high && nums[low] == nums[++low]);
                        while(low < high && nums[high] == nums[--high]);
                    } else if(nums[i] + nums[j] + nums[low] + nums[high] < target){
                        while(low < high && nums[low] == nums[++low]);
                    } else if(nums[i] + nums[j] + nums[low] + nums[high] > target){
                        while(low < high && nums[high] == nums[--high]);
                    }
                }
                
                while(j + 2 < nums.length && nums[j] == nums[++j]);
            }
            while(i + 3 < nums.length && nums[i] == nums[++i]);
        }

        return ll;
    }
}
