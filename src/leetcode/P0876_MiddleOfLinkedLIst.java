public class P0876_MiddleOfLinkedLIst {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    public static void print(ListNode node) {
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static void main(String[] args) {
        P0876_MiddleOfLinkedLIst mll = new P0876_MiddleOfLinkedLIst();
        ListNode head = null;

        for (int i = 1; i > 0; i--) {
            head = new ListNode(i, head);
        }

        mll.middleNode(head);
    }

}
