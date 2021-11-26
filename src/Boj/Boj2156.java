package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj2156 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[] dp = new int[10001];
    static int[] arr = new int[10001];

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) dp[i] = Integer.parseInt(br.readLine());

        arr[0] = 0;
        arr[1] = dp[1];
        arr[2] = Math.max(dp[0] + dp[1], dp[1] + dp[2]);

        for (int i = 3; i <= N; i++)
            arr[i] = Math.max(arr[i - 1], Math.max(arr[i - 3] + dp[i - 1] + dp[i], arr[i - 2] + dp[i]));

        System.out.println(arr[N]);
    }
}
