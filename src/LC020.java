
public class LC020 {
    
    public static void main(String[] args) {
        System.out.println(new LC020().isValid("(("));
    }
    
    public boolean isValid(String s) {
        if (s == null) {
            throw new IllegalArgumentException("null input");
        }
        if (s.length() % 2 == 1) {
            return false;
        }
        char[] stack = new char[s.length() / 2];
        int i = -1;
        
        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            if (c == '(' || c == '{' || c == '[') {
                if (i + 1 == stack.length) {
                    return false;
                }
                stack[++i] = c;
            } else {
                if (i == -1) {
                    return false;
                }
                char d = stack[i--];
                boolean c1 = d == '(' && c == ')';
                boolean c2 = d == '{' && c == '}';
                boolean c3 = d == '[' && c == ']';
                
                if (!c1 && !c2 && !c3) {
                    return false;
                }
            }
        }
        
        if (i != -1) {
            return false;
        } else {
            return true;
        }
    }
}
