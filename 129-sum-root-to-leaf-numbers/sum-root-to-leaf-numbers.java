/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int fun(TreeNode root, int sum) {
        if(root == null) {
            return 0;
        }

        if(root.left == null && root.right == null) return sum * 10 + root.val;

        sum = sum*10 + root.val;

        return fun(root.left, sum) + fun(root.right, sum);
    }

    public int sumNumbers(TreeNode root) {
        int[] sum = {0};

        return fun(root, 0);
    }
}