package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj10159 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        arr = new int[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x][y] = 1;
            arr[y][x] = -1;
        }

        for (int j = 1; j <= N; j++) {
            for (int i = 1; i <= N; i++) {
                if (i == j) continue;
                for (int k = 1; k <= N; k++) {
                    if (i == k || j == k) continue;
                    if (arr[i][j] > 0 && arr[j][k] > 0) {
                        arr[i][k] = 1;
                        arr[k][i] = -1;
                    }
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            int cnt = 0;
            for (int j = 1; j <= N; j++) {
                if (i == j) continue;
                if (arr[i][j] == 0) cnt++;
            }
            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }
}
