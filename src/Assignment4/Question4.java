package Assignment4;

public class Question4 {
    //Time Complexity: O(n)
    //Space Complexity: O(n)

     //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode() { }

        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val; this.next = next;
        }
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        int[] array = new int[right - left + 1];
        int index1 = 0;
        int index2 = array.length - 1;
        ListNode curr = head;
        for (int i = 1; i <= right; i++) {
            if (i >= left){
                array[index1] = curr.val;
                index1++;
            }
            curr = curr.next;
        }
        curr = head;
        for (int i = 1; i <= right; i++) {
            if (i >= left){
                curr.val = array[index2];
                index2--;
            }
            curr = curr.next;
        }
        return head;
    }
}
