package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj20056 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M, K;
    static int[][] dist = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
    static int result;
    static ArrayList<Fireball> list = new ArrayList<>();
    static ArrayList<Fireball>[][] map;

    static class Fireball {
        int r, c, m, s, d;

        public Fireball(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }

    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new ArrayList[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            list.add(new Fireball(r - 1, c - 1, m, s, d));
        }

        // 파이어볼 이동
        move();

        for (Fireball fireball : list) {
            result += fireball.m;
        }
        System.out.println(result);

    }

    private static void move() {

        while (K > 0) {
            for (Fireball fireball : list) {
                int dx = fireball.r + dist[fireball.d][0] * (fireball.s % N);
                int dy = fireball.c + dist[fireball.d][1] * (fireball.s % N);

                if (dx > 0) dx %= N;
                if (dy > 0) dy %= N;
                if (dx < 0) dx = N - Math.abs(dx);
                if (dy < 0) dy = N - Math.abs(dy);


                fireball.r = dx;
                fireball.c = dy;
                map[dx][dy].add(fireball);
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {

                    if (map[i][j].size() == 1) {
                        map[i][j].clear();
                    }

                    if (map[i][j].size() < 2) continue;

                    int mSum = 0;
                    int sSum = 0;
                    int odd = 0;
                    int even = 0;

                    for (Fireball fireball : map[i][j]) {
                        sSum += fireball.s;
                        mSum += fireball.m;

                        if (fireball.d % 2 == 0) odd++;
                        else even++;


                        list.remove(fireball);
                    }

                    int size = map[i][j].size();
                    sSum /= size;
                    mSum /= 5;
                    map[i][j].clear();

                    if (mSum == 0) continue;

                    if (odd == size || even == size) {
                        list.add(new Fireball(i, j, mSum, sSum, 0));
                        list.add(new Fireball(i, j, mSum, sSum, 2));
                        list.add(new Fireball(i, j, mSum, sSum, 4));
                        list.add(new Fireball(i, j, mSum, sSum, 6));
                    } else {
                        list.add(new Fireball(i, j, mSum, sSum, 1));
                        list.add(new Fireball(i, j, mSum, sSum, 3));
                        list.add(new Fireball(i, j, mSum, sSum, 5));
                        list.add(new Fireball(i, j, mSum, sSum, 7));
                    }
                }
            }

            K--;
        }

    }
}
