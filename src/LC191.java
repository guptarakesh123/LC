/*
Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).

For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.
 */
public class LC191 {
    public static void main(String[] args) {
        int n = 0x8fffffff;
        System.out.println(Integer.toBinaryString(n));
        System.out.println(new LC191().hammingWeight(n));
    }
    public int hammingWeight(int n) {
        int num = 0;
        
        for(int i = 0; i < 32; i++){
            num += (n & 1);
            n = n >> 1;
        }
        return num;
    }
    
    public int hammingWeight3(int n) {
        int num = 0;
        
        while (n != 0) {
            num += (n & 1);
            n = n >>> 1;
        }
        return num;
    }
    
    public int hammingWeight2(int n) {
        int num = 0;
        if ((n & 1) == 1) {
            num++;
        }
        n = n >> 1;
        n = (n & 0x7fffffff);
        while (n != 0) {
            if ((n & 1) == 1) {
                num++;
            }
            n = n >> 1;
        }
        return num;
    }
}
