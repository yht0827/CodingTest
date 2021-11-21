package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Boj1484 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int G;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        G = Integer.parseInt(br.readLine());

        int x = 1, y = 1;

        while (x <= 50000) {
            long weight = (long) (x + y) * (x - y);
            if (weight >= G) {
                if (weight == G) list.add(x);
                y++;
            } else x++;
        }

        if (list.size() > 0) {
            list.forEach(System.out::println);
        } else {
            System.out.println(-1);
        }
    }
}
