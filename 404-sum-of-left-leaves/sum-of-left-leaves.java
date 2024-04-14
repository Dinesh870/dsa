class Solution {
    // int sum(TreeNode root, boolean isLeft) {
    //     if(root == null) return 0;
    //     if(root.left == null && root.right == null && isLeft) {
    //         return root.val;
    //     }
    //     return sum(root.left,true) + sum(root.right,false);
    // }f
    int fun(TreeNode root) {
        if(root == null) return 0;

        int ans = 0;
        if(root.left != null) {
            if(root.left.left == null && root.left.right == null) ans += root.left.val;
            else ans += fun(root.left);
        }

        ans += fun(root.right);

        return ans;
    }
    public int sumOfLeftLeaves(TreeNode root) {
        // if(root.left == null && root.right == null) return 0;
        // boolean isLeft = true;
        // return sum(root,isLeft);

        // method 2:
        return fun(root);
    }
}