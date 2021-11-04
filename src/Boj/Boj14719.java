package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj14719 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int H, W;
    static int[] arr;


    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[W];
        for (int i = 0; i < W; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int L = 0, Lmax = arr[0];
        int R = W - 1, Rmax = arr[W - 1];
        int sum = 0;

        while (L != R) {

            if (arr[L] >= arr[R]) {
                R--;
                if (arr[R] <= Rmax) {
                    sum += Rmax - arr[R];
                } else {
                    Rmax = arr[R];
                }
            } else {
                L++;
                if (arr[L] <= Lmax) {
                    sum += Lmax - arr[L];
                } else {
                    Lmax = arr[L];
                }
            }
        }

        System.out.println(sum);
    }

}
