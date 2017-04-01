/*
Given an integer, write a function to determine if it is a power of three.

Follow up:
Could you do it without using any loop / recursion?
*/
public class LC326 {
    public static void main(String[] args) {
        System.out.println(new LC326().isPowerOfThree(29));
        System.out.println(new LC326().isPowerOfThree(27*3*3));
    }
    public boolean isPowerOfThree(int n) {
        if(n <= 0){
            return false;
        }
        int maxPow = (int)(Math.log(Integer.MAX_VALUE) / Math.log(3));
        int maxValue = (int)Math.round(Math.pow(3, maxPow));
        
        if(maxValue % n == 0){
            return true;
        }
                
        return false;
    }
    public boolean isPowerOfThree2(int n) {
        if(n <= 0){
            return false;
        }
        double logN = Math.log10(n);
        double log3 = Math.log10(3);
        double div = logN / log3;
        
        if(1.0 * (int)div == div){
            return true;
        }
                
        return false;
    }
    public boolean isPowerOfThree1(int n) {
        if(n <= 0){
            return false;
        }
        while(n > 1){
            if(n % 3 != 0){
                return false;
            }
            n = n / 3;
        }
        
        return true;
    }
}
