package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj15990 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, max;
    static int[] arr;
    static long[][] dp = new long[100001][4];
    static StringBuilder sb = new StringBuilder();
    static final long MOD = 1000000009L;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        // bottomUp();

        for (int i = 1; i <= N; i++) {
            System.out.println((topDown(arr[i], 1) + topDown(arr[i], 2) + topDown(arr[i], 3)) % 1000000009L);
        }

    }

    public static long topDown(int num, int idx) {
        if (num == idx)
            return 1;
        if (num < idx)
            return 0;
        if (dp[num][idx] != 0)
            return dp[num][idx];

        long findOne = 0;
        long findTwo = 0;
        long findThree = 0;
        if (idx == 1) {
            findOne = (topDown(num - 1, 2) + topDown(num - 1, 3)) % 1000000009L;
        } else if (idx == 2) {
            findTwo = (topDown(num - 2, 1) + topDown(num - 2, 3)) % 1000000009L;
        } else if (idx == 3) {
            findThree = (topDown(num - 3, 1) + topDown(num - 3, 2)) % 1000000009L;
        }
        return dp[num][idx] = (findOne + findTwo + findThree) % 1000000009L;
    }

    public static void bottomUp() {
        dp[1][1] = dp[2][2] = dp[3][1] = dp[3][2] = dp[3][3] = 1;

        for (int i = 4; i <= max; i++) {
            dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % MOD;
            dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % MOD;
            dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % MOD;
        }

        for (int i = 1; i <= N; i++)
            sb.append((dp[arr[i]][1] + dp[arr[i]][2] + dp[arr[i]][3]) % MOD).append("\n");

        System.out.println(sb);
    }

}
