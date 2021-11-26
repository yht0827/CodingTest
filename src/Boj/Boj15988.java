package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj15988 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, max = 0;
    static int[] arr;
    static Long[] dp;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[i] = num;
            max = Math.max(max, num);
        }

        dp = new Long[max + 1];
        dp[1] = 1L;
        dp[2] = 2L;
        dp[3] = 4L;

        topDown(max);
        for (int i = 0; i < N; i++) System.out.println(dp[arr[i]]);
        // bottomUp();
    }

    private static long topDown(int num) {

        if (dp[num] == null) {
            dp[num] = (topDown(num - 3) + topDown(num - 2) + topDown(num - 1)) % 1000000009;
        }

        return dp[num];
    }

    private static void bottomUp() {
        for (int i = 4; i <= max; i++) dp[i] = (dp[i - 3] + dp[i - 2] + dp[i - 1]) % 1000000009;

        for (int i = 0; i < N; i++) sb.append(dp[arr[i]]).append("\n");

        System.out.println(sb);
    }

}
