package Assignment4;

public class Question7 {
    //Time Complexity: O(n)
    //Space Complexity: O(1)

    //Definition for polynomial singly-linked list.
    class PolyNode {
        int coefficient, power;
        PolyNode next = null;

        PolyNode() {}
        PolyNode(int x, int y) {
            this.coefficient = x;
            this.power = y;
        }
        PolyNode(int x, int y, PolyNode next) {
            this.coefficient = x;
            this.power = y;
            this.next = next;
        }
    }

    public PolyNode addPoly(PolyNode poly1, PolyNode poly2) {
        PolyNode curr1 = poly1;
        PolyNode curr2 = poly2;
        PolyNode curr3 = new PolyNode(0,0);
        PolyNode head = curr3;
        while (curr1 != null && curr2 != null){
            PolyNode newPoly = new PolyNode();
            int coefficient;
            int power;
            if (curr1.power == curr2.power){
                coefficient = curr1.coefficient + curr2.coefficient;
                if (coefficient != 0){
                    newPoly.coefficient = coefficient;
                    newPoly.power = curr1.power;
                     curr3.next = newPoly;
                     curr3 = curr3.next;
                }
                curr1 = curr1.next;
                curr2 = curr2.next;
            }else if (curr1.power > curr2.power) {
                newPoly.coefficient = curr1.coefficient;
                newPoly.power = curr1.power;
                curr3.next = newPoly;
                curr3 = curr3.next;
                curr1 = curr1.next;
            }else {
                newPoly.coefficient = curr2.coefficient;
                newPoly.power = curr2.power;
                curr3.next = newPoly;
                curr3 = curr3.next;
                curr2 = curr2.next;
            }
        }
        if (curr1 != null){
            curr3.next = curr1;
        }
        if (curr2 != null){
            curr3.next = curr2;
        }
        return head.next;
    }

}
