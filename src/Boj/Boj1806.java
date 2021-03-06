package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1806 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, S;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0, right = 0, sum = 0, length = Integer.MAX_VALUE;

        while (true) {
            if (sum < S) {
                sum += arr[right++];
            } else if (right == N) break;
            else {
                sum -= arr[left];
                length = Math.min(length, right - left++);
            }
        }

        System.out.println(length == Integer.MAX_VALUE ? 0 : length);
    }
}
