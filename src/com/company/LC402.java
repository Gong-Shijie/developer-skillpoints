package com.company;

public class LC402 {
    public  static  String removeKdigits(String num, int k) {
        String temp = num;
        int kflag = 0;
        for(int i = 0;i<num.length()-1;i++){
            if(num.charAt(i)>num.charAt(i+1)){

                num = num.substring(0,i);
                num = num+temp.substring(i+1);
                System.out.println(num);
                kflag++;

                i = i-2;
                if(i<0){
                    i = -1;
                }

                if(kflag==k){
                    while(num.startsWith("0")){
                        num = num.substring(1);
                    }
                    return  num.equals("")?"0":num;
                }
            }
        }
        if(kflag!=k){
           num  =  num.substring(0,num.length()-(k-kflag));
        }

        while(num.startsWith("0")){
            num = num.substring(1);
        }
        return num.equals("")?"0":num;

    }
public static void main(String[] args) {
    String s = "4321"
    ;
    System.out.println(removeKdigits(s,2));

}
}
