package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj11728 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] A, B, C;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N];
        B = new int[M];
        C = new int[N + M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) B[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(A);
        Arrays.sort(B);

        // 투 포인터
        int a = 0, b = 0, c = 0;
        while (true) {
            if (a == A.length || b == B.length) break;
            else if (A[a] > B[b]) C[c++] = B[b++];
            else C[c++] = A[a++];
        }

        // 나머지 처리
        for (int i = a; i < A.length; i++) C[c++] = A[i];
        for (int i = b; i < B.length; i++) C[c++] = B[i];

        Arrays.stream(C).forEach(value -> sb.append(value).append(" "));
        System.out.println(sb);
    }
}
