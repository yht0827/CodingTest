package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2011 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] dp, arr;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        String N = st.nextToken();
        int len = N.length();

        dp = new int[len + 1];
        arr = new int[len + 1];
        dp[0] = 1;

        for (int i = 0; i < len; i++) arr[i + 1] = N.charAt(i) - '0';

        for (int i = 1; i <= len; i++) {
            if (arr[i] != 0) dp[i] = (dp[i] + dp[i - 1]) % 1000000;

            int num = arr[i - 1] * 10 + arr[i];

            if (10 <= num && num <= 26) dp[i] = (dp[i] + dp[i - 2]) % 1000000;
        }

        System.out.println(dp[len]);
    }

}
