package Boj;

import java.io.*;
import java.util.StringTokenizer;

public class Boj1913 {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        int startX = N / 2;
        int startY = N / 2;
        map[startX][startY] = 1;
        int cnt = 2;
        int p = 1;
        int sw = -1;

        // 1. 상 -1 우 +1  2. 하 +1 좌 -1
        while (true) {

            for (int i = 0; i < p; i++) {
                startX = startX + sw;
                if (startX < 0) break;

                map[startX][startY] = cnt++;
            }

            sw *= -1;

            if (p == N) break;

            for (int i = 0; i < p; i++) {

                startY = startY + sw;
                map[startX][startY] = cnt++;
            }

            p++;
        }

        int x = 0, y = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                bw.write(map[i][j] + " ");
                if (map[i][j] == M) {
                    x = i;
                    y = j;
                }
            }
            bw.write("\n");
        }

        bw.write((x + 1) + " " + (y + 1) + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

}
