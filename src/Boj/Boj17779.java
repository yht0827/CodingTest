package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj17779 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[][] A;
    static int allSum = 0;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        A = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
                allSum += A[i][j];
            }
        }

        setArea();
        System.out.println(result);
    }

    // 구역 설정
    public static void setArea() {

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                for (int d1 = 1; d1 < N; d1++) {
                    for (int d2 = 1; d2 < N; d2++) {
                        if (x + d1 + d2 >= N) continue;
                        if (y - d1 < 0 || y + d2 >= N) continue;

                        divideArea(x, y, d1, d2);
                    }
                }
            }
        }
    }

    // 구역 지정
    public static void divideArea(int x, int y, int d1, int d2) {

        // 영역 설정
        boolean[][] checkArea = new boolean[N][N];

        for (int i = 0; i <= d1; i++) {
            checkArea[x + i][y - i] = true;
            checkArea[x + d2 + i][y + d2 - i] = true;
        }

        for (int i = 0; i <= d2; i++) {
            checkArea[x + i][y + i] = true;
            checkArea[x + d1 + i][y - d1 + i] = true;
        }

        int[] sum = new int[5];
        // 1번
        for (int i = 0; i < x + d1; i++) {
            for (int j = 0; j <= y; j++) {
                if (checkArea[i][j]) break;
                sum[0] += A[i][j];
            }
        }

        // 2번
        for (int i = 0; i <= x + d2; i++) {
            for (int j = N - 1; j > y; j--) {
                if (checkArea[i][j]) break;
                sum[1] += A[i][j];
            }
        }

        // 3번
        for (int i = x + d1; i < N; i++) {
            for (int j = 0; j < y - d1 + d2; j++) {
                if (checkArea[i][j]) break;
                sum[2] += A[i][j];
            }
        }

        // 4번
        for (int i = x + d2 + 1; i < N; i++) {
            for (int j = N - 1; j >= y - d1 + d2; j--) {
                if (checkArea[i][j]) break;
                sum[3] += A[i][j];
            }
        }

        // 5번
        sum[4] = allSum - sum[0] - sum[1] - sum[2] - sum[3];

        Arrays.sort(sum);
        result = Math.min(sum[4] - sum[0], result);
    }

}
