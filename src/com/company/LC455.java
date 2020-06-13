package com.company;

import java.util.Arrays;

public class LC455 {
//贪心思想分糖果 思考总是选局部最优解是不是全局最优
        public int findContentChildren(int[] g, int[] s) {
            int num = 0;
            Arrays.sort(g);
            Arrays.sort(s);
            int childPtr=0;
            for(int i = 0;i<s.length;i++){
                if(s[i]>=g[childPtr]){
                    num++;
                    childPtr++;

                }
                if(childPtr>g.length)
                    break;
            }
            return num;
        }





}
