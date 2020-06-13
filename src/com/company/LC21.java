package com.company;

import java.util.ArrayList;
import java.util.List;

public class LC21 {
//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        //归并两个链表 有序
//        ArrayList<ListNode> result = new ArrayList<>();
//        while(l1!=null&&l2!=null){
//            while(l1!=null&&l2!=null&&l1.val<l2.val){
//                result.add(l1);
//                l1 = l1.next;
//            }
//            if(l1==null||l2==null)
//                break;
//            result.add(l2);
//            l2 = l2.next;
//
//            if(l1==null||l2==null)
//                break;
//            while(l1!=null&&l2!=null&&l1.val>l2.val){
//                result.add(l2);
//                l2  = l2.next;
//            }
//            if(l1==null||l2==null)
//                break;
//            result.add(l1);
//            l1 =l1.next;
//        }
//        if(l1==null&&l2==null){
//
//        }else {
//            if(l1==null){
//                while(l2!=null){
//                    result.add(l2);
//                    l2 = l2.next;
//                }
//            }else {
//                if(l2==null){
//                    while(l1!=null){
//                        result.add(l1);
//                        l1=l1.next;
//                    }
//                }
//            }
//        }
//
//        for (int i = 0; i < result.size();i++) {
//            result.get(i).next = result.get(i+1);
//        }
//        result.get(result.size()-1).next=null;
//        return result.get(0);
//    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //理解java的特性，对象引用赋值是拷贝一份指针。
        ListNode result = new ListNode(0);
        ListNode ptr  = result;
        while(l1!=null&&l2!=null){
            if (l1.val < l2.val) {
                ptr.next = l1;
                l1 = l1.next;
                ptr = ptr.next;

            }else {
                ptr.next = l2;
                l2 = l2.next;
                ptr = ptr.next;
            }
        }
        if(l1==null&&l2==null){

        }else {
            if (l1==null){
                ptr.next= l2;
            }else {
                ptr.next = l1;
            }
        }
        return result.next;

    }
}
