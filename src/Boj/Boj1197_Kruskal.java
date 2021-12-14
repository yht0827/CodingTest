package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Union - Find
 * 가선의 가중치가 작은거 부터 확인 (가중치 오름차순 정렬)
 * 새로 추가하는 Node가 같은 집합이 아닐 경우 새로 추가(즉, Cycle이 생성되지 않도록 한다.)
 * 위의 과정을 모든 Node를 탐색할때까지 반복
 */
public class Boj1197_Kruskal {

    static class Info implements Comparable<Info> {

        int start, target;
        long val;

        public Info(int start, int target, long val) {
            this.start = start;
            this.target = target;
            this.val = val;
        }

        @Override
        public int compareTo(Info o) {
            return Long.compare(val, o.val);
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int V, E;
    static int[] root;
    static List<Info> li;

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        root = new int[V + 1];
        li = new ArrayList<>();

        for (int i = 1; i <= V; i++) {
            root[i] = i;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            li.add(new Info(A, B, C));
        }

        Collections.sort(li);
        int cnt = 0;
        long result = 0;

        while (cnt < li.size()) {
            int start = li.get(cnt).start;
            int end = li.get(cnt).target;
            int res = find(start, end);

            // 사이클 생성되지 않도록 방지
            if (res == 1) {
                cnt++;
                continue;
            }

            makeUnion(start, end);
            result += li.get(cnt).val;
            cnt++;
        }

        System.out.println(result);
    }

    public static void makeUnion(int a, int b) {
        a = parent(a);
        b = parent(b);

        if (a < b) root[b] = a;
        else root[a] = b;

    }

    public static int parent(int a) {
        if (root[a] == a)
            return a;
        return root[a] = parent(root[a]);
    }

    public static int find(int a, int b) {
        a = parent(a);
        b = parent(b);

        if (a == b) return 1;
        else return 0;
    }

}
