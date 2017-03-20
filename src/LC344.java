
public class LC344 {
    public static void main(String[] args) {
        System.out.println(new LC344().reverseString("hello"));
    }
    public String reverseString(String s) {
        StringBuffer sb = new StringBuffer(s.length());
        for(int i = s.length() - 1; i >= 0 ; i--){
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
