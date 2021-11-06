package Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj1662 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String[] s;

    public static void main(String[] args) throws IOException {
        s = br.readLine().split("");
        Stack<String> stack = new Stack<>();
        for (String str : s) {
            if (!str.equals(")")) {
                stack.push(str);
            } else {
                int count = 0;
                while (!stack.peek().equals("(")) {
                    String popChar = stack.pop();
                    if (popChar.equals("*")) {
                        count += Integer.parseInt(stack.pop());
                    } else {
                        count++;
                    }
                }
                stack.pop();

                long num = Integer.parseInt(stack.pop());
                count *= num;

                stack.push(String.valueOf(count));
                stack.push("*");
            }
        }

        long length = 0;
        while (!stack.isEmpty()) {
            String popedString = stack.pop();

            if (popedString.equals("*")) {
                length += Integer.parseInt(stack.pop());
            } else {
                length += 1;
            }
        }

        System.out.println(length);
    }
}
