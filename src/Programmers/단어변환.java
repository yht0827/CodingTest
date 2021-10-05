package Programmers;

public class 단어변환 {

    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};

        System.out.println(solution(begin, target, words));
    }

    static int answer = Integer.MAX_VALUE;
    static boolean check = false;

    public static int solution(String begin, String target, String[] words) {
        boolean flag = false;

        for (String word : words) {
            if (word.equals(target)) {
                flag = true;
                break;
            }
        }
        if (!flag) return 0;

        boolean[] checkMap = new boolean[words.length];
        dfs(begin, target, words, checkMap, 0);

        return answer;
    }

    public static void dfs(String begin, String target, String[] words, boolean[] checkMap, int cnt) {

        if (target.equals(begin)) {
            if (answer > cnt)
                answer = cnt;
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (!checkMap[i] && changeLetter(begin, words[i])) {
                checkMap[i] = true;
                dfs(words[i], target, words, checkMap, cnt + 1);
                checkMap[i] = false;
            }
        }
    }

    public static boolean changeLetter(String begin, String changeWord) {

        int len = begin.length();
        int cnt = 0;

        for (int i = 0; i < len; i++) {
            if (begin.charAt(i) != changeWord.charAt(i)) cnt++;
        }

        return cnt == 1;
    }

}
