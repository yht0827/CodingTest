package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj10971 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, result = Integer.MAX_VALUE;
    static int[][] W;
    static boolean[] check;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        W = new int[N][N];
        check = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        check[0] = true;
        backTrack(0, 0, 0, 0);

        System.out.println(result);
    }

    public static void backTrack(int start, int now, int idx, int cost) {

        if (now == start && cost > 0) {
            result = Math.min(result, cost);
            return;
        }

        for (int i = 0; i < N; i++) {

            if (W[now][i] > 0) {

                if (i == start && idx == N - 1) {
                    cost += W[now][i];
                    backTrack(start, i, idx + 1, cost);

                } else if (!check[i]) {
                    check[i] = true;
                    cost += W[now][i];

                    backTrack(start, i, idx + 1, cost);

                    cost -= W[now][i];
                    check[i] = false;
                }

            }
        }

    }

}
