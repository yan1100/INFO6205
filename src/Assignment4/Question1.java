package Assignment4;

public class Question1 {
    //Time Complexity: O(1)
    //Space Complexity: O(1)

     //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
     }

    public void deleteNode(ListNode node) {
        ListNode temp = node.next;
        node.next = temp.next;
        node.val = temp.val;
    }
}
