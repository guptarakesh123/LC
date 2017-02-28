
public class LC009 {
    public static void main(String[] args) {
        System.out.println(new LC009().isPalindrome(10));
    }
    
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        
//        while (x > 0 && x % 10 == 0) {
//            x = x / 10;
//        }
        
        int highestDigit = 0;
        int lowestDigit = 1;
        int y = x;
        while (y > 0) {
            highestDigit++;
            y = y / 10;
        }
        
        while (highestDigit > lowestDigit) {
            int l = getDigitAt(x, lowestDigit);
            int h = getDigitAt(x, highestDigit);
            
            if (l != h) {
                return false;
            }
            highestDigit--;
            lowestDigit++;
        }
        
        return true;
    }
    
    public int getDigitAt(int n, int i) {
        int cutOut = (int) Math.pow(10, i - 1);
        n = n / cutOut;
        
        return n % 10;
    }
}

// 7645 --> 4
//
//