package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj14888 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    static int[] arr;
    static int[] op = new int[4]; // + - * /

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

        backTrack(0, N - 1, new int[N - 1]);

        System.out.println(max);
        System.out.println(min);
    }

    private static void backTrack(int idx, int max, int[] arr) {

        if (idx == max) {
            sol(arr);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (op[i] == 0) continue;
            op[i]--;
            arr[idx] = i;
            backTrack(idx + 1, max, arr);
            op[i]++;
        }

    }

    private static void sol(int[] op) {
        int sum = arr[0];
        for (int i = 0; i < op.length; i++) {
            if (op[i] == 0) sum += arr[i + 1];
            else if (op[i] == 1) sum -= arr[i + 1];
            else if (op[i] == 2) sum *= arr[i + 1];
            else {
                if (arr[i] < 0 || sum < 0) sum = (Math.abs(sum / arr[i + 1])) * -1;
                else sum = sum / arr[i + 1];
            }
        }
        max = Math.max(sum, max);
        min = Math.min(sum, min);
    }

}
