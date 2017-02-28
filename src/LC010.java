/*

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true

 */
public class LC010 {
    public static void main(String[] args) {
        LC010 o = new LC010();
        //System.out.println("aa , a = " + o.isMatch("aa", "a")); // false
        //System.out.println("aa , aa = " + o.isMatch("aa", "aa")); // true
        //System.out.println("aaa , aa = " + o.isMatch("aaa", "aa")); // false
        //System.out.println("aa , a* = " + o.isMatch("aa", "a*")); // true
        //System.out.println("aa , .* = " + o.isMatch("aa", ".*")); // true
        //System.out.println("ab , .* = " + o.isMatch("ab", ".*")); // true
        System.out.println("aab c*a*b = " + o.isMatch("aab", "c*a*b")); // true
    }
    
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        int lowestLength = getSmallestLength(p);
        
        if(s.length() < lowestLength){
            return false;
        }
        int i = s.length() - 1;
        int j = p.length() - 1;
        
        while(i >= 0 && j >= 0){
            char x = s.charAt(i);
            char y = p.charAt(j);
            
            if(x == y || y == '.'){
                i--;
                j--;
            } else if(y == '*'){
                String p1 = p.substring(0, j - 1) + p.substring(j + 1);
                String p2 = p.substring(0, j) + p.charAt(j - 1) + p.substring(j);
                
                boolean m = isMatch(s, p1);
                
                if(m){
                    return true;
                }
                
                m = isMatch(s, p2);
                return m;
                
            } else {
                return false;
            }
            
        }
        if(i >= 0){
            return false;
        }
        
        if(j >= 0){
            String p3 = p.substring(0, j + 1);
            int n = getSmallestLength(p3);
            if(n > 0){
                return false;
            }
        }
        
        return true;
    }
    
    private int getSmallestLength(String p) {
        if (p == null) {
            return 0;
        }
        int n = p.length();
        
        for (int i = p.length() - 1; i >= 0; i--) {
            if (p.charAt(i) == '*') {
                n = n - 2;
            }
        }
        
        return n;
    }
}
