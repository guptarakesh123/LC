import java.util.HashMap;
import java.util.Map;

/*
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Note: Given n will be a positive integer.

 */
public class LC070 {
    public static void main(String[] args) {
        System.out.println(new LC070().climbStairs(44));
    }
    
    public int climbStairs(int n) {
        if (n < 1) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        
        return climbStairs(n, map);
    }
    
    private int climbStairs(int n, Map<Integer, Integer> map) {
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        Integer n2 = map.get(n - 2);
        if (n2 == null) {
            n2 = climbStairs(n - 2, map);
            map.put(n - 2, n2);
        }
        
        Integer n1 = map.get(n - 1);
        if (n1 == null) {
            n1 = climbStairs(n - 1, map);
            map.put(n - 1, n1);
        }
        
        return n1 + n2;
    }
    
    public int climbStairs1(int n) {
        if(n < 1){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}
