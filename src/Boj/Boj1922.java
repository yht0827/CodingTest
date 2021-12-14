package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Boj1922 {

    static class Node implements Comparable<Node> {

        int start, end;
        int val;

        public Node(int start, int end, int val) {
            this.start = start;
            this.end = end;
            this.val = val;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(val, o.val);
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static List<Node> list;
    static int[] check;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        check = new int[N + 1];
        list = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            check[i] = i;
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list.add(new Node(s, e, v));
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
            result += node.val;
            cnt++;
        }
        System.out.println(result);
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
