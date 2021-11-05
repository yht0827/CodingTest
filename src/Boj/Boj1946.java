package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1946 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int T, N;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int result = N;
            int[] score = new int[N];
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken())-1;
                int c = Integer.parseInt(st.nextToken());
                score[s] = c;
            }

            // 인원수 처리
            int max = score[0];
            for (int j = 1; j < N; j++) {
                if (max < score[j]) {
                    result--;
                } else {
                    max = score[j];
                }
            }

            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}
