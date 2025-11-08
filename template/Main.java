import java.io.*;
import java.util.*;

public class Main {
    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens()) try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] readArray(int n) {
            int[] res = new int[n];
            for (int i = 0; i < n; i++) res[i] = nextInt();
            return res;
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        long[] readLongArray(int n) {
            long[] res = new long[n];
            for (int i = 0; i < n; i++) res[i] = nextLong();
            return res;
        }
    }

    static FastScanner in = new FastScanner();
    static StringBuilder out = new StringBuilder();

    public static void main(String[] args) {
        int T = 1;
        T = in.nextInt();
        for (int i = 1; i <= T; i++) {
            solve(i);
        }
        System.out.print(out);
    }

    static void solve(int testNum) {

    }
}
