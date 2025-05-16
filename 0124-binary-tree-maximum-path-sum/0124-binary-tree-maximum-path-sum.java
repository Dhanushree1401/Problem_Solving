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
    private int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxsum(root);
        return res;
    }

    private int maxsum(TreeNode root) {
        if (root == null) return 0;

       int ls=maxsum(root.left);
       int rs=maxsum(root.right);

        int temp = Math.max(Math.max(ls,rs)+root.val,root.val);
        int max = Math.max(temp, ls + rs + root.val);

        res = Math.max(res, max);
        return temp;
    }
}