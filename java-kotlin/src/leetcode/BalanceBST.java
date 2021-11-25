package leetcode;

import data.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BalanceBST {
    /*
       1. Through inorder search, get a sorted list of nodes in ascending order.
       2. Build balanced tree with list
           2-1. pick a middle node in the list.
           2-2 build left subtree of the middle node with nodes before the middle node in the list.
           2-3 build right subtree of the middle node with nodes after the middle node in the list.

       Example

       1, 2, 3, 4, 5, 6, 7

       buildTree(1, 2, 3, 4, 5, 6, 7)

       4 is the root node of the tree.

       call buildTree(1, 2, 3) and buildTree(5, 6, 7)

       connect left and right subtree with return values.

    */
    public TreeNode balanceBST(TreeNode root) {
        List<TreeNode> ascendingOrderNodes = inorderSearchTree(root);

        TreeNode rootNodeOfBalancedTree = buildTree(ascendingOrderNodes);

        return rootNodeOfBalancedTree;
    }


    private TreeNode buildTree(List<TreeNode> ascendingOrderNodeList) {
        final Integer numberOfNodes = ascendingOrderNodeList.size();
        // handle null
        if (numberOfNodes == 0) return null;

        // pick a middle node. (ceil)
        final Integer middleIndex = (numberOfNodes - 1) / 2;
        final TreeNode root = ascendingOrderNodeList.get(middleIndex);

        // build left subTree
        root.setLeft(buildTree(ascendingOrderNodeList.subList(0, middleIndex)));

        // build right subTree
        root.setRight(buildTree(ascendingOrderNodeList.subList(middleIndex + 1, numberOfNodes)));

        return root;
    }

    /*
        left -> root -> right

        return ascendingOrderNodeList
    */
    private List<TreeNode> inorderSearchTree(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();

        // handle null
        if (root == null) return result;

        // left
        if (root.getLeft() != null) result.addAll(inorderSearchTree(root.getLeft()));

        // root
        result.add(root);

        // right
        if (root.getRight() != null) result.addAll(inorderSearchTree(root.getRight()));

        return result;
    }
}
