package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1952 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int M, N, answer;
    static boolean[][] visited;
    static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N][M];
        int cnt = 0, x = 0, y = 0, d = 0;

        while (true) {

            visited[x][y] = true;
            cnt++;

            if (cnt == N * M) break;

            if (!isRange(x, y, d)) {
                answer++;
                d = (d + 1) % 4;
            }

            x += dir[d][0];
            y += dir[d][1];
        }


        System.out.println(answer);
    }

    private static boolean isRange(int x, int y, int d) {

        int dx = x + dir[d][0];
        int dy = y + dir[d][1];

        return dx >= 0 && dy >= 0 && dx < N && dy < M && !visited[dx][dy];
    }

}
