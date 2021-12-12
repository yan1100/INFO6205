package Final;

public class Q2 {

    public static void main(String[] args) {
       Node a1 = new Node(10);
       Node a2 = new Node(7);
       Node a3 = new Node(15);
       Node a4 = new Node(9);
       Node a5 = new Node(11);
       a1.left = a2;
       a1.right = a3;
       a2.right = a4;
       a3.left = a5;
       System.out.println(isFoldable(a1));

        Node a6 = new Node(10);
        Node a7 = new Node(7);
        Node a8 = new Node(15);
        Node a9 = new Node(9);
        Node a10 = new Node(11);
        a6.left = a7;
        a7.right = a8;
        a8.left = a9;
        a9.left = a10;
        System.out.println(isFoldable(a6));

    }

    public static boolean isFoldable(Node root) {
        boolean ans;
        if (root == null) {
            return true;
        }
        mirror(root.left);
        ans = isSame(root.left, root.right);
        mirror(root.left);
        return ans;
    }

    public static boolean isSame(Node node1, Node node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 != null && node2 != null
                && isSame(node1.left, node2.left)
                && isSame(node1.right, node2.right)) {
            return true;
        }
        return false;
    }

    public static void mirror(Node node)
    {
        if (node == null)
            return;
        else {
            Node temp;

            mirror(node.left);
            mirror(node.right);

            temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
    }
}
