package com.company;

public class LC290 {
    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog dog dog dog"));
    }

    public static boolean wordPattern(String pattern, String str) {
        String[] map = new String['z' - 'a' + 1];
        String[] strEle = str.split(" ");
            if(pattern.length()<strEle.length)
                return false;
        for (int i = 0; i < strEle.length; i++) {
            if (map[pattern.charAt(i)-'a'] == null){
                for (int j = 0; j < map.length; j++) {
                    if(map[j]==null)
                        break;
                    if(map[j].equals(strEle[i]))
                        return false;
                }
                map[pattern.charAt(i)-'a'] = strEle[i];
            }else {
                if (map[pattern.charAt(i) - 'a'].equals(strEle[i])) {
                }else {
                    return false;
                }
            }
        }

        return true;
    }
}
