package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Boj1174 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static List<Long> list = new ArrayList<>();
    static int N;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        if (N <= 11) { // 0 ~ 10
            System.out.println(N - 1);
        } else if (N > 1023) { // 9876543210
            System.out.println(-1);
        } else {
            for (int i = 0; i < 10; i++) {
                calculate(i, 1);
            }

            Collections.sort(list);
            System.out.println(list.get(N - 1));
        }
    }

    public static void calculate(long num, int depth) {
        if (depth >= 10) return;
        list.add(num);

        for (int i = 0; i < num % 10; i++) {
            calculate(num * 10 + i, depth + 1);
        }
    }
}
