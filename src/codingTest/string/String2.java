package codingTest.string;

public class String2 {

    public String solve(String str) {

        StringBuilder sb = new StringBuilder();
        StringBuilder result = new StringBuilder();
        int openBrace = 0;

        for (char c : str.toCharArray()) {
            if (c == '(') {
                openBrace++;

            } else if (c == ')') {
                if (openBrace == 0) continue;
                openBrace--;
            }
            sb.append(c);
        }

        for (int i = sb.length() - 1; i >= 0; i--) {
            if (sb.charAt(i) == '(' && openBrace-- > 0) continue;
            result.append(sb.charAt(i));
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {

        String str1 = "in(f(lea)r)n)";
        String str2 = "(a(b(c)d)";
        String str3 = "a)b(c)d";
        String str4 = "))((";
        String str5 = ")()(";

        System.out.println(new String2().solve(str1));
        System.out.println(new String2().solve(str2));
        System.out.println(new String2().solve(str3));
        System.out.println(new String2().solve(str4));
        System.out.println(new String2().solve(str5));
    }

}
