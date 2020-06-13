package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//利用hashmap 排序解决   次序问题
//arrays.toString() 不可以使用 应该使用String.valueOf
// new ArrayList(接受一个Collerction的对象来构造)
public class LC49 {
    public static void main(String[] args) {
        String [] test = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        for(List list :groupAnagrams(test)){
            System.out.println(list);
        }
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        char[] chars ;
        for(String string :strs){
            chars= string.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(string);

        }
        return new ArrayList<>(map.values());
    }
}
