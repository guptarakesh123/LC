
public class LC011 {
    public static void main(String[] args) {
        System.out.println(new LC011().maxArea(new int[] { 1, 2, 1 }));
    }
    
    public int maxArea(int[] height) {
        int m = 0;
        int j = height.length - 1;
        for (int i = 0; i < j;) {
            for (; j > i;) {
                int min = Math.min(height[i], height[j]);
                int t = (j - i) * min;
                if (height[i] == min) {
                    i++;
                } else {
                    j--;
                }
                if (t > m) {
                    m = t;
                }
            }
        }
        return m;
    }
    
    public int maxArea2(int[] height) {
        int m = 0;
        int prevI = 0;
        for (int i = 0; i < height.length - 1; i++) {
            if (height[i] < height[prevI]) {
                continue;
            }
            int j = height.length - 1;
            int t = (j - i) * Math.min(height[i], height[j]);
            if (t > m) {
                m = t;
            }
            int curr = j;
            j--;
            for (; j > i; j--) {
                if (height[j] > height[curr]) {
                    curr = j;
                    t = (j - i) * Math.min(height[i], height[j]);
                    if (t > m) {
                        m = t;
                    }
                }
            }
            
            prevI = i;
        }
        
        return m;
    }
    
}
