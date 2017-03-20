
/*
Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?

 */
import java.util.HashMap;
import java.util.Map;

public class LC242 {
    public static void main(String[] args) {
        System.out.println(new LC242().isAnagram("anagram", "nagaramu"));
    }
    
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) {
            throw new IllegalArgumentException("null input");
        }
        
        Map<Character, Integer> m = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            Integer f = m.get(c);
            if (f == null) {
                m.put(c, 1);
            } else {
                m.put(c, f + 1);
            }
        }
        
        for (int i = 0; i < t.length(); i++) {
            Character c = t.charAt(i);
            Integer f = m.get(c);
            if (f == null) {
                return false;
            } else {
                m.put(c, f - 1);
            }
        }
        
        for (Character c : m.keySet()) {
            Integer f = m.get(c);
            if (f == null || f != 0) {
                return false;
            }
        }
        
        return true;
    }
}
