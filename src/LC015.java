import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note: The solution set must not contain duplicate triplets.

For example, given array S = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
 */
public class LC015 {
    public static void main(String[] args) {
        int[] nums = { -4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6 };
        List<List<Integer>> ll = new LC015().threeSum(nums);
        // System.out.println(ll);
        
        System.out.println("[");
        for (List<Integer> l : ll) {
            System.out.println("\t" + l);
        }
        System.out.println("]");
    }
    
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> ll = new ArrayList<>();
//        Set<String> s = new HashSet<>();
        if(nums.length < 3){
            return ll;
        }
        Arrays.sort(nums);
        
        for (int i = 0; i + 2 < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }
            
            int j = i + 1;
            int k = nums.length - 1;
            
            while (k > j) {
                if (nums[i] + nums[j] + nums[k] == 0) {
//                    String curr = nums[i] + "," + nums[j] + "," + nums[k];
//                    if (!s.contains(curr)) {
//                        s.add(curr);
//                        ll.add(Arrays.asList(nums[i], nums[j], nums[k]));
//                    }
                    ll.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while(k > j && nums[k-1] == nums[k]){
                        k--;
                    }
                    while(k > j && nums[j+1] == nums[j]){
                        j++;
                    }
                    k--;
                    j++;
                } else if (nums[i] + nums[j] + nums[k] > 0) {
                    while(k > j && nums[k-1] == nums[k]){
                        k--;
                    }
                    k--;
                } else {
                    while(k > j && nums[j+1] == nums[j]){
                        j++;
                    }
                    j++;
                }
            }
            while(i + 2 < nums.length && nums[i] == nums[i+1]){
                i++;
            }
        }
        
        return ll;
    }
}
