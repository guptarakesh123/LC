/*
Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 

 */
public class LC168 {
    public static void main(String[] args) {
        System.out.println(new LC168().convertToTitle(27));
        LC168 lc168 = new LC168();
        LC171 lc171 = new LC171();
        for(int i = 1; i <= 20000; i++){
            String s = lc168.convertToTitle(i);
            int j = lc171.titleToNumber(s);
            
            if(i != j){
                System.out.println(i + " " + s + " " + j);
            }
        }
    }
    
    public String convertToTitle(int n) {
        StringBuffer sb = new StringBuffer();
        while (n > 0) {
            int t = (n - 1) % 26;
            sb.append((char) (t + 'A'));
            n = (n-1) / 26;
        }
        
        sb.reverse();
        return sb.toString();
    }
}
