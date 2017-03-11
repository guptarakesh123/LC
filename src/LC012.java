/*
Given a roman numeral, convert it to an integer.

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
public class LC012 {
    public static void main(String[] args) {
        System.out.println(new LC012().intToRoman(2012));
    }
    
    public String intToRoman(int num) {
        int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] codes = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int i = 0;
        StringBuffer sb = new StringBuffer();
        
        int remaining = num;
        while(remaining > 0){
            if(remaining >= values[i]){
                sb.append(codes[i]);
                remaining = remaining - values[i];
            } else {
                i++;
            }
            //System.out.println(num - remaining + " = " +  sb.toString());
        }
        
        return sb.toString();
    }
}
