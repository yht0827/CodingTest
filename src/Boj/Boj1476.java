package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1476 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int E, S, M; // 지구, 태양, 달

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        E = Integer.parseInt(st.nextToken()); // 1~15
        S = Integer.parseInt(st.nextToken()); // 1~28
        M = Integer.parseInt(st.nextToken()); // 1~19


        int time = 0, earth = 0, sun = 0, moon = 0;
        do {
            if (++earth >= 16) earth %= 15;
            if (++sun >= 29) sun %= 28;
            if (++moon >= 20) moon %= 19;
            time++;
        } while (earth != E || sun != S || moon != M);

        System.out.println(time);
    }
}
