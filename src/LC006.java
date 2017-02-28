
public class LC006 {
    public static void main(String[] args) {
        String s = "A";// "AYPALISHIRING";
        
        int n = 3;
        
        String op = new LC006().convert2(s, n);
        System.out.println("zig zag output = " + op);
        
        if ("PAYPALISHIRING".equals(s) && n == 3 && !"PAHNAPLSIIGYIR".equals(op)) {
            System.out.println("incorrect conversion");
        }
    }
    
    public String convert(String s, int numRows) {
        StringBuffer sb = new StringBuffer();
        
        return sb.toString();
    }
    
    public String convert2(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuffer sb = new StringBuffer();
        for (int r = 0; r < numRows; r++) {
            int c = 0;
            int cVal = r;
            int cValLeft = Integer.MIN_VALUE;
            while (cValLeft < s.length()) {
                if (r > 0 && c > 0) {
                    sb.append(s.charAt(cValLeft));
                }
                if (r < numRows - 1 && cVal < s.length()) {
                    sb.append(s.charAt(cVal));
                }
                c++;
                cValLeft = c * 2 * (numRows - 1) - r;
                cVal = c * 2 * (numRows - 1) + r;
                
            }
            //System.out.println(sb.toString());
        }
        return sb.toString();
    }
}
