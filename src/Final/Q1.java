package Final;
import Final.Node;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Q1 {

    public static void main(String[] args) {
        int[] inOrder=new int[]{1,2,3,4,5,6,7};
        int[] levelOrder=new int[]{4,2,5,1,6,3,7};
        Node root = build(levelOrder,inOrder);
        printTreeInOrder(root);
        System.out.println(" ");
        printTreeLevelOrder(root);

    }

    public static Map<Integer,Integer> map = new HashMap<>();
    
    public static Node build(int[] levelOrder, int[] inOrder){
        for (int i = 0; i < levelOrder.length; i++) {
            map.put(levelOrder[i],i);
        }
        Node root = createTree(levelOrder,inOrder,0,levelOrder.length);
        return root;
    }
    
    public static Node createTree(int[] levelOrder,int[] inOrder,int c,int e) {

        int min = levelOrder.length;
        int curr = c;
        for (int i = c; i < e; i++) {
            if (min > map.get(inOrder[i])) {
                min = map.get(inOrder[i]);
                curr = i;
            }
        }
        if (min == levelOrder.length) {
            return null;
        }
        Node n = new Node(levelOrder[min]);
        n.left = createTree(levelOrder, inOrder, c, curr);
        n.right = createTree(levelOrder, inOrder, curr + 1, e);
        return n;

    }

    public static void printTreeInOrder(Node root) {
        Node leftChild = root.left;
        Node rightChild = root.right;
        if (leftChild != null) {
            printTreeInOrder(leftChild);
        }
        System.out.print(root.value);
        if (rightChild != null) {
            printTreeInOrder(rightChild);
        }
    }

    public static void printTreeLevelOrder(Node root) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node current = queue.remove();
            System.out.print(current.value);
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

}
