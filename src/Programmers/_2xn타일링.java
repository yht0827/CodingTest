package Programmers;

public class _2xn타일링 {

    public static void main(String[] args) {
        int n = 4;
        System.out.println(solution(n));
    }

    private static final int MOD = 1_000_000_007;

    private static int solution(int n) {
        int[] dp = new int[60001];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        for (int i = 4; i <= 60000; i++) {
            dp[i] = (dp[i - 1] % MOD + dp[i - 2] % MOD) % MOD;
        }
        return dp[n];
    }

}
