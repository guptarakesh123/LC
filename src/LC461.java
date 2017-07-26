/*
The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Given two integers x and y, calculate the Hamming distance.

Note:
0 ≤ x, y < 231.

Example:

Input: x = 1, y = 4

Output: 2

Explanation:
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑

The above arrows point to positions where the corresponding bits are different.
 */
public class LC461 {
    public static void main(String[] args) {
        System.out.println(new LC461().hammingDistance(1, 15));
    }
    public int hammingDistance(int x, int y) {
        int n = x ^ y;
        int c = 0;
        for(int i = 0; i < 32; i++){
            c += (n & 1);
            n = (n >>> 1);
        }
        return c;
    }
}
