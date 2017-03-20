
/*
 * Reverse a singly linked list.
 */
public class LC206 {
    public static void main(String[] args) {
        ListNode head = createList(new int[] { 1,3 });
        
        printList(head);
        
        ListNode r3 = new LC206().reverseList(head);
        printList(r3);
    }
    
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }
        if(head.next == null){
            return head;
        }
        ListNode prev = head;
        ListNode curr = head.next;
        ListNode next = curr.next;
        prev.next = null;
        
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    
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
            return;
        }
        System.out.print(root.val);
        while (root.next != null) {
            System.out.print(" --> " + root.next.val);
            root = root.next;
        }
        System.out.println();
    }
    
}
