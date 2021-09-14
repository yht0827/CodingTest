package Boj;

import java.io.*;
import java.util.StringTokenizer;

public class Boj12904 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        String str = st.nextToken();
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        sb.append(st.nextToken());

        while (sb.length() > str.length()) {
            if (sb.charAt(sb.length() - 1) == 'A') {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.deleteCharAt(sb.length() - 1).reverse();
            }
        }

        if (str.equals(sb.toString())) {
            answer = 1;
        }


        bw.write(answer + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

}
