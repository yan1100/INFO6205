package Assignemnt3;

import java.util.HashSet;
import java.util.Set;

public class Assignment3 {

    //Definition for singly-linked list (For all questions)
     public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) {
             this.val = val;
         }
         ListNode(int val, ListNode next) {
             this.val = val;
             this.next = next;
         }
     }


     public class Question1 {
         //headA length = m, headB length= n
         //Time: O(n+m)
         //Space:O(1)
         public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
             ListNode pointer1 = headA;
             ListNode pointer2 = headB;
             while (pointer1 != pointer2){
                 if (pointer1 != null){
                     pointer1 = pointer1.next;
                 }else {
                     pointer1 = headB;
                 }

                 if (pointer2 != null){
                     pointer2 = pointer2.next;
                 }else {
                     pointer2 = headA;
                 }
             }
             return pointer2;
         }
    }


    public class Question2 {
        //Time: O(n)
        //Space:O(1)
        public ListNode removeElements(ListNode head, int val) {
            ListNode dummyHead = new ListNode(0,head);
            ListNode current = head;
            ListNode previous = dummyHead;
            while (current != null){
                if (current.val == val){
                    previous.next = current.next;
                }else {
                    previous = previous.next;
                }
                current = current.next;
            }
            return dummyHead.next;
        }
    }


    public class Question3{
        //l1 length = m, headB length= n
        //Time: O(max(m,n)): if m > n, Time complexity = O(m); if m < n, Time complexity = O(n)
        //Space:O(max(m,n))
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode dummyHead = new ListNode(0);
            ListNode current = dummyHead;
            ListNode pointer1 = l1;
            ListNode pointer2 = l2;
            int carry = 0;
            while (pointer1 != null || pointer2 != null){
                int num1;
                int num2;
                if (pointer1 != null){
                    num1 = pointer1.val;
                }else {
                    num1 = 0;
                }
                if (pointer2 != null){
                    num2 = pointer2.val;
                }else {
                    num2 = 0;
                }
                int sum = num1 + num2 + carry;
                carry = sum / 10;
                current.next = new ListNode(sum % 10);
                current = current.next;
                if (pointer1 != null){
                    pointer1 = pointer1.next;
                }
                if (pointer2 != null){
                    pointer2 = pointer2.next;
                }
            }
            if (carry > 0) {
                current.next = new ListNode(carry);
            }
            return dummyHead.next;
        }
    }


    public class Question4 {
        //Time: O(n)
        //Space:O(1)
        public ListNode oddEvenList(ListNode head) {
            if (head == null){
                return null;
            }
            ListNode odd = head;
            ListNode even = head.next;
            ListNode evenHead = even;
            while (even != null && even.next !=null){
                odd.next = even.next;
                odd = odd.next;
                even.next = odd.next;
                even = even.next;
            }
            odd.next = evenHead;
            return head;
        }


    }

    public class Question5{
        //Time: O(n)
        //Space:O(1)
        public ListNode middleNode(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;
            while (fast != null && fast.next != null){
                fast = fast.next.next;
                slow = slow.next;;
            }
            return slow;
        }
     }


     public class Question6{
         //Time: O(n)
         //Space:O(n)
         public ListNode detectCycle(ListNode head) {
             Set<ListNode> set = new HashSet<>();
             ListNode pointer = head;
             while (pointer != null){
                 if (set.contains(pointer)){
                     return pointer;
                 }
                 set.add(pointer);
                 pointer = pointer.next;
             }
             return null;

         }
     }
}
