package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj15649 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] arr = new int[M];
        boolean[] visited = new boolean[N];

        backTracking(0, 0, arr, visited);
    }

    private static void backTracking(int idx, int cnt, int[] arr, boolean[] visited) {

        if (cnt == M) {
            print(arr);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;

            arr[idx] = i + 1;
            visited[i] = true;
            backTracking(idx + 1, cnt + 1, arr, visited);
            visited[i] = false;
        }
    }

    private static void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }


}
