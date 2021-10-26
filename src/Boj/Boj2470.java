package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj2470 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[] arr;
    static int L, R;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int left = 0, right = arr.length - 1;
        int nearZero = Integer.MAX_VALUE;

        while (left < right) {
            int calc = arr[right] + arr[left];

            if (nearZero > Math.abs(calc)) {
                nearZero = Math.abs(calc);
                L = left;
                R = right;
            }

            if (calc < 0) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println(arr[L] + " " + arr[R]);
    }
}
