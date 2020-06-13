package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class LC688 {
    static class Step {
        int x;
        int y;
        int count;

        public Step(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    public static double knightProbability( int N, int K, int r, int c) {
        double in = 0;
        System.out.println((Math.pow(8.0,K)));
        int[] x = new int[]{2, 2, 1, 1, -1, -1, -2, -2};
        int[] y = new int[]{1, -1, 2, -2, -2, 2, -1, 1};
        Queue<Step> queue = new LinkedList<>();
        Step step = new Step(r, c, 0);
        queue.add(step);
        while (!queue.isEmpty()) {
            Step stepTemp = queue.poll();
            for (int i = 0; i < 8; i++) {

                if ((stepTemp.x + x[i] >= 0) &&(stepTemp.x + x[i] < N)  &&(stepTemp.y + y[i] >= 0)  &&
                        (stepTemp.y + y[i] < N)) {
                    if (stepTemp.count + 1 == K) {
                        in = in + 1;


                    } else {

                        queue.add(new Step(stepTemp.x + x[i], stepTemp.y + y[i], stepTemp.count + 1));

                    }
                }

            }
        }

        return in /(Math.pow(8.0,K));
    }

    public static void main(String[] args) {
        System.out.println(knightProbability(8,30,6,4));

    }
}
