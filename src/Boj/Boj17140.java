package Boj;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Boj17140 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int r, c, k, time;
    static int x = 3, y = 3;
    static int[][] map = new int[101][101];

    static class Pair implements Comparable<Pair> {

        int num;
        int count;

        public Pair(int num, int count) {
            this.num = num;
            this.count = count;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.count > o.count) {
                return 1;
            } else if (this.count == o.count) {
                return this.num - o.num;
            }
            return -1;
        }
    }


    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= x; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= y; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        func();

        if (time > 100) time = -1;

        System.out.println(time);
    }

    public static void func() {

        for (int i = 0; i <= 100; i++) {
            if (map[r][c] == k) break;

            if (x >= y) {
                for (int j = 1; j <= x; j++) {
                    R(j);
                }
            } else {
                for (int j = 1; j <= y; j++) {
                    C(j);
                }
            }
            time++;
        }
    }

    public static void R(int i) {
        Queue<Pair> pq = new PriorityQueue<>();
        Map<Integer, Integer> arr = new HashMap<>();

        for (int j = 1; j <= y; j++) {
            if (map[i][j] > 0) {
                arr.compute(map[i][j], (k, v) -> v == null ? 1 : v + 1);
            }
        }

        arr.forEach((k, v) -> pq.offer(new Pair(k, v)));


        int num = 1;
        while (!pq.isEmpty()) {
            Pair poll = pq.poll();
            map[i][num++] = poll.num;
            map[i][num++] = poll.count;
        }

        y = Math.max(y, num);

        for (int j = num; j <= 100; j++)
            map[i][j] = 0;
    }

    public static void C(int j) {
        Queue<Pair> pq = new PriorityQueue<>();
        Map<Integer, Integer> arr = new HashMap<>();

        for (int i = 1; i <= x; i++) {
            if (map[i][j] > 0) {
                arr.compute(map[i][j], (k, v) -> v == null ? 1 : v + 1);
            }
        }

        arr.forEach((k, v) -> pq.offer(new Pair(k, v)));

        int num = 1;
        while (!pq.isEmpty()) {
            Pair poll = pq.poll();
            map[num++][j] = poll.num;
            map[num++][j] = poll.count;
        }

        x = Math.max(x, num);

        for (int i = num; i <= 100; i++)
            map[i][j] = 0;
    }

}
