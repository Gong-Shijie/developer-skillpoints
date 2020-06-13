package com.company;

public class LC88 {
//    System.arraycopy();api 的使用
    // 数组问题  就是归并的过程  双指针
    //归并的时候需要额外的数组空间然后利用两个指针来依次遍历比较最后处理没有比较完的即可
    //避免使用额外空间也可以 从结尾开始到开头，这样可以节约空间
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0, k = 0;
        int[] result = new int[nums1.length];
        while (k < n && i < m) {
            if (nums1[i] > nums2[k]) {
                result[j] = nums2[k];
                j++;
                k++;
            } else {
                result[j] = nums1[i];
                i++;
                j++;
            }
        }
        if(k!=n-1){
            for (; k <n ; k++) {
                result[j] = nums2[k];
                j++;
            }
        }else {
            for (;i<m;i++){
                result[j] = nums1[m];
                j++;
            }
        }

        for (int r = 0; r < result.length; r++) {
            nums1[r] = result[r];
        }

    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int r = nums1.length-1,i=m-1,j=n-1;
        while(i>=0&&j>=0&&r>=0){
            if(nums1[i]>nums2[j]){
                nums1[r] = nums2[j];
                j--;
                r--;
            }else {
                nums1[r] = nums1[i];
                i--;
                r--;
            }
        }
        while(i!=0){
            nums1[r]=nums1[i];
            i--;
            r--;
        }
        while(j!=0){
            nums1[r] = nums2[j];
            j--;
            r--;
        }
    }
}
