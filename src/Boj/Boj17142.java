package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj17142 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int emptyCount;
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static List<int[]> list = new ArrayList<>();
    static boolean[] checked;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 0) {
                    emptyCount++;
                } else if (map[i][j] == 2) {
                    list.add(new int[]{i, j});
                }
            }
        }

        if (emptyCount == 0) {
            result = 0;
        } else {
            checked = new boolean[list.size()];
            dfs(0, 0);
        }

        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }

    private static void dfs(int idx, int cnt) {
        if (cnt == M) {
            virus(emptyCount);
            return;
        }

        for (int i = idx; i < checked.length; i++) {
            if (!checked[i]) {
                checked[i] = true;
                dfs(i + 1, cnt + 1);
                checked[i] = false;
            }
        }
    }

    private static void virus(int count) {
        Queue<int[]> q = new LinkedList<>();
        visited = new boolean[N][N];

        for (int i = 0; i < checked.length; i++) {
            if (checked[i]) {
                int x = list.get(i)[0];
                int y = list.get(i)[1];
                visited[x][y] = true;
                q.offer(new int[]{x, y, 0});
            }
        }


        while (!q.isEmpty()) {
            int[] poll = q.poll();

            for (int i = 0; i < 4; i++) {
                int dx = poll[0] + dir[i][0];
                int dy = poll[1] + dir[i][1];

                if (dx < 0 || dy < 0 || dx >= N || dy >= N || visited[dx][dy] || map[dx][dy] == 1) continue;

                if (map[dx][dy] == 0) {
                    count--;
                }

                if (count == 0) {
                    result = Math.min(result, poll[2] + 1);
                    return;
                }

                visited[dx][dy] = true;
                q.offer(new int[]{dx, dy, poll[2] + 1});
            }
        }
    }
}
