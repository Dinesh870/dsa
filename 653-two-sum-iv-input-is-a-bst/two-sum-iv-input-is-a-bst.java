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
    void helper(TreeNode root, List<Integer> list) {
        if(root == null) return;

        helper(root.left, list);
        list.add(root.val);
        helper(root.right, list);
    }

    boolean linearSearch(List<Integer> list, int k) {
        int st = 0, end = list.size()-1;

        while(st < end) {
            int sum = list.get(st) + list.get(end);
            if(sum == k) return true;
            else if(sum > k) end--;
            else st++;
        }
        return false;
    }
    public boolean findTarget(TreeNode root, int k) {
        // method 1:
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        if(list.size() == 1) {
            return false;
        }

        
        return linearSearch(list, k);
    }
}