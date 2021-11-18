package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj2230 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static int[] A;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N];

        for (int i = 0; i < N; i++) A[i] = Integer.parseInt(br.readLine());

        Arrays.sort(A);

        int left = 0, right = 0, result = Integer.MAX_VALUE;

        while (right < N) {
            int diff = Math.abs(A[left] - A[right]);

            if (diff < M) right++;
            else if (diff == M) {
                result = diff;
                break;
            } else {
                result = Math.min(result, diff);
                left++;
            }
        }

        System.out.println(result);
    }

}
