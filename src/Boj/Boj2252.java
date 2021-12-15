package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj2252 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static int[] edge;
    static List<List<Integer>> list;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            list.add(new ArrayList<>());
        }
        edge = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.get(start).add(end);
            edge[end]++;
        }

        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            if (edge[i] == 0) q.offer(i);
        }

        while (!q.isEmpty()) {
            Integer poll = q.poll();
            sb.append(poll).append(" ");

            for (Integer integer : list.get(poll)) {
                if (--edge[integer] == 0) {
                    q.offer(integer);
                }
            }
        }
        System.out.println(sb);
    }
}
