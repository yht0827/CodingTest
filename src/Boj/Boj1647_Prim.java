package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj1647_Prim {

    static class Info implements Comparable<Info> {

        int end, weight;

        public Info(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Info o) {
            return Integer.compare(weight, o.weight);
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static List<Info>[] list;
    static boolean[] check;

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        check = new boolean[N + 1];
        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Info(b, c));
            list[b].add(new Info(a, c));
        }

        int result = 0;
        int lastVal = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        Queue<Info> pq = new PriorityQueue<>();
        dq.offer(1);

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
                    lastVal = Math.max(lastVal, poll1.weight);
                    dq.offer(poll1.end);
                    break;
                }
            }
        }

        System.out.println(result - lastVal);
    }
}
