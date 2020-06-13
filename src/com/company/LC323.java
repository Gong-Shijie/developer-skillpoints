package com.company;

public class LC323 {
    public static void main(String[] args) {

        int [] test={9};

        for (int i:plusOne(test)){

            System.out.println(i);
        }
    }
    public static  int[] plusOne(int[] digits) {


     return   plusOn(digits.length-1,digits,0);
    }
    public static int[] plusOn(int i,int[] digits,int jWei){

        if (i<0){
            int[] array=new int[digits.length+1];
            array[0]=1;

            digits = array;
            return digits;
        }
            if (digits[i]+1<10){
                digits[i]++;
                return digits;
            }
            else {
                digits[i] = 0;
               return plusOn(i-1,digits,1);
            }


    }


}
