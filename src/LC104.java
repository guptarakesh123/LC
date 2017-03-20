

public class LC104 {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int d1 = maxDepth(root.left);
        int d2 = maxDepth(root.right);
        
        return Math.max(d1,  d2) + 1;
    }
}
