package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj12865 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, K;
    static int[][] dp;
    static int W, V;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 물품의 수
        K = Integer.parseInt(st.nextToken()); // 무게 최대치
        dp = new int[N + 1][K + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken()); // 무게
            V = Integer.parseInt(st.nextToken()); // 가치
            for (int j = 1; j <= K; j++) {
                dp[i][j] = j < W ? dp[i - 1][j] : Math.max(dp[i - 1][j], V + dp[i - 1][j - W]);
            }
        }
        System.out.println(dp[N][K]);
    }
}
