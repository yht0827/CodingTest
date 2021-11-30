package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj16926 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] arr;
    static int N, M, R, count;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        count = Math.min(N, M) / 2;

        for (int i = 0; i < R; i++)
            rotate();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void rotate() {

        for (int k = 0; k < count; k++) {
            // 외곽 돌리기
            int temp = arr[k][k];

            for (int i = k + 1; i < M - k; i++)
                arr[k][i - 1] = arr[k][i];

            for (int i = k + 1; i < N - k; i++)
                arr[i - 1][M - 1 - k] = arr[i][M - 1 - k];


            for (int i = M - 2 - k; i >= k; i--)
                arr[N - 1 - k][i + 1] = arr[N - 1 - k][i];

            for (int i = N - 2 - k; i >= k; i--)
                arr[i + 1][k] = arr[i][k];

            arr[k + 1][k] = temp;
        }
    }
}
