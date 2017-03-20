import java.util.HashSet;
import java.util.Set;

/*
Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.

Note: You may assume the string contain only lowercase letters.
*/
public class LC387 {
    public static void main(String[] args) {
        System.out.println(new LC387().firstUniqChar("loveleetcode"));
    }
    
    public int firstUniqChar(String s) {
        if (s == null) {
            throw new IllegalArgumentException("null input");
        }
        
        Set<Character> presentSet = new HashSet<>();
        Set<Character> restrictedSet = new HashSet<>();
        
        for(int i = 0; i < s.length(); i++){
            Character c = s.charAt(i);
            if(!presentSet.contains(c)){
                presentSet.add(c);
            } else {
                restrictedSet.add(c);
            }
        }
        for(int i = 0; i < s.length(); i++){
            Character c = s.charAt(i);
            if(!restrictedSet.contains(c)){
                return i;
            }
        }
        
        return -1;
    }
}
