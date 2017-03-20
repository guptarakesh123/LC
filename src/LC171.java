/*
Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 

 */
public class LC171 {
    public static void main(String[] args) {
        System.out.println(new LC171().titleToNumber("CAB"));
    }
    
    public int titleToNumber(String s) {
        int n = 0;
        for (int i = 0; i < s.length(); i++) {
            n = 26 * n + s.charAt(i) - 'A' + 1;
        }
        return n;
    }
}
