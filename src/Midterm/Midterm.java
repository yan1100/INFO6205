package Midterm;

import java.util.*;

public class Midterm {
    public static void main(String[] args) {
        //Q1 Test
        Q1 q1 = new Q1();
        int[] nums = new int[] {0,1,0,3,12};
        q1.moveZeroes(nums);
        System.out.println("Q1 Output: " + Arrays.toString(nums));

        //Q2 Test
        Q2 q2 = new Q2();
        int[] nums2 = new int[] {3,0,1};
        System.out.println("Q2 Output: " + q2.missingNumber(nums2));

        //Q3 Test
        Q3 q3 = new Q3();
        Q3.ListNode node1 = new Q3.ListNode(1);
        Q3.ListNode node2 = new Q3.ListNode(2);
        Q3.ListNode node3 = new Q3.ListNode(3);
        Q3.ListNode node4 = new Q3.ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        System.out.println("Q3 Output: " + q3.middleNode(node1).val);

        //Q4 Test
        Q4 q4 = new Q4();
        Q4.TreeNode treeNode1 = new Q4.TreeNode(1);
        Q4.TreeNode treeNode2 = new Q4.TreeNode(2);
        Q4.TreeNode treeNode3 = new Q4.TreeNode(3);
        Q4.TreeNode treeNode4 = new Q4.TreeNode(4);
        Q4.TreeNode treeNode5 = new Q4.TreeNode(5);
        Q4.TreeNode treeNode6 = new Q4.TreeNode(6);
        Q4.TreeNode treeNode7 = new Q4.TreeNode(7);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;
        System.out.print("Q4 Output: ");
        q4.printTreeNode(treeNode1);
    }
    public static class Q1 {
        public void moveZeroes(int[] nums) {
            int firstZero = -1;
            for (int i = 0; i < nums.length; i++) {
                if (firstZero == -1){
                    if (nums[i] == 0){
                        firstZero = i;
                    }
                }else if (nums[i] != 0){
                    nums[firstZero] = nums[i];
                    nums[i] = 0;
                    firstZero++;
                }
            }
        }
    }

    public static class Q2 {
        public int missingNumber(int[] nums) {
            Arrays.sort(nums);
            if (nums[0] != 0){
                return 0;
            }
            if (nums[nums.length - 1] != nums.length) {
                return nums.length;
            }
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != i) {
                    return i;
                }
            }
            return Integer.MIN_VALUE;
        }

    }

    public static class Q3 {
        //definition for ListNode
        static class ListNode {
            int val;
            ListNode next;

            public ListNode(int val) {
                this.val = val;
            }

            public ListNode(int val, ListNode next) {
                this.val = val;
                this.next = next;
            }
        }

        public ListNode middleNode(ListNode head) {
            ListNode current = head;
            int count = 0;
            while (current != null) {
                current = current.next;
                count++;
            }
            if (count % 2 != 0) {
                count /= 2;
                current = head;
                while (count > 0) {
                current = current.next;
                count--;
                }
            }else {
                count /= 2;
                current = head;
                while (count > 1) {
                    current = current.next;
                    count--;
                }
            }

            return current;
        }
    }

    public static class Q4 {
        //definition for TreeNote
        static class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;
            public TreeNode(int val) {
                this.val = val;
            }
        }

        public void printTreeNode(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            if (root != null) {
                traverseInOrder(root,list);
            }
            Collections.sort(list);
            for (int i : list) {
                System.out.print(i + ", ");
            }
        }

        private void traverseInOrder(TreeNode root, List<Integer> list) {
            TreeNode leftChild = root.left;
            TreeNode rightChild = root.right;
            list.add(root.val);
            if (leftChild != null) {
                traverseInOrder(leftChild,list);
            }
            if (rightChild != null) {
                traverseInOrder(rightChild,list);
            }
        }
    }
}
