package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj9663 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N; // (1 ≤ N < 15)
    static int result;
    static int[] col;

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            col = new int[N];
            col[0] = i;
            dfs(0);
        }
        System.out.println(result);
    }

    public static void dfs(int row) {
        if (row == N - 1) {
            result++;
        } else {
            for (int i = 0; i < N; i++) {
                col[row + 1] = i;
                if (possible(row + 1)) {
                    dfs(row + 1);
                }
            }
        }
    }

    public static boolean possible(int row) {
        for (int i = 0; i < row; i++) {
            if (col[i] == col[row]) {
                return false;
            }
            if (Math.abs(col[i] - col[row]) == Math.abs(i - row)) {
                return false;
            }
        }
        return true;
    }

}
