import java.util.HashSet;
import java.util.Set;

/*
Given an array of integers, find if the array contains any duplicates.
Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.

 */
public class LC217 {
    public static void main(String[] args) {
        System.out.println(new LC217().containsDuplicate(new int[]{1,2,3,4}));
    }
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for(int n : nums){
            if(s.contains(n)){
                return true;
            }
            s.add(n);
        }
        return false;
    }
}
