
public class LC019 {
    /**
     * Definition for singly-linked list.
     */
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode createList(int[] n) {

        if (n == null || n.length == 0) {
            return null;
        }
        ListNode root = new ListNode(n[0]);
        ListNode curr = root;
        for (int i = 1; i < n.length; i++) {
            curr.next = new ListNode(n[i]);
            curr = curr.next;
        }

        return root;
    }

    public static void printList(ListNode root) {
        if (root == null) {
            System.out.println("<empty>");
            return;
        }

        System.out.print(root.val);

        while (root.next != null) {
            System.out.print(" -> " + root.next.val);
            root = root.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = createList(new int[] { 1, 2, 3, 4, 5 });
        printList(head);

        head = new LC019().removeNthFromEnd(head, 0);
        printList(head);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n <= 0) {
            throw new IllegalArgumentException("null list or incorrect n");
        }
        ListNode h = head;
        ListNode t = h;
        for (int i = 0; i < n; i++) {
            t = t.next;
        }

        if (t == null) {
            return head.next;
        }
        while (t.next != null) {
            t = t.next;
            h = h.next;
        }
        h.next = h.next.next;
        return head;
    }
}
