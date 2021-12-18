package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Boj6497 {

    static class Node implements Comparable<Node> {
        int start, end, weight;

        public Node(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(weight, o.weight);
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int m, n;
    static List<Node> list;
    static int[] check;


    public static void main(String[] args) throws IOException {

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());

            if (m == 0 && n == 0) break;

            list = new ArrayList<>();

            check = new int[m];
            for (int i = 0; i < m; i++) {
                check[i] = i;
            }

            int cost = 0;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int z = Integer.parseInt(st.nextToken());
                list.add(new Node(x, y, z));
                cost += z;
            }

            Collections.sort(list);

            int cnt = 0;
            int result = 0;
            while (cnt < list.size()) {
                Node node = list.get(cnt);

                int s = node.start;
                int e = node.end;
                int res = find(s, e);

                if (res == 1) {
                    cnt++;
                    continue;
                }

                makeUnion(s, e);
                result += node.weight;
                cnt++;
            }
            System.out.println(cost - result);
        }
    }

    public static void makeUnion(int a, int b) {
        a = parent(a);
        b = parent(b);

        if (a < b) check[b] = a;
        else check[a] = b;
    }

    public static int parent(int idx) {
        if (check[idx] == idx)
            return idx;
        return check[idx] = parent(check[idx]);
    }

    public static int find(int a, int b) {
        a = parent(a);
        b = parent(b);

        if (a == b) return 1;
        else return 0;
    }
}
