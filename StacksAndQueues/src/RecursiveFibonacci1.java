
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RecursiveFibonacci1 {

    private static long[] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(bfr.readLine());
        memo = new long[n + 1];
        System.out.println(fibonacciWithMemoization(n));
    }

    private static long fibonacciWithMemoization(int num) {
        if (num <= 1) {
            return num;
        }
        if (memo[num] != 0) {
            return memo[num];
        }
        memo[num] = fibonacciWithMemoization(num - 1) + fibonacciWithMemoization(num - 2);
        return memo[num];
    }
}
