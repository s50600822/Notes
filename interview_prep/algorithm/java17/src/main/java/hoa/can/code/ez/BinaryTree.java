package hoa.can.code.ez;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {
    public List<Integer> inorderTraversal(TreeNode root) {
        return inorderTraversal(root, new ArrayList<>());
    }

    public List<Integer> inorderTraversal(TreeNode root, List<Integer> res) {
        if (root == null) return res;
        if (root.left == null && root.right == null) {
            res.add(root.val);
        } else {
            if (root.left != null) {
                inorderTraversal(root.left, res);
            }
            res.add(root.val);
            if (root.right != null) {
                inorderTraversal(root.right, res);
            }
        }
        return res;
    }

    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        int l = height(root.left);
        int r = height(root.right);
        return Math.abs(l-r) <=1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int height(TreeNode tree) {
        if (tree == null) return 0;
        int l = height(tree.left);
        int r = height(tree.right);
        return Math.max(l, r) + 1;
    }

    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
