
public class LC008 {
    public static void main(String[] args) {
        String s = "kl one two three";
        s = "+-23";
        int n = new LC008().myAtoi(s);
        
        System.out.println("n = " + n);
    }
    public int myAtoi(String str) {
        if (str == null) {
            return 0;
        }
        str = str.trim();
        if(str.length() == 0){
            return 0;
        }
        
        int n = 0;
        int multiplier = 1;
        int i = 0;
        
        if ('-' == str.charAt(0)) {
            multiplier = -1;
            i = 1;
        } else if ('+' == str.charAt(0)) {
            i = 1;
        }
        
        for (; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c < '0' || c > '9'){
                return n * multiplier;
            }
            try {
                n = Math.addExact(Math.multiplyExact(n, 10), c - '0');
            } catch (Exception e) {
                if(multiplier > 0){
                    return Integer.MAX_VALUE;
                } else {
                    return Integer.MIN_VALUE;
                }
            }
        }
        
        return n * multiplier;
    }
    public int myAtoi2(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        str = str.trim();
        str = str.toLowerCase();
        String[] parts = str.split("\\W");
        
        if (parts.length == 0) {
            return 0;
        }
        
        int n = 0;
        int multiplier = 1;
        int i = 0;
        
        if ("minus".equals(parts[0])) {
            multiplier = -1;
            i = 1;
        } else if ("plus".equals(parts[0])) {
            i = 1;
        }
        
        for (; i < parts.length; i++) {
            int t = -1;
            
            switch (parts[i]) {
            case "zero":
                t = 0;
                break;
            case "one":
                t = 1;
                break;
            case "two":
                t = 2;
                break;
            case "three":
                t = 3;
                break;
            case "four":
                t = 4;
                break;
            case "five":
                t = 5;
                break;
            case "six":
                t = 6;
                break;
            case "seven":
                t = 7;
                break;
            case "eight":
                t = 8;
                break;
            case "nine":
                t = 9;
                break;
            default:
                t = -1;
            }
            
            if (t < 0) {
                return n * multiplier;
            }
            try {
                n = Math.addExact(Math.multiplyExact(n, 10), t);
            } catch (Exception e) {
                if(multiplier > 0){
                    return Integer.MAX_VALUE;
                } else {
                    return Integer.MIN_VALUE;
                }
            }
        }
        
        return n * multiplier;
    }
}
