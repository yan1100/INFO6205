package Assignment4;

public class Question5 {
    //Time Complexity: O(n)
    //Space Complexity: O(1)

    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode() { }

        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public int getDecimalValue(ListNode head) {
        int res = head.val;
        while (head.next != null) {
            res = res * 2 + head.next.val;
            head = head.next;
        }
        return res;
    }
}
