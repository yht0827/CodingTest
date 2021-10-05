package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Boj17129 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상 하 좌 우
    static int n, m;
    static int[][] map;
    static boolean flag;
    static Queue<Family> q = new LinkedList<>();
    static boolean[][] visited;

    static class Family {
        int x;
        int y;
        int cnt;

        public Family(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {

        String[] split = br.readLine().split(" ");
        n = Integer.parseInt(split[0]);
        m = Integer.parseInt(split[1]);
        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(str[j]);
                if (map[i][j] == 2) {
                    q.offer(new Family(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }

        loop:
        while (!q.isEmpty()) {
            Family f = q.poll();
            int x = f.x;
            int y = f.y;
            int cnt = f.cnt;

            for (int i = 0; i < 4; i++) {
                int dx = x + dir[i][0];
                int dy = y + dir[i][1];

                if (dx < 0 || dy < 0 || dx >= n || dy >= m || map[dx][dy] == 1 || visited[dx][dy]) continue;

                if (map[dx][dy] > 2) {
                    flag = true;
                    System.out.println("TAK");
                    System.out.println(cnt + 1);
                    break loop;
                }

                visited[dx][dy] = true;
                q.offer(new Family(dx, dy, cnt + 1));
            }
        }

        if (!flag) {
            System.out.println("NIE");
        }

    }
}
