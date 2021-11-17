package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj21921 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, X;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0, max, cnt = 0, sum = 0;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < X; i++) sum += arr[i];

        list.add(sum);
        max = sum;

        for (int right = X; right < N; right++) {
            sum += arr[right] - arr[left++];
            list.add(sum);
            max = Math.max(max, sum);
        }

        for (int i : list) if (i == max) cnt++;

        if (max == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(max);
            System.out.println(cnt);
        }
    }
}
