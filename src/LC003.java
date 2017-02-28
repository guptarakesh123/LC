public class LC003 {
    public static void main(String[] args) {
        String a = "bbbbbb";
        int len = new LC003().lengthOfLongestSubstring(a);
        System.out.println("length = " + len);
    }
    
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        StringBuffer sb = new StringBuffer();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int index = sb.lastIndexOf(c+"");
            if(index != -1){
                sb.delete(0, index+1);
                sb.append(c);
            } else {
                sb.append(c);
                if(max < sb.length()){
                    max = sb.length();
                }
            }
        }
        
        return max;
    }
}
