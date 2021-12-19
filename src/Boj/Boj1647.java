package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Boj1647 {

    static class Info implements Comparable<Info> {
        int start, end, weight;

        public Info(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Info o) {
            return Integer.compare(weight, o.weight);
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static List<Info> info;
    static int[] check;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        info = new ArrayList<>();
        check = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            check[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            info.add(new Info(a, b, c));
        }

        Collections.sort(info);

        int cnt = 0;
        int result = 0;
        int lastWeight = 0;

        while (cnt < info.size()) {
            Info info1 = info.get(cnt);

            int s = info1.start;
            int e = info1.end;

            if (find(s, e)) {
                cnt++;
                continue;
            }

            union(s, e);
            result += info1.weight;
            lastWeight = info1.weight;
            cnt++;
        }

        System.out.println(result-lastWeight);

    }

    private static void union(int s, int e) {
        int a = parent(s);
        int b = parent(e);

        if (a > b) check[b] = a;
        else check[a] = b;
    }

    private static boolean find(int s, int e) {
        int a = parent(s);
        int b = parent(e);

        return a == b;
    }

    private static int parent(int e) {
        if (check[e] == e)
            return e;
        return check[e] = parent(check[e]);
    }

}
