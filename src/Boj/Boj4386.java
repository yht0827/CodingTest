package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Boj4386 {

    static class Info implements Comparable<Info> {
        int s, e;
        double w;

        public Info(int s, int e, double w) {
            this.s = s;
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Info o) {
            return Double.compare(w, o.w);
        }

    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static double[][] cor;
    static List<Info> list;
    static int[] check;

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());
        cor = new double[n][2];
        list = new ArrayList<>();
        check = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            check[i] = i;
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            cor[i][0] = x;
            cor[i][1] = y;
        }

        for (int i = 0; i < cor.length; i++) {
            for (int j = i + 1; j < cor.length; j++) {
                double res = Math.sqrt(Math.pow(Math.abs(cor[i][0] - cor[j][0]), 2) + Math.pow(Math.abs(cor[i][1] - cor[j][1]), 2));
                list.add(new Info(i, j, res));
            }
        }

        Collections.sort(list);

        int cnt = 0;
        double result = 0;

        while (cnt < list.size()) {

            Info info = list.get(cnt);

            if (find(info.s, info.e)) {
                cnt++;
                continue;
            }

            union(info.s, info.e);
            cnt++;
            result += info.w;
        }

        System.out.printf("%.2f%n", result);

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
