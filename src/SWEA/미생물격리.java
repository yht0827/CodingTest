package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 미생물격리 {

    // https://swexpertacademy.com/main/talk/solvingClub/problemView.do?contestProbId=AV597vbqAH0DFAVl&solveclubId=AXrHhO1qc58DFATi&problemBoxTitle=%EC%82%BC%EC%84%B1+SW+%ED%85%8C%EC%8A%A4%ED%8A%B8+1%EC%A3%BC%EC%B0%A8&problemBoxCnt=4&probBoxId=AXvZ88iagBADFATN

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int answer;

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for (int test_case = 1; test_case <= T; test_case++) {
            int N, M, K;
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());


            //solve(N, M, K);

            System.out.println("#" + test_case + " " + answer);
        }
    }

    public static void solve(int N, int M, int K) {


    }
}
