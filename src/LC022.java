import java.util.ArrayList;
import java.util.List;

/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
*/
public class LC022 {
    public static void main(String[] args) {
        System.out.println(new LC022().generateParenthesis(3));
    }
    public List<String> generateParenthesis(int n) {
        List<String> l = new ArrayList<String>();
        generateParanthesisHelper(l, "", n, n);
        return l;
    }
    
    private void generateParanthesisHelper(List<String> l, String curr, int openRemaining, int closeRemaining){
        if(openRemaining == 0){
            while(closeRemaining > 0){
                curr += ')';
                closeRemaining--;
            }
            l.add(curr);
            return;
        }
        if(openRemaining == closeRemaining){
            generateParanthesisHelper(l, curr + '(', openRemaining - 1, closeRemaining);
            return;
        }
        if(openRemaining > 0){
            generateParanthesisHelper(l, curr + '(', openRemaining - 1, closeRemaining);
        }
        generateParanthesisHelper(l, curr + ')', openRemaining, closeRemaining - 1);
    }
}
