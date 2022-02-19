package Programmers;

import java.util.Stack;

public class 괄호회전하기 {

    public static void main(String[] args) {
        String s = "[](){}";
        //String s = "}]()[{";
        System.out.println(solution(s));
    }

    private static int solution(String s) {
        int answer = 0;
        int len = s.length();

        for (int i = 0; i < len; i++) {
            String str = s.substring(i, len) + s.substring(0, i);

            if (check(str)) {
                answer++;
            }
        }
        return answer;
    }

    public static boolean check(String str) {
        int strLen = str.length();
        Stack<Character> st = new Stack<>();
        for (int j = 0; j < strLen; j++) {
            char ch = str.charAt(j);

            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if (st.empty()) {
                    return false;
                } else if ((st.peek() == '(' && ch == ')') || (st.peek() == '{' && ch == '}') ||
                        (st.peek() == '[' && ch == ']')) {
                    st.pop();
                } else {
                    return false;
                }
            }
        }

        return st.isEmpty();
    }

}
