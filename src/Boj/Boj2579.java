package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2579 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int stairCount;
    static int[] stair = new int[301], sum = new int[301]; // 첫번째 계단만 있는 경우 (ArrayIndexOutOfBounds) 예외처리 대신 인덱스를 고정 시켜서 사용

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        stairCount = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= stairCount; i++) {
            st = new StringTokenizer(br.readLine());
            stair[i] = Integer.parseInt(st.nextToken());
        }

        sum[1] = stair[1]; // 첫번째 계단
        sum[2] = stair[1] + stair[2]; // 두번째 계단

        // 세번째 계단 부터 DP
        for (int i = 3; i <= stairCount; i++) {
            sum[i] = Math.max(stair[i] + sum[i - 2], stair[i - 1] + stair[i] + sum[i - 3]);
        }

        System.out.println(sum[stairCount]);
    }

}
