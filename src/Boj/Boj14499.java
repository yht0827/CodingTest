package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj14499 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N, M, x, y, K;
    static int[][] map;
    static int[] dice = {0, 0, 0, 0, 0, 0};
    static int[][] direction = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    static List<Integer> move = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            move.add(Integer.parseInt(st.nextToken()) - 1);
        }

        // 주사위 이동 & 맨 윗 면 출력
        for (int dir : move) {
            // 범위 밖에 나가는지 check
            if (isRange(dir)) continue;

            sb.append(moveDice(dir)).append("\n");
        }

        System.out.println(sb);
    }

    private static boolean isRange(int dir) {

        int dx = x + direction[dir][0];
        int dy = y + direction[dir][1];

        return dx < 0 || dy < 0 || dx >= N || dy >= M;
    }

    private static int moveDice(int dir) {

        if (dir == 0) { // 동
            y++;
            int temp = dice[3];
            dice[3] = dice[5];
            dice[5] = dice[2];
            dice[2] = dice[0];
            dice[0] = temp;

        } else if (dir == 1) { // 서
            y--;
            int temp = dice[3];
            dice[3] = dice[0];
            dice[0] = dice[2];
            dice[2] = dice[5];
            dice[5] = temp;

        } else if (dir == 2) { // 북
            x--;
            int temp = dice[1];
            dice[1] = dice[0];
            dice[0] = dice[4];
            dice[4] = dice[5];
            dice[5] = temp;

        } else { // 남
            x++;
            int temp = dice[1];
            dice[1] = dice[5];
            dice[5] = dice[4];
            dice[4] = dice[0];
            dice[0] = temp;
        }

        // 주사위 바닥면 복사
        if (map[x][y] == 0) {
            map[x][y] = dice[5];
        } else {
            dice[5] = map[x][y];
            map[x][y] = 0;
        }

        return dice[0];
    }

}
