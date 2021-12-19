package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj4386_Prim {

    static class Info implements Comparable<Info> {
        int end;
        double weight;

        public Info(int end, double weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Info o) {
            return Double.compare(weight, o.weight);
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static double[][] cor;
    static List<Info>[] list;
    static boolean[] check;

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());
        cor = new double[n + 1][2];

        list = new ArrayList[n + 1];
        check = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            cor[i][0] = x;
            cor[i][1] = y;
        }

        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                double res = Math.sqrt(Math.pow(Math.abs(cor[i][0] - cor[j][0]), 2) + Math.pow(Math.abs(cor[i][1] - cor[j][1]), 2));
                list[i].add(new Info(j, res));
                list[j].add(new Info(i, res));
            }
        }

        Deque<Integer> dq = new ArrayDeque<>();
        Queue<Info> pq = new PriorityQueue<>();
        dq.offer(1);
        double result = 0;

        while (!dq.isEmpty()) {
            Integer poll = dq.poll();
            check[poll] = true;

            for (Info info : list[poll]) {
                if (!check[info.end]) {
                    pq.offer(new Info(info.end, info.weight));
                }
            }

            while (!pq.isEmpty()) {
                Info poll1 = pq.poll();

                if (!check[poll1.end]) {
                    check[poll1.end] = true;
                    result += poll1.weight;
                    dq.offer(poll1.end);
                    break;
                }
            }
        }
        System.out.printf("%.2f%n", result);
    }

}
