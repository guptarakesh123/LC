
public class LC004 {
    public static void main(String[] args) {
        int[] a = { 1, 2 };
        int[] b = { 3, 4 };
        
        double m = new LC004().findMedianSortedArrays(a, b);
        System.out.println("median = " + m);
    }
    
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int i = 0, j = 0, counter = 0, total;
        total = nums1.length + nums2.length;
        if (total == 0) {
            throw new IllegalArgumentException("there is no median of an empty array");
        }
        while (i < nums1.length && j < nums2.length && counter < total / 2) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
            counter++;
        }
        
        while (i < nums1.length && counter < total / 2) {
            i++;
            counter++;
        }
        
        while (j < nums2.length && counter < total / 2) {
            j++;
            counter++;
        }
        
        if (total % 2 == 0) {
            int a, b;
            if (i == 0) {
                a = nums2[j - 1];
            } else if (j == 0) {
                a = nums1[i - 1];
            } else {
                if (nums1[i - 1] < nums2[j - 1]) {
                    a = nums2[j - 1];
                } else {
                    a = nums1[i - 1];
                }
            }
            if (i == nums1.length) {
                b = nums2[j];
            } else if (j == nums2.length) {
                b = nums1[i];
            } else if (nums1[i] < nums2[j]) {
                b = nums1[i];
            } else {
                b = nums2[j];
            }
            return (a + b) * 1.0 / 2;
        } else {
            if (i == nums1.length) {
                return nums2[j];
            }
            if (j == nums2.length) {
                return nums1[i];
            }
            if (nums1[i] < nums2[j]) {
                return nums1[i];
            }
            return nums2[j];
        }
    }
    
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int l1 = nums1.length;
        int l2 = nums2.length;
        
        int a = (l1 + l2 + 1) / 2;
        int b = (l1 + l2 + 2) / 2;
        
        int aNum = findElementAt(a, nums1, 0, nums2, 0);
        int bNum = findElementAt(b, nums1, 0, nums2, 0);
        
        return (aNum + bNum) / 2.0;
        
    }
    
    private int findElementAt(int k, int[] a, int x, int[] b, int y) {
        if (a.length <= x) return b[y + k - 1];
        if (b.length <= y) return a[x + k - 1];
        
        if (k == 1) return Math.min(a[x], b[y]);
        
        int aMid = Integer.MAX_VALUE, bMid = Integer.MAX_VALUE;
        
        if(x + k/2 -1 < a.length){
            aMid = a[x + k/2 -1];
        }
        
        if(y + k/2 -1 < b.length){
            bMid = b[y + k/2 -1];
        }
        if(aMid < bMid){
            return findElementAt(k - k/2, a, x + k/2, b, y);
        } else {
            return findElementAt(k - k/2, a, x, b, y + k/2);
        }
    }
}
