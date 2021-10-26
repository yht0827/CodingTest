package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj17086 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static int[][] map;
    static int[][] dir = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
    static List<int[]> list = new ArrayList<>();
    static int result = 0;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) list.add(new int[]{i, j});
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) continue;

                Queue<int[]> q = new LinkedList<>();
                q.offer(new int[]{i, j, 0});
                boolean[][] visited = new boolean[N][M];
                visited[i][j] = true;
                int len = 0;

                while (!q.isEmpty()) {
                    int[] poll = q.poll();

                    if (map[poll[0]][poll[1]] == 1) {
                        len = poll[2];
                        break;
                    }

                    for (int k = 0; k < 8; k++) {
                        int dx = poll[0] + dir[k][0];
                        int dy = poll[1] + dir[k][1];

                        if (dx < 0 || dy < 0 || dx >= N || dy >= M || visited[dx][dy]) continue;

                        visited[dx][dy] = true;
                        q.offer(new int[]{dx, dy, poll[2] + 1});
                    }
                }
                q.clear();
                result = Math.max(result, len);
            }
        }

        System.out.println(result);
    }

}
