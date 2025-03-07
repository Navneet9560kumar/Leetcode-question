
class Solution {
    public TreeNode helper(int[] preorder, int[] inorder, int prelo, int prehi, int inlo, int inhi) {
        if (prelo > prehi || inlo > inhi) return null;

        TreeNode root = new TreeNode(preorder[prelo]);

        int r = 0;
        while (inorder[r] != preorder[prelo]) r++; // Fix: `preNode` was incorrect

        int leftsize = r - inlo;

        root.left = helper(preorder, inorder, prelo + 1, prelo + leftsize, inlo, r - 1);
        root.right = helper(preorder, inorder, prelo + leftsize + 1, prehi, r + 1, inhi);

        return root;
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        int n = preorder.length;
        int[] inorder = Arrays.copyOf(preorder, n);
        Arrays.sort(inorder); // Construct inorder by sorting preorder

        return helper(preorder, inorder, 0, n - 1, 0, n - 1);
    }
}