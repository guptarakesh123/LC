/*
 * Write a function to find the longest common prefix string amongst an array of strings.
 */
public class LC014 {
    public static void main(String[] args) {
        String[] ip = { "tzaab", "zaaa", "zaac", "zaabab", "zaaaaaaaa", "" };
        System.out.println(new LC014().longestCommonPrefix(ip));
    }
    
    public String longestCommonPrefix(String[] strs) {
        if (strs == null) {
            throw new IllegalArgumentException("Null input");
        }
        if (strs.length == 0) {
            return "";
        }
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i] == null) {
                throw new IllegalArgumentException("one of the input strings in array is null");
            }
            if (strs[i].length() < minLen) {
                minLen = strs[i].length();
            }
        }
        int commonIndex = 0;
        for (; commonIndex < minLen; commonIndex++) {
            char c = strs[0].charAt(commonIndex);
            
            for (int i = 1; i < strs.length; i++) {
                if (c != strs[i].charAt(commonIndex)) {
                    String m = strs[0].substring(0, commonIndex);
                    return m;
                }
            }
        }
        return strs[0].substring(0, commonIndex);
    }
}
