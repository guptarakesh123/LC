/*
Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.

I   1
IV  4
V   5
IX  9
X   10
XL  40
L   50
XC  90
C   100
CD  400
D   500
CM  900
M   1000
 */
public class LC013 {
    public static void main(String[] args) {
        System.out.println(new LC013().romanToInt("XXXVI"));
    }
    public int romanToInt(String s) {
        
        if (s == null) {
            throw new IllegalArgumentException("Null input");
        }
        int n = 0, i = 0;
        String c;
        s = s.toLowerCase();
        for (; i < s.length() - 1; ) {
            
            boolean case1 = s.charAt(i) == 'i' && (s.charAt(i+1) == 'v' || s.charAt(i+1) == 'x');
            boolean case2 = s.charAt(i) == 'x' && (s.charAt(i+1) == 'l' || s.charAt(i+1) == 'c');
            boolean case3 = s.charAt(i) == 'c' && (s.charAt(i+1) == 'd' || s.charAt(i+1) == 'm');
            if(case1 || case2 || case3){
                c = s.substring(i,i+2);
                i = i + 2;
            } else {
                c = String.valueOf(s.charAt(i));
                i = i + 1;
            }
            int t = getSingleRomanNumber(c);
            n = n + t;
        }
        if(i < s.length()){
            c = String.valueOf(s.charAt(i));
            int t = getSingleRomanNumber(c);
            n = n + t;
        }
        return n;
    }
    
    public static int getSingleRomanNumber(String s){
        switch(s){
        case "i": return 1;
        case "iv": return 4;
        case "v": return 5;
        case "ix": return 9;
        case "x": return 10;
        case "xl": return 40;
        case "l": return 50;
        case "xc": return 90;
        case "c": return 100;
        case "cd": return 400;
        case "d": return 500;
        case "cm": return 900;
        case "m": return 1000;
        default: throw new IllegalArgumentException("non-roman input");
        }
    }
}
