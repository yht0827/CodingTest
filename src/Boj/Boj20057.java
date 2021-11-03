package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj20057 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int result = 0, N;
    static int x, y, moveSend;
    static int[][] dir = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
    static int[][][] sendCor = {{{1, 1}, {-1, 1}, {-2, 0}, {2, 0}, {0, -2}, {-1, 0}, {1, 0}, {1, -1}, {-1, -1}, {0, -1}},
            {{-1, 1}, {-1, -1}, {0, -2}, {0, 2}, {2, 0}, {0, 1}, {0, -1}, {1, -1}, {1, 1}, {1, 0}},
            {{1, -1}, {-1, -1}, {-2, 0}, {2, 0}, {0, 2}, {-1, 0}, {1, 0}, {1, 1}, {-1, 1}, {0, 1}},
            {{1, 1}, {1, -1}, {0, -2}, {0, 2}, {-2, 0}, {0, -1}, {0, 1}, {-1, 1}, {-1, -1}, {-1, 0}}};
    static double[] percent = {0.01, 0.01, 0.02, 0.02, 0.05, 0.07, 0.07, 0.1, 0.1};
    static int[][] map;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        tornado();
        System.out.println(result);
    }

    private static void tornado() {
        x = N / 2;
        y = N / 2;
        int sw = 0;
        int p = 1;

        loop:
        while (true) {
            for (int k = 0; k < 2; k++) {
                for (int i = 0; i < p; i++) {
                    x += dir[sw][0];
                    y += dir[sw][1];
                    if (x == 0 && y == -1) break loop;
                    send(x, y, sw);
                }
                sw = (sw + 1) % 4;
            }
            p++;
        }
    }

    private static void send(int x, int y, int dir) {
        moveSend = 0;
        for (int i = 0; i < 10; i++) {
            int send;
            if (i < 9) {
                send = (int) Math.floor(map[x][y] * percent[i]);
                moveSend += send;
            } else {
                send = map[x][y] - moveSend;
            }
            calc(x + sendCor[dir][i][0], y + sendCor[dir][i][1], send);
        }
        map[x][y] = 0;
    }

    private static void calc(int dx, int dy, int send) {
        if (dx < 0 || dy < 0 || dx >= N || dy >= N) {
            result += send;
        } else {
            map[dx][dy] += send;
        }
    }
}
