package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj15961 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, d, k, c, answer;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int[] dish = new int[d + 1];
        int eat = 0;

        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(br.readLine());

        for (int i = 0; i < k; i++)
            if (dish[arr[i]]++ == 0) eat++;

        answer = eat; // 처음 초밥 개수 세팅 값

        for (int i = 1; i < n; i++) {
            // 초밥 추가 쿠폰 추가 작업
            if (answer <= eat) {
                if (dish[c] == 0) answer = eat + 1;
                else answer = eat;
            }

            if (--dish[arr[i - 1]] == 0) eat--; // 맨 앞에 빼기
            if (dish[arr[(i + k - 1) % n]]++ == 0) eat++; // 맨 뒤에 추가하기

        }
        System.out.println(answer);
    }
}
