package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj14567 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static List<List<Integer>> list;
    static int[] edge, result;

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        edge = new int[N + 1];
        result = new int[N + 1];

        for (int i = 0; i < N + 1; i++) {
            list.add(new ArrayList<>());
        }

        Arrays.fill(result, 1);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            list.get(A).add(B);
            edge[B]++;
        }

        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            if (edge[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            Integer poll = q.poll();
            for (Integer integer : list.get(poll)) {
                // 진입 차수 간의 최대값 비교
                result[integer] = Math.max(result[poll] + 1, result[integer]);
                if (--edge[integer] == 0) {
                    q.offer(integer);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.print(result[i] + " ");
        }
    }

}
