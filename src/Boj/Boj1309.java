package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj1309 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static long[][] arr;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        arr = new long[N][3];


        Arrays.fill(arr[0], 1);

        // 0: 둘다X, 1: 왼쪽, 2: 오른쪽
        for (int i = 1; i < N; i++) {
            arr[i][0] = (arr[i - 1][0] + arr[i - 1][1] + arr[i - 1][2]) % 9901;
            arr[i][1] = (arr[i - 1][0] + arr[i - 1][2]) % 9901;
            arr[i][2] = (arr[i - 1][0] + arr[i - 1][1]) % 9901;
        }

        System.out.println((arr[N - 1][0] + arr[N - 1][1] + arr[N - 1][2]) % 9901);
    }


}
