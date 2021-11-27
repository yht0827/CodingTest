package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1535 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[] L;
    static int[] J;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        L = new int[N + 1];
        J = new int[N + 1];
        dp = new int[101];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) L[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) J[i] = Integer.parseInt(st.nextToken());

        // bottomUp();
        System.out.println(topDown(1, 0, 100));
    }

    public static int topDown(int idx, int sum, int life) {
        if (idx > N) return sum;

        int res = 0;
        if (life - L[idx] > 0) {
            res = topDown(idx + 1, sum + J[idx], life - L[idx]);
        }

        return Math.max(res, topDown(idx + 1, sum, life));
    }

    public static void bottomUp() {

        for (int i = 1; i <= N; i++) {
            for (int j = 99; j >= 0; j--) {
                int ene = L[i] + j;
                if (ene < 100) {
                    dp[ene] = Math.max(dp[ene], dp[j] + J[i]);
                }
            }
        }
        System.out.println(dp[99]);
    }
}
