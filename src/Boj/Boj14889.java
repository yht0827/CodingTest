package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj14889 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, answer = Integer.MAX_VALUE, T;
    static int[][] arr;
    static boolean[] start;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        start = new boolean[N];
        T = N / 2;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 팀 나누기
        teamDiv(0, 0);
        System.out.println(answer);
    }

    public static void teamDiv(int idx, int cnt) {

        if (cnt == T) {
            int startTeam = 0, linkTeam = 0;

            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {

                    // 스타트 팀
                    if (start[i] && start[j]) {
                        startTeam += (arr[i][j] + arr[j][i]);
                    } else if (!start[i] && !start[j]) {
                        linkTeam += (arr[i][j] + arr[j][i]);
                    }
                }
            }

            int diff = Math.abs(startTeam - linkTeam);

            if (answer > diff) {
                answer = diff;
            }

            return;
        }

        for (int i = idx; i < N; i++) {
            if (start[i]) continue;

            start[i] = true;
            teamDiv(i, cnt + 1);
            start[i] = false;
        }
    }

}
