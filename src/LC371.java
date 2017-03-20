/*
Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.

Example:
Given a = 1 and b = 2, return 3.
*/
public class LC371 {
    public static void main(String[] args) {
        System.out.println(new LC371().getSum(-3, 5));
    }
    
    public int getSum(int a, int b) {
        boolean add = false;
        int sign = 1;
        
        if (a > 0 && b > 0) {
            add = true;
        }
        if (a < 0 && b < 0) {
            add = true;
            a = -1 * a;
            b = -1 * b;
            sign = -1;
        }
        if (a < 0 && b > 0) {
            add = false;
            a = -1 * a;
            if (a > b) {
                sign = -1;
            }
        }
        if (a > 0 && b < 0) {
            add = false;
            b = -1 * b;
            if (a < b) {
                sign = -1;
            }
        }
        
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        if(min == 0){
            return max;
        }
        int mult = max / min;
        if (add) {
            int m = ++mult;
            mult--;
            int n = min * m;
            for (int i = min * mult; i < max; i++) {
                n++;
            }
            return n * sign;
        } else {
            int m = --mult;
            mult++;
            int n = min * m;
            for (int i = min * mult; i < max; i++) {
                n++;
            }
            return n * sign;
        }
    }
}
