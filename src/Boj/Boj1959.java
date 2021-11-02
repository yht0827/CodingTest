package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1959 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static long M, N;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        M = Long.parseLong(st.nextToken());
        N = Long.parseLong(st.nextToken());

        if (M == 2) sb.append(2);
        else if (N == 2) sb.append(3);
        else if (M <= N) sb.append(2 * (M - 1));
        else sb.append(3 + (N - 2) * 2);
        sb.append("\n");

        if (N % 2 == 0) {
            if (M >= N) sb.append(N / 2 + 1).append(" ").append(N / 2);
            else {
                if (M % 2 == 0) sb.append(M / 2 + 1).append(" ").append(M / 2);
                else sb.append((M - 1) / 2 + 1).append(" ").append(N - (M - 1) / 2);
            }
        } else {
            if (M >= N) sb.append(M - (N / 2)).append(" ").append(N / 2 + 1);
            else {
                if (M % 2 == 0) sb.append(M / 2 + 1).append(" ").append(M / 2);
                else sb.append((M + 1) / 2).append(" ").append(N - (M - 1) / 2);
            }
        }

        System.out.println(sb);
    }

}
