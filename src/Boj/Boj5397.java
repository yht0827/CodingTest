package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj5397 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int T;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());

        LinkedList();

        // stack();
    }

    private static void LinkedList() throws IOException {
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

    private static void stack() throws IOException {

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            Stack<Character> left = new Stack<>();
            Stack<Character> right = new Stack<>();

            for (int j = 0; j < str.length(); j++) {
                char ch = str.charAt(j);
                switch (ch) {
                    case '<':
                        if (!left.isEmpty()) right.push(left.pop());
                        break;
                    case '>':
                        if (!right.isEmpty()) left.push(right.pop());
                        break;
                    case '-':
                        if (!left.isEmpty()) left.pop();
                        break;
                    default:
                        left.push(ch);
                }
            }
            StringBuilder sb1 = new StringBuilder();
            while (!left.isEmpty()) sb1.append(left.pop());
            sb.append(sb1.reverse());
            while (!right.isEmpty()) sb.append(right.pop());

            sb.append("\n");
        }

        System.out.println(sb);
    }
}
