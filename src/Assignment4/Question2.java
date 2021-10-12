package Assignment4;

public class Question2 {
    //Time Complexity: O(n)
    //Space Complexity: O(1)

    // Definition for a Node.
    class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }

    public Node insert(Node head, int insertVal) {
        Node newNode = new Node(insertVal);
        //if the list is empty
        if (head == null){
            newNode.next =newNode;
            return newNode;
        }
        //find the smallest node
        Node p1 = head;
        Node p2 = head.next;
        Node smallest = null;
        Boolean isFirst = true;
        while (p1 != head || isFirst != false) {
            if (p1.val > p2.val){
                smallest = p2;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
            isFirst = false;
        }

        if (smallest != null){
            Node p3 = smallest;
            while (p3.next != smallest){
                if (p3.val <= insertVal && p3.next.val >= insertVal){
                    newNode.next = p3.next;
                    p3.next = newNode;
                    return head;
                }
                p3 = p3.next;
            }
            newNode.next = p3.next;
            p3.next = newNode;
            return head;
        }

        newNode.next = head.next;
        head.next = newNode;
        return head;
    }
}
