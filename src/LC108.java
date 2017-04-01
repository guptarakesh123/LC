/*
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 */
public class LC108 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        
        TreeNode(int x) {
            val = x;
        }
    }
    
    public static void main(String[] args) {
        
    }
    
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("null input not supported");
        }
        if (nums.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(nums[nums.length / 2]);
        
        buildTree(root, nums, 0, nums.length / 2 - 1);
        buildTree(root, nums, nums.length / 2 + 1, nums.length - 1);
        
        return root;
    }
    
    private void buildTree(TreeNode root, int[] nums, int start, int end) {
        if(end < start){
            return;
        }
        int mid = (start + end) / 2;
        TreeNode tn = new TreeNode(nums[mid]);
        if(nums[mid] < root.val){
            root.left = tn;
        } else {
            root.right = tn;
        }
        buildTree(tn, nums, start, mid - 1);
        buildTree(tn, nums, mid + 1, end);
    }
}
