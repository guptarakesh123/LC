import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.

Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
*/

public class LC017 {
    public static void main(String[] args) {
        System.out.println(new LC017().letterCombinations("23"));
    }
    
    public List<String> letterCombinations(String digits) {
        if(digits == null){
            throw new IllegalArgumentException("null imput");
        }
        
        List<String> l = new ArrayList<>();
        Map<Character, String> m = new HashMap<>();
        m.put('2', "abc");
        m.put('3', "def");
        m.put('4', "ghi");
        m.put('5', "jkl");
        m.put('6', "mno");
        m.put('7', "pqrs");
        m.put('8', "tuv");
        m.put('9', "wxyz");
        
        letterCombinationHelper(l, m, digits, 0, "");
        
        return l;
    }
    private void letterCombinationHelper(List<String> l, Map<Character, String> m, String digits, int index, String curr){
        if(digits == null || index >= digits.length()){
            return;
        }
        Character c = digits.charAt(index);
        String values = m.get(c);
        
        if(values == null){
            throw new IllegalArgumentException("illegal character in input string : " + c);
        }
        
        if(index == digits.length() - 1){
            for(int i = 0; i < values.length(); i++){
                l.add(curr + values.charAt(i));
            }
        }
        else{
            for(int i = 0; i < values.length(); i++){
                letterCombinationHelper(l, m, digits, index + 1, curr + values.charAt(i));
            } 
        }
    }
}
