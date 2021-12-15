package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Boj4195 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static Map<String, Integer> map;
    static int[] check;
    static int[] cnt;

    public static void main(String[] args) throws IOException {
        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            int F = Integer.parseInt(br.readLine());
            map = new HashMap<>();
            check = new int[F * 2 + 1]; // 노드 최상위 부모 인덱스 체크
            cnt = new int[F * 2 + 1]; // 방문 노드 레벨 저장
            Arrays.fill(cnt, 1); // 초기 1로 설정

            int idx = 1;
            for (int j = 1; j <= F; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String f1 = st.nextToken();
                String f2 = st.nextToken();
                if (!map.containsKey(f1)) {
                    check[idx] = idx;
                    map.put(f1, idx++);
                }

                if (!map.containsKey(f2)) {
                    check[idx] = idx;
                    map.put(f2, idx++);
                }
                sb.append(union(map.get(f1), map.get(f2))).append("\n");
            }

        }
        System.out.println(sb);
    }

    private static int union(int f1, int f2) {
        int a = find(f1);
        int b = find(f2);

        if (a == b) return cnt[a];

        check[b] = a;
        return cnt[a] += cnt[b];
    }

    private static int find(int num) {
        if (check[num] == num) return num;
        return check[num] = find(check[num]);
    }


}
