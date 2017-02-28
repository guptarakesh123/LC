
public class LC007 {
    public static void main(String[] args) {
        int n = 1534236469;
        
        int r = new LC007().reverse(n);
        System.out.println("original = " + n);
        System.out.println("reverse = " + r);
    }
    
    public int reverse(int x) {
        long y = 0;
        int multiplier = 1;
        if (x < 0) {
            multiplier = -1;
        }
        
        x = Math.abs(x);
        
        if (x < 0) {
            return 0;
        }
        
        while (x > 0) {
            //System.out.println("x = " + x + " , y = " + y);
            int temp = x % 10;
            y = 10 * y + temp;
            x = x / 10;
        }
        
        if (y > Integer.MAX_VALUE) {
            return 0;
        }
        
        y = multiplier * y;
        return (int)y;
    }
    
    public int reverse3(int x) {
        int y = 0;
        int multiplier = 1;
        if (x < 0) {
            multiplier = -1;
        }
        
        x = Math.abs(x);
        
        if (x < 0) {
            return 0;
        }
        
        while (x > 0) {
            System.out.println("x = " + x + " , y = " + y);
            int temp = x % 10;
            if ((Integer.MAX_VALUE - temp) / 10 < y) {
                return 0;
            }
            y = 10 * y + temp;
            x = x / 10;
        }
        
        if (y < 0) {
            return 0;
        }
        
        y = multiplier * y;
        return y;
    }
    
    public int reverse2(int x) {
        int y = 0;
        int multiplier = 1;
        if (x < 0) {
            multiplier = -1;
        }
        
        x = Math.abs(x);
        
        if (x < 0) {
            return 0;
        }
        
        while (x > 0) {
            int temp = x % 10;
            try {
                y = Math.addExact(Math.multiplyExact(10, y), temp);
            } catch (ArithmeticException e) {
                y = 0;
            }
            x = x / 10;
        }
        
        if (y < 0) {
            return 0;
        }
        
        y = multiplier * y;
        return y;
    }
}
