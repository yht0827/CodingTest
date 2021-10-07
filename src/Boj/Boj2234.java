package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2234 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, m;
    static int[][] map;
    static boolean[][] check;
    static int[] bit = {1, 2, 4, 8}; // 서 북 동 남
    static int[][] dir = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    static int cnt, room;
    static int max, maxRoom;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[m][n];
        check = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (check[i][j]) continue;
                room++;
                cnt = 0;
                dfs(i, j);
                if (cnt > max) max = cnt;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 4; k++) {
                    if ((bit[k] & map[i][j]) == 0) continue;

                    check = new boolean[m][n];
                    cnt = 0;
                    map[i][j] -= bit[k];
                    dfs(i, j);
                    map[i][j] += bit[k];

                    if (cnt > maxRoom) maxRoom = cnt;
                }
            }
        }

        System.out.println(room);
        System.out.println(max);
        System.out.println(maxRoom);
    }


    public static void dfs(int x, int y) {
        if (x < 0 || x >= m || y < 0 || y >= n || check[x][y]) return;

        check[x][y] = true;
        cnt = cnt + 1;

        for (int i = 0; i < 4; i++) {
            if ((map[x][y] & bit[i]) != 0) continue;
            dfs(x + dir[i][0], y + dir[i][1]);
        }
    }
}
