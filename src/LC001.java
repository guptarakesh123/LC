import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC001 {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        
        int[] op = new LC001().twoSumAnother(nums, target);
        
        System.out.println(Arrays.toString(op));
    }
    public int[] twoSum(int[] nums, int target) {
        int[] op= new int[2];
        
        for(int i = 0; i < nums.length-1; i++){
            for(int j = i+1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    op[0] = i;
                    op[1] = j;
                    return op;
                }
            }
        }
        return null;
    }
    public int[] twoSumAnother(int[] nums, int target) {

        Map<Integer, Integer> m = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if(m.containsKey(complement)){
                return new int[]{i,m.get(complement)};
            }
            m.put(nums[i], i);
        }
        return null;
    }
}
