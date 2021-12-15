package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj2623 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static StringBuilder sb = new StringBuilder();
    static List<List<Integer>> list;
    static int[] edgeCount;

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        edgeCount = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken()); // 가수의 수
            int be = Integer.parseInt(st.nextToken()); // 맨 처음 숫자
            // 가수들의 순서 정보 저장
            for (int j = 0; j < num - 1; j++) {
                int af = Integer.parseInt(st.nextToken());
                list.get(be).add(af);
                edgeCount[af]++;
                be = af;
            }
        }

        // 위상 정렬
        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 1; i < edgeCount.length; i++) {
            if (edgeCount[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            Integer poll = q.poll();
            sb.append(poll).append("\n");

            for (Integer integer : list.get(poll)) {
                if (--edgeCount[integer] == 0) {
                    q.offer(integer);
                }
            }
        }

        // 사이클 체크 (번호개수와 가수의 수가 다른경우)
        if (sb.toString().split("\n").length != N) {
            System.out.println(0);
        } else {
            System.out.println(sb);
        }
    }

}
