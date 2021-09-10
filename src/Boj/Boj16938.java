package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj16938 {

    static int N, L, R, X, answer;
    static int[] arr;
    static List<Integer> list = new LinkedList<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        backTrack(0, 0, new boolean[N]);

        System.out.println(answer);

    }

    private static void backTrack(int start, int index, boolean[] visited) {
        if (index > N) return;

        if (list.size() > 1) {
            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, sum = 0;

            for (int a : list) {
                min = Math.min(a, min);
                max = Math.max(a, max);
                sum += a;
            }
            if (max - min >= X && sum >= L && sum <= R) {
                answer++;
            }
        }

        for (int i = start; i < N; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            list.add(arr[i]);
            backTrack(i, index + 1, visited);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }
}
