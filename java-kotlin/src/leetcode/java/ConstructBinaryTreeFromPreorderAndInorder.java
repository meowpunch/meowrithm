package leetcode.java;

import data.TreeNode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class ConstructBinaryTreeFromPreorderAndInorder {
    /*
                    3
                9       20
                  7    8  13
                 1 2        5

        inorder: left -> root -> right  e.g. [9, 1, 7, 2, 3, 8, 20, 13, 5]
        preorder: root -> left -> right e.g. [3, 9, 20, 7, 8, 13, 1, 2, 5]


        root: preorder[0] => 3
        leftSubTree: [9, 1, 7, 2] rightSubTree: [8, 20, 13, 5]
        root 9                    root 20
        LST [] RST[1, 7, 2]       LST [8] RST [13, 5]
    */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(
                Arrays.stream(preorder).boxed().collect(Collectors.toList()),
                Arrays.stream(inorder).boxed().collect(Collectors.toList())
        );
    }

    private TreeNode buildTree(List<Integer> preorder, List<Integer> inorder) {
        // terminal
        if (preorder.isEmpty()) return null;
        else {
            final Integer root = preorder.get(0);
            final Integer rootIdx = inorder.indexOf(root);

            final List<Integer> leftInorder = inorder.subList(0, rootIdx);
            final List<Integer> leftPreorder = preorder.stream().filter(leftInorder::contains).collect(Collectors.toList());

            final List<Integer> rightInorder = inorder.subList(rootIdx + 1, preorder.size());
            final List<Integer> rightPreorder = preorder.stream().filter(rightInorder::contains).collect(Collectors.toList());

            return new TreeNode(
                    root,
                    buildTree(leftPreorder, leftInorder),
                    buildTree(rightPreorder, rightInorder)
            );
        }
    }
}
