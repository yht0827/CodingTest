package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj14501 {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[] T, P;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        T = new int[N];
        P = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        work(0, 0);
        System.out.println(max);

    }

    public static void work(int date, int sum) {

        if (date == N) {
            max = Math.max(max, sum);
            return;
        }

        if (date + T[date] <= N)
            work(date + T[date], sum + P[date]);

        if (date < N)
            work(date + 1, sum);
    }


}
