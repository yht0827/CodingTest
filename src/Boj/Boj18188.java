package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj18188 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int H, W, N;
    static char[][] cmd;
    static char[][] arr;
    static boolean flag;
    static int[][] cordi = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        arr = new char[H][W];
        int[] dao = new int[2];

        for (int i = 0; i < H; i++) {
            String str = br.readLine();
            for (int j = 0; j < W; j++) {
                arr[i][j] = str.charAt(j);
                if (arr[i][j] == 'D') {
                    dao[0] = i;
                    dao[1] = j;
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        cmd = new char[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            cmd[i][0] = st.nextToken().charAt(0);
            cmd[i][1] = st.nextToken().charAt(0);
        }

        move(dao, 0, "");

        if (!flag) {
            sb = new StringBuilder();
            sb.append("NO").append("\n");
        }

        System.out.println(sb);
    }

    private static void move(int[] dao, int move, String dir) {

        if (arr[dao[0]][dao[1]] == 'Z') {
            sb.append("YES").append("\n").append(dir);
            flag = true;
            return;
        }

        if (move >= N) return;

        for (int i = 0; i < 2; i++) {
            int dx = dao[0] + cordi["WASD".indexOf(cmd[move][i])][0];
            int dy = dao[1] + cordi["WASD".indexOf(cmd[move][i])][1];

            if (dx < 0 || dx >= H || dy < 0 || dy >= W || arr[dx][dy] == '@') continue;

            move(new int[]{dx, dy}, move + 1, dir + cmd[move][i]);

            if (flag) return;
        }
    }
}
