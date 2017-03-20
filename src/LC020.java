
public class LC020 {
    private static class ListNode {
        int val;
        ListNode next;
        
        ListNode(int x) {
            val = x;
        }
    }
    
    private static ListNode createList(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        
        ListNode root = new ListNode(nums[0]);
        ListNode t = root;
        for (int i = 1; i < nums.length; i++) {
            t.next = new ListNode(nums[i]);
            t = t.next;
        }
        return root;
    }
    
    private static void printList(ListNode root) {
        if (root == null) {
            System.out.println("<empty>");
        }
        System.out.print(root.val);
        while (root.next != null) {
            System.out.print(" --> " + root.next.val);
            root = root.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        ListNode r1 = createList(new int[] { 1, 3, 5, 7 });
        ListNode r2 = createList(new int[] { 2, 4, 6, 8 });
        
        printList(r1);
        printList(r2);
        
        ListNode r3 = new LC020().mergeTwoLists(r1, r2);
        printList(r3);
    }
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        
        ListNode root;
        
        if (l1.val <= l2.val) {
            root = l1;
            l1 = l1.next;
        } else {
            root = l2;
            l2 = l2.next;
        }
        
        ListNode t = root;
        
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                t.next = l1;
                t = t.next;
                l1 = l1.next;
            } else {
                t.next = l2;
                t = t.next;
                l2 = l2.next;
            }
        }
        
        while (l1 != null) {
            t.next = l1;
            t = t.next;
            l1 = l1.next;
        }
        
        while (l2 != null) {
            t.next = l2;
            t = t.next;
            l2 = l2.next;
        }
        
        return root;
    }
}
