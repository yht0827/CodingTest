package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj1766 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static List<List<Integer>> list;
    static int[] cnt;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        cnt = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            cnt[b]++;
        }

        Queue<Integer> q = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) {
            if (cnt[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            Integer poll = q.poll();
            sb.append(poll).append(" ");

            for (Integer integer : list.get(poll)) {

                if (--cnt[integer] == 0) {
                    q.offer(integer);
                }
            }

        }

        System.out.println(sb);
    }

}
