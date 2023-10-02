package hoa.can.code;

import hoa.can.code.ez.BinaryTree;
import hoa.can.code.ez.TreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BinaryTreeTest {

    @Test
    @DisplayName("https://leetcode.com/problems/balanced-binary-tree/")
    public void test1() {
        TreeNode t = new TreeNode(2);
        t.left = new TreeNode(1);

        assertTrue(new BinaryTree().isBalanced(t));
    }

    @Test
    @DisplayName("https://leetcode.com/problems/invert-binary-tree/")
    public void test2() {
        invert1();
        invert2();
    }

    void invert1(){
        TreeNode t = new TreeNode(2);
        t.left = new TreeNode(1);

        t = new BinaryTree().invertTree(t);

        assertTrue(t.val == 2);
        assertNull(t.left);
        assertTrue(t.right.val == 1);
    }
    public void invert2() {
        TreeNode t = new TreeNode(2);
        t.left = new TreeNode(1);
        t.right = new TreeNode(3);

        t = new BinaryTree().invertTree(t);

        assertTrue(t.val == 2);
        assertTrue(t.right.val == 1);
        assertTrue(t.left.val == 3);
    }
}
