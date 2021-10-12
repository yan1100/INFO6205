package Assignment4;

import java.util.LinkedList;

public class Question3 {
    class MyCircularDeque {
        class Node{
            int val;
            Node prev;
            Node next;

            public Node(int val) {
                this.val = val;
            }

            public Node getPrev() {
                return prev;
            }

            public void setPrev(Node prev) {
                this.prev = prev;
            }

            public Node getNext() {
                return next;
            }

            public void setNext(Node next) {
                this.next = next;
            }
        }

        Node head;
        Node tail;
        int complexity;
        int size;

        public MyCircularDeque(int k) {
            complexity = k;
            size = 0;
        }

        public boolean insertFront(int value) {
            if (size < complexity){
                Node node = new Node(value);
                if (head == null){
                    tail = node;
                }else {
                    head.setPrev(node);
                    node.setNext(head);
                }
                head = node;
                size++;
                return true;
            }
            return false;
        }

        public boolean insertLast(int value) {
            if (size < complexity){
                Node node = new Node(value);
                if (tail == null){
                    head = node;
                }else {
                    tail.setNext(node);
                    node.setPrev(tail);
                }
                tail = node;
                size++;
                return true;
            }
            return false;
        }

        public boolean deleteFront() {
            if (size > 0) {
                if (head.getNext() == null){
                    tail = null;
                }else {
                    head.getNext().setPrev(null);
                }
                head = head.getNext();
                size--;
                return true;
            }
            return false;
        }

        public boolean deleteLast() {
            if (size > 0) {
                if (tail.getPrev() == null){
                    head = null;
                }else {
                    tail.getPrev().setNext(null);
                }
                tail = tail.getPrev();
                size--;
                return true;
            }
            return false;
        }

        public int getFront() {
            if (size > 0) {
                return head.val;
            }
            return -1;
        }

        public int getRear() {
            if (size > 0) {
                return tail.val;
            }
            return -1;
        }

        public boolean isEmpty() {
            if (size == 0){
                return true;
            }
            return false;
        }

        public boolean isFull() {
            if (size == complexity){
                return true;
            }
            return false;
        }
    }
}
