package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj23055 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j == 0 || j == N - 1 || i == 0 || i == N - 1 || i == j || j + i == N - 1) {
                    sb.append("*");
                } else {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

}
