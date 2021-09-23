package Boj;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj15684 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M, H, answer = -1;
    static boolean[][] ladderInfo;
    static boolean flag;

    static int stoi(String str) {
        return Integer.parseInt(str);
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        H = stoi(st.nextToken());

        ladderInfo = new boolean[H + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            ladderInfo[stoi(st.nextToken())][stoi(st.nextToken())] = true;
        }

        for (int i = 0; i < 4; i++) {
            backTrack(1, 1, i, 0);
            if (flag) break;
        }

        System.out.println(answer);
        br.close();
    }

    public static void backTrack(int x, int y, int max, int cnt) {

        if (flag) return;

        if (cnt == max) {
            if (check()) {
                answer = cnt;
                flag = true;
            }
            return;
        }

        for (int i = x; i <= H; i++) {
            for (int j = y; j < N; j++) {

                if (ladderInfo[i][j - 1] || ladderInfo[i][j] || ladderInfo[i][j + 1]) {
                    continue;
                }

                ladderInfo[i][j] = true;
                backTrack(i, j, max, cnt + 1);

                if (flag) return;
                ladderInfo[i][j] = false;
            }
            y = 1;
        }
    }

    public static boolean check() {

        for (int i = 1; i <= N; i++) {
            int x = 1;
            int y = i;

            while (x <= H) {
                // 사다리 좌 -> 우
                if (ladderInfo[x][y]) {
                    y++;
                } else if (ladderInfo[x][y - 1]) { // 사다리 우 -> 좌
                    y--;
                }
                x++;
            }

            if (y != i) return false;
        }
        return true;
    }
}
