package Boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Boj17144 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int R, C, T;
    static int[][] map;
    static int sum;
    static int[][] dir = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    static Queue<Dust> q = new LinkedList<>();
    static List<Integer> cleaner = new ArrayList<>();

    static class Dust {
        int x;
        int y;
        int size;

        public Dust(int x, int y, int size) {
            super();
            this.x = x;
            this.y = y;
            this.size = size;
        }
    }

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] > 0) {
                    q.offer(new Dust(i, j, map[i][j]));
                } else if (map[i][j] == -1) {
                    cleaner.add(i);
                }
            }
        }

        while (T > 0) {
            while (!q.isEmpty()) {
                Dust d = q.poll();

                int cnt = 0;
                for (int i = 0; i < 4; i++) {
                    int dx = d.x + dir[i][0];
                    int dy = d.y + dir[i][1];

                    if (dx >= 0 && dy >= 0 && dx < R && dy < C && map[dx][dy] >= 0) {
                        map[dx][dy] += d.size / 5;
                        cnt++;
                    }
                }
                map[d.x][d.y] -= d.size / 5 * cnt;
            }
            T--;

            moveCleaner();

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (map[i][j] > 0) {
                        q.offer(new Dust(i, j, map[i][j]));
                    }
                }
            }
        }

        // 개수 합
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] > 0)
                    sum += map[i][j];
            }
        }
        System.out.println(sum);
    }

    public static void moveCleaner() {

        int top = cleaner.get(0);

        for (int x = top - 1; x > 0; x--) {
            map[x][0] = map[x - 1][0];
        }

        for (int y = 0; y < C - 1; y++) {
            map[0][y] = map[0][y + 1];
        }

        for (int x = 0; x < top; x++) {
            map[x][C - 1] = map[x + 1][C - 1];
        }

        for (int y = C - 1; y > 1; y--) {
            map[top][y] = map[top][y - 1];
        }

        map[top][1] = 0;

        int bottom = cleaner.get(1);

        for (int x = bottom + 1; x < R - 1; x++) {
            map[x][0] = map[x + 1][0];
        }

        for (int y = 0; y < C - 1; y++) {
            map[R - 1][y] = map[R - 1][y + 1];
        }

        for (int x = R - 1; x > bottom; x--) {
            map[x][C - 1] = map[x - 1][C - 1];
        }

        for (int y = C - 1; y > 1; y--) {
            map[bottom][y] = map[bottom][y - 1];
        }

        map[bottom][1] = 0;

    }

}
