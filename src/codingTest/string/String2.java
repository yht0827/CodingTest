package codingTest.string;

public class String2 {

    public String solve(String str) {

        StringBuilder sb = new StringBuilder();
        StringBuilder result = new StringBuilder();
        int open = 0;

        for (char c : str.toCharArray()) {
            if (c == '(') {
                open++;
            } else if (c == ')') {
                if (open == 0) continue;
                open--;
            }
            sb.append(c);
        }

        // 뒤에서 부터 for문으로 해야 "()(" 와 같은 문자열 처리 가능
        for (int i = sb.length() - 1; i >= 0; i--) {
            // 쌍이 아닌 남는 '(' 처리
            if (sb.charAt(i) == '(' && open-- > 0) continue;
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
