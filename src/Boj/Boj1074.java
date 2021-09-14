package Boj;

import java.io.*;
import java.util.StringTokenizer;

public class Boj1074 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, r, c;
    static int answer,count;

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        work(0, 0, (int) Math.pow(2, N));

        bw.write(answer + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    public static void work(int x, int y, int arrLen) {

        if (x == r && y == c) {
            answer = count;
            return;
        }

        if (r < x + arrLen && c < y + arrLen && r >= x && c >= y) {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    work(x + (arrLen / 2) * i, y + (arrLen / 2) * j, arrLen / 2);
                }
            }
        } else {
            count += (int) Math.pow(arrLen, 2);
        }
    }
}
