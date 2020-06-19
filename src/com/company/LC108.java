package com.company;
// 有序数组构造 平衡二叉搜索树
// 平衡二叉搜索树 始终取中间数作为根，左区间构造左子树 右区间构造右子数
// 其实是分治的思路   左右区间进行树的构造

public  class LC108 {
   private static int[] nums;
    public static void main(String[] args) {
        int[] test ={-10,-3,0,5,9};
        sortedArrayToBST(test);

    }
    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){this.val = val;}

    }


    private static TreeNode sortedArrayToBST(int[] nums) {
       LC108.nums = nums;
        return dfs(0,nums.length-1);
    }

    private static TreeNode dfs(int l, int r) {
        if(l>r){
            return null;
        }
        if(l==r){
            return new TreeNode(nums[l]);
        }
        TreeNode treeNode = new TreeNode(nums[(l+r)/2]);
        treeNode.left = dfs(l,(l+r)/2-1);
        treeNode.right = dfs((l+r)/2+1,r);
        return treeNode;
    }
}
