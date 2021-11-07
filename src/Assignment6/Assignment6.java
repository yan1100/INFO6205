package Assignment6;

import javax.swing.tree.TreeNode;
import java.util.*;

public class Assignment6 {
    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {}

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }



    public class Question1 {
        //Time Complexity: O(n)
        //Space Complexity: O(n)
        public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
            if (root1 == null) {
                return root2;
            }
            if (root2 == null) {
               return root1;
            }
            root1.val += root2.val;
            root1.left = mergeTrees(root1.left, root2.left);
            root1.right = mergeTrees(root1.right, root2.right);
            return root1;
        }
    }



    public class Question2 {
        //Time Complexity: O(n)
        //Space Complexity: O(n)
        public boolean leafSimilar(TreeNode root1, TreeNode root2) {
            ArrayList list1 = new ArrayList();
            ArrayList list2 = new ArrayList();
            postOrder(root1, list1);
            postOrder(root2, list2);
            return list1.equals(list2);
        }

        public boolean isLeaf(TreeNode root) {
            if (root.left == null && root.right == null) {
                return true;
            }
            return false;
        }

        public void postOrder(TreeNode root, ArrayList list) {
            if (root != null) {
                postOrder(root.left, list);
                postOrder(root.right, list);
                if (isLeaf(root)) {
                    list.add(root.val);
                }
            }
        }
    }



    public class Question3 {
        //Time Complexity: O(n)
        public boolean hasPathSum(TreeNode root, int targetSum) {
            if (root == null) {
                return false;
            }
            if (root.left == null && root.right == null && root.val == targetSum) {
                return true;
            }
            return hasPathSum(root.left, targetSum - root.val)
                    || hasPathSum(root.right, targetSum - root.val);
        }
    }



    public class Question4 {
        public boolean isBalanced(TreeNode root) {
            if (root == null) {
                return true;
            }
            int left = height(root.left);
            int right = height(root.right);
            return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }

        public int height(TreeNode root){
            if(root == null){
                return 0;
            }
            int left = height(root.left);
            int right = height(root.right);

            return 1 + Math.max(left, right);
        }
    }



    public class Question5 {
        public boolean isSubtree(TreeNode root, TreeNode subRoot) {
            if (root == null && subRoot == null) {
                return true;
            }
            if (root == null || subRoot == null) {
                return false;
            }
            return isSameTree(root,subRoot) || isSubtree(root.left, subRoot)
                    || isSubtree(root.right,subRoot);
        }

        public boolean isSameTree (TreeNode root, TreeNode subRoot) {
            if (root == null && subRoot == null) {
                return true;
            }
            if (root == null || subRoot == null) {
                return false;
            }
            return root.val == subRoot.val && isSameTree(root.left, subRoot.left)
                    && isSubtree(root.right, subRoot.right);
        }
    }


    public class Question6 {
        public boolean isSymmetric(TreeNode root) {
            return isSame(root,root);
        }

        public boolean isSame(TreeNode root1, TreeNode root2) {
            if (root1 == null && root2 == null) {
                return true;
            }
            if (root1 == null || root2 == null) {
                return false;
            }
            return root1.val == root2.val && isSame(root1.right, root2.left)
                    && isSame(root1.left, root2.right);
        }
    }


    public class Question7 {
        public void flatten(TreeNode root) {
            ArrayList<Integer> list = new ArrayList();
            preOrder(root, list);
            if (list.isEmpty()) {
                return;
            }
            root.val = list.get(0);
            for (int i = 1; i < list.size(); i++) {
                TreeNode root2 = new TreeNode(list.get(i));
                root.left = null;
                root.right = root2;
                root = root2;
            }
        }

        private void preOrder(TreeNode root, ArrayList list){
            if(root != null){
                list.add(root.val);
                preOrder(root.left, list);
                preOrder(root.right, list);
            }
        }
    }



    public class Question8 {
        public List<List<Integer>> verticalOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList();
            if (root == null) {
                return res;
            }
            Map<Integer, ArrayList> colMap = new HashMap<>();
            Queue<TreeNode> queue = new LinkedList<>();
            Map<TreeNode, Integer> numMap = new HashMap<>();
            queue.offer(root);
            numMap.put(root, 0);
            int min = 0;
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                int num = numMap.get(node);
                if (!colMap.containsKey(num)) {
                    colMap.put(num, new ArrayList());
                }
                colMap.get(num).add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                    numMap.put(node.left, num - 1);
                }
                if (node.right != null) {
                    queue.add(node.right);
                    numMap.put(node.right, num + 1);
                }
                min = Math.min(min, num);
            }
            while (colMap.containsKey(min)) {
                res.add(colMap.get(min++));
            }
            return res;
        }

    }
}
