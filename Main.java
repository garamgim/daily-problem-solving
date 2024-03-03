import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int ans;
    static int[] used;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[] chu = new int[N];
            int[] used = new int[N];
            int totalSum = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                chu[i] = Integer.parseInt(st.nextToken());
                totalSum += chu[i];
            }

            ans = 0;
            counter(0, 0, 0, N, totalSum, chu, used);
            System.out.printf("#%d %d\n", tc+1, ans);
        }

    }
    static void counter(int lev, int leftSum, int rightSum, int N, int totalSum, int[] chu, int[] used) {
        if (lev == N) {
            ans++;
            return;
        }

        if (leftSum >= totalSum - leftSum) {
            int leftChu = N - lev;
            ans += Math.pow(2, leftChu) * factorial(leftChu);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (used[i] == 0) {
                used[i] = 1;
                if (leftSum + chu[i] >= rightSum) {
                    counter(lev + 1, leftSum + chu[i], rightSum, N, totalSum, chu, used);
                }
                if (leftSum >= rightSum + chu[i]) {
                    counter(lev + 1, leftSum, rightSum + chu[i], N, totalSum, chu, used);
                }
                used[i] = 0;
            }
        }
    }

    static int factorial(int n) {
        if (n == 0) {
            return 1;
        }

        return n * factorial(n - 1);
    }
}