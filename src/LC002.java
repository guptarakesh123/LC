
public class LC002 {
    public static class ListNode {
        int val;
        ListNode next;
        
        ListNode(int x) {
            val = x;
        }
    }
    public static void main(String[] args) {
        ListNode a = new ListNode(2);
        a.next = new ListNode(4);
        a.next.next = new ListNode(3);
        
        ListNode b = new ListNode(5);
        b.next = new ListNode(6);
        b.next.next = new ListNode(4);
        
        ListNode c = new LC002().addTwoNumbers(a, b);
        print(c);
    }
    private static void print(ListNode c) {
        while(c != null){
            System.out.print(c.val);
            if(c.next != null){
                System.out.print(" --> ");
            }
            c = c.next;
        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carryover = 0;
        ListNode op = null, lastUnit = null;
        while(l1 != null && l2 != null){
            int current = l1.val + l2.val + carryover;
            int currentUnit = current % 10;
            carryover = current / 10;
            
            if(op == null){
                op = new ListNode(currentUnit);
                lastUnit = op;
            } else {
                lastUnit.next = new ListNode(currentUnit);
                lastUnit = lastUnit.next;
            }
            
            l1 = l1.next;
            l2 = l2.next;
        }
        
        while(l1 != null){
            int current = l1.val + carryover;
            int currentUnit = current % 10;
            carryover = current / 10;
            
            if(op == null){
                op = new ListNode(currentUnit);
                lastUnit = op;
            } else {
                lastUnit.next = new ListNode(currentUnit);
                lastUnit = lastUnit.next;
            }
            
            l1 = l1.next;
        }
        
        while(l2 != null){
            int current = l2.val + carryover;
            int currentUnit = current % 10;
            carryover = current / 10;
            
            if(op == null){
                op = new ListNode(currentUnit);
                lastUnit = op;
            } else {
                lastUnit.next = new ListNode(currentUnit);
                lastUnit = lastUnit.next;
            }
            
            l2 = l2.next;
        }
        
        if(carryover != 0){
            if(op == null){
                op = new ListNode(carryover);
                lastUnit = op;
            } else {
                lastUnit.next = new ListNode(carryover);
                lastUnit = lastUnit.next;
            }
        }
        
        return op;
    }
}
