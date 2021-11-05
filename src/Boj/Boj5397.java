package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj5397 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int T;

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            List<Character> list = new LinkedList<>();
            ListIterator<Character> cursor = list.listIterator();
            String str = st.nextToken();

            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);

                switch (c) {
                    case '>':
                        if (cursor.hasNext()) cursor.next();
                        break;
                    case '<':
                        if (cursor.hasPrevious()) cursor.previous();
                        break;
                    case '-':
                        if (cursor.hasPrevious()) {
                            cursor.previous();
                            cursor.remove();
                        }
                        break;
                    default:
                        cursor.add(c);
                }
            }
            for (Character ch : list) sb.append(ch);

            sb.append("\n");
        }

        System.out.println(sb);
    }
}
