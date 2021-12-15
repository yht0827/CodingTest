package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1717 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, m;
    static StringBuilder sb = new StringBuilder();
    static int[] check;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        check = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            check[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (num == 0) {
                union(a, b);
            } else if (num == 1) {
                if (find(a, b)) {
                    sb.append("YES").append("\n");
                } else {
                    sb.append("NO").append("\n");
                }
            }
        }
        System.out.println(sb);
    }

    public static boolean find(int a, int b) {
        return parent(a) == parent(b);
    }

    public static int parent(int idx) {
        if (check[idx] == idx)
            return idx;
        return check[idx] = parent(check[idx]);
    }

    public static void union(int x, int y) {
        x = parent(x);
        y = parent(y);

        if (x < y) check[x] = y;
        else check[y] = x;
    }


}
