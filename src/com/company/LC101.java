package com.company;

public class LC101 {
    public static void main(String[] args) {
        TreeNode t = new TreeNode(1);
        TreeNode t1 = new TreeNode(2);
        TreeNode t4 = new TreeNode(2);
        TreeNode t5 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        t.left = t1;
        t1.left = t4;
        t.right = t2;
        t2.right = t5;


        System.out.println(isSymmetric(t));
    }
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public static  boolean isSymmetric(TreeNode root) {
        if(root ==null)
            return true;
        if(root.left==null&&root.right==null)
            return true;
        if(root.left!=null&&root.right!=null){
           return jude(root.left, root.right);
        }else {
            return false;
        }
    }
    public  static  boolean jude(TreeNode left,TreeNode right){
//        只要不为null的值调用left和right都没事即使它left和right可能为null
//        只需要判断为null即可不要牵涉到子树否则逻辑会很复杂
        if(left==null&&right==null){
            return true;
        }
        if(left==null||right==null){
            return false;
        }
        if(left.val == right.val){
            return jude(left.right,right.left)&&jude(left.left,right.right);
        }else {
            return false;
        }

    }

}
