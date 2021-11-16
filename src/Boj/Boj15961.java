package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj15961 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, d, k, c, answer, left, eat;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int[] dish = new int[d + 1];

        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(br.readLine());

        for (int right = 0; right < n; right++) {
            while (left < right + k) if (dish[arr[left++ % n]]++ == 0) eat++;

            answer = Math.max(answer, dish[c] == 0 ? eat + 1 : eat);
            if (--dish[arr[right]] == 0) eat--;
        }

        System.out.println(answer);
    }
}
