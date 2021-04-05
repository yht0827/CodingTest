package codingTest.string;

public class String3 {

    public String solve(String[] str) {
        if (str.length == 0) {
            return "";
        }

        String firstStr = str[0];

        for (int i = 1; i < str.length; i++) {
            while (str[i].indexOf(firstStr) != 0) {
                firstStr = firstStr.substring(0, firstStr.length() - 1);
            }

        }
        return firstStr;

    }

    public static void main(String[] args) {

        String[] str = {"test", "teacher"};

        System.out.println(new String3().solve(str));
    }
}
