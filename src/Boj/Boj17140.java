package Boj;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Boj17140 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int r, c, k, time, x = 3, y = 3;
    static int[][] arr = new int[101][101];

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

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= x; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= y; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        calc();

        if (time > 100)
            time = -1;

        System.out.println(time);
    }

    public static void calc() {

        while (time <= 100) {

            if (arr[r][c] == k) {
                break;
            }

            if (x >= y) {
                for (int i = 1; i <= x; i++) {
                    R(i);
                }
            } else {
                for (int i = 1; i <= y; i++) {
                    C(i);
                }
            }
            time++;
        }
    }

    public static void R(int i) {
        Queue<Pair> q = new PriorityQueue<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int j = 1; j <= y; j++) {
            if (arr[i][j] != 0)
                map.compute(arr[i][j], (k, v) -> v == null ? 1 : v + 1);
        }

        map.forEach((k, v) -> q.add(new Pair(k, v)));

        int num = 1;

        while (!q.isEmpty()) {
            Pair p = q.poll();
            arr[i][num++] = p.num;
            arr[i][num++] = p.count;
        }

        y = Math.max(y, num);

        while (num <= 99) {
            arr[i][num++] = 0;
            arr[i][num++] = 0;
        }
    }

    public static void C(int j) {
        Queue<Pair> q = new PriorityQueue<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 1; i <= x; i++) {
            if (arr[i][j] != 0)
                map.compute(arr[i][j], (k, v) -> v == null ? 1 : v + 1);
        }

        map.forEach((k, v) -> q.add(new Pair(k, v)));

        int num = 1;
        while (!q.isEmpty()) {
            Pair p = q.poll();
            arr[num++][j] = p.num;
            arr[num++][j] = p.count;
        }

        x = Math.max(x, num);

        while (num <= 99) {
            arr[num++][j] = 0;
            arr[num++][j] = 0;
        }
    }

}
