// Smallest window containing 0, 1 and 2

import java.util.Arrays;
import java.util.Vector;

public class Jan3 {
    public static int findMinSubarrayLength(String S) {
        Vector<Integer> pos = new Vector<>(Arrays.asList(-1, -1, -1));
        int out = Integer.MAX_VALUE;

        for (int i = 0; i < S.length(); ++i) {
            pos.set(S.charAt(i) - '0', i);

            int nin = Integer.MAX_VALUE, nax = 0;
            for (int it : pos) {
                nin = Math.min(nin, it);
                nax = Math.max(nax, it);
            }

            if (nin != -1)
                out = Math.min(out, nax - nin + 1);
        }

        return out == Integer.MAX_VALUE ? -1 : out;
    }

    public static void main(String[] args) {
        String input = "your_input_string_here";
        int result = findMinSubarrayLength(input);
        System.out.println(result);
    }
}
