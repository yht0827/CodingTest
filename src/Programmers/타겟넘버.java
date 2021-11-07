package Programmers;

public class 타겟넘버 {

    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(solution(numbers, target));
    }

    public static int solution(int[] numbers, int target) {
        return dfs(numbers, 0, 0, target);
    }

    public static int dfs(int[] numbers, int n, int sum, int target) {

        if (n == numbers.length) {
            if (sum == target) {
                return 1;
            }
            return 0;
        }

        return dfs(numbers, n + 1, sum + numbers[n], target) + dfs(numbers, n + 1, sum - numbers[n], target);
    }
}
