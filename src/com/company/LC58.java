package com.company;

public class LC58 {
    public int lengthOfLastWord(String s) {

        if(!s.contains(" ")){
            return s.length();
        }


        int length =0;
        int state  = 0;
        for (int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)==' '){
                if (state==2){
                    return length;
                }
                state = 1;
            }
            else {
                state=2;
                length++;
            }

        }
        return length;

    }


}
