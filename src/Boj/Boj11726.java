package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj11726 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int[] dp = new int[10001];

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] % 10007 + dp[i - 2] % 10007;
        }

        System.out.println(dp[n]%10007);
    }
}
