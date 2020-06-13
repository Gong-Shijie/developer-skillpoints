package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// 电话  数字键 上  字母  的  组合
//  解法  排列组合  dfs 搜索
public class LC17 {

    public List<String> letterCombinations(String digits) {
        HashMap<Character,String> getNumStr = new HashMap(){{
            put("2", "abc");
            put("3", "def");
            put("4", "ghi");
            put("5", "jkl");
            put("6", "mno");
            put("7", "pqrs");
            put("8", "tuv");
            put("9", "wxyz");
        }};
        ArrayList<String> result = new ArrayList<>();
        if(digits.length()!=0)
            dfs(result,"",getNumStr,digits);
                    return result;
    }

    private void dfs(ArrayList<String> result, String seq,HashMap<Character, String> getNumStr, String digits) {
        if(digits.length()==0){
            result.add(seq);
            return;
        }else {
            char temp =digits.charAt(0);
            String numStr = getNumStr.get(temp);
            for (int i = 0; i < numStr.length() ; i++) {
                dfs(result,seq+numStr.charAt(i),getNumStr,digits.substring(1));
            }

        }

    }

}
