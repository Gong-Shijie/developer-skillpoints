package com.company;

import java.util.List;

public class LC86 {
    public ListNode partition(ListNode head, int x) {
//        ListNode pre=new ListNode(0) ;
//        pre.next = head;
//        ListNode result=pre.next;
//        while(head!=null){
//            if(head.val<x){
//                pre =head;
//                head = head.next;
//            }else{
//                break;
//            }
//        }
//        while(head!=null){
//            if(head.val<x){
//                ListNode temp = pre.next;
//                pre.next = head;
//                head.next = temp;
//                pre = pre.next;
//                head = pre.next;
//            }else
//                head = head.next;
//        }
//        return result;
        ListNode left =new ListNode(0);
        ListNode leftPtr = left;
        ListNode right= new ListNode(0);
        ListNode rightPtr = right;
        while(head!=null){
            if(head.val<x){
                left.next = head;
                left = left.next;
            }else {
                right.next = head;
                right = right.next;
            }
            head = head.next;
        }
        right.next = null;
        left.next = rightPtr.next;
        return leftPtr.next;
    }
}
