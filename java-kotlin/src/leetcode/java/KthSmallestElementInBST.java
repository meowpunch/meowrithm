package leetcode.java;

import data.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class KthSmallestElementInBST {
    /*
        inorder : left -> root -> right
        following inorder traversal, we can get ordering elements in BST
     */
    public int kthSmallest(TreeNode root, int k) {
        return iterative(root, k);
    }

    private int recursive(TreeNode root, int k) {
        List<Integer> values = new ArrayList<>();
        traverse(root, values);
        // System.out.println(values);
        return values.get(k - 1);
    }

    // inorder way : left -> root -> right
    private void traverse(TreeNode root, List<Integer> acc) {
        // left
        if (root.getLeft() != null) traverse(root.getLeft(), acc);

        // root
        acc.add(root.getVal());

        if (root.getRight() != null) traverse(root.getRight(), acc);
    }


    /*
                        5
                    3       6
                2      4
            1

        stk [1 2 3 5]
        stk
     */
    private int iterative(TreeNode root, int k) {
        Stack<TreeNode> stk = new Stack<>();

        while(true) {
            // left
            while(root != null) {
                stk.push(root);
                root = root.getLeft();
            }

            root = stk.pop();
            k--;
            if(k == 0) return root.getVal();

            root = root.getRight();
        }
    }
}
