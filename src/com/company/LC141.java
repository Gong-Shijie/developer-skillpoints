package com.company;


import java.util.ArrayList;
import java.util.Set;

public class LC141 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        //使用arrayList就可以使用contains
//        ArrayList<ListNode> listNodes = new ArrayList<>();
//        while(head!=null){
//            listNodes.add(head);
//            if(listNodes.contains(head)){
//                return true;
//            }
//            if(head!=null)
//            head = head.next;
//        }
//        return false;


        //快指针 每次经过慢指针flag加1，当二次路过慢指针证明必有环存在。
        int    flag = 0;
        ListNode fptr=head;
        ListNode sptr= head ;
        while (head!= null) {
            sptr= sptr.next;
            if(sptr==fptr&&fptr!=null)
                if(flag==2){
                    return true;
                }else{
                    flag++;
                }
            if(fptr!=null)
                fptr=fptr.next;

            if(sptr==fptr&&fptr!=null)
                if(flag==2){
                    return true;
                }else{
                    flag++;
                }
            if(fptr!=null)
                fptr=fptr.next;

            if(sptr==fptr&&fptr!=null)
                if(flag==2){
                    return true;
                }else{
                    flag++;
                }

            head = fptr;
        }
        return false;
    }
}
