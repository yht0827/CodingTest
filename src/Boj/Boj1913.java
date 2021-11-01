package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1913 {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
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
        int cnt = 1;
        int sw = -1;
        int p = 1;
        map[startX][startY] = cnt++;

        while (true) {

            for (int i = 0; i < p; i++) {
                startX += sw;
                if (startX < 0) break;
                map[startX][startY] = cnt++;
            }

            if (p == N) break;

            sw *= -1;


            for (int i = 0; i < p; i++) {
                startY += sw;
                map[startX][startY] = cnt++;
            }

            p++;
        }

        int x = 0, y = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(map[i][j] + " ");
                if (map[i][j] == M) {
                    x = i;
                    y = j;
                }
            }
            sb.append("\n");
        }

        sb.append((x + 1) + " " + (y + 1) + "\n");

        System.out.println(sb);
    }

}
