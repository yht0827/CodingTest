package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj14676 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M, K;
    static List<List<Integer>> list;
    static int[] check;
    static int[] build;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        check = new int[N + 1];
        build = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.get(x).add(y);
            check[y]++;
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());

            if (num == 1) {
                if (check[a] > 0) {
                    System.out.println("Lier!");
                    return;
                } else {
                    build[a]++;
                    if (build[a] == 1) {  // 건물 관계 순서 처리
                        for (int j = 0; j < list.get(a).size(); j++) {
                            check[list.get(a).get(j)]--;
                        }
                    }

                }
            } else {
                if (build[a] > 0) {
                    build[a]--;
                    if (build[a] == 0) { // 건물 관계 순서 처리
                        for (int j = 0; j < list.get(a).size(); j++) {
                            check[list.get(a).get(j)]++;
                        }
                    }
                } else {
                    System.out.println("Lier!");
                    return;
                }
            }
        }

        System.out.println("King-God-Emperor");
    }

}
