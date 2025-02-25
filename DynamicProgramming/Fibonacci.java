package DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Varun Upadhyay (https://github.com/varunu28)
 */

public class Fibonacci {

    private static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        // Methods all returning [0, 1, 1, 2, 3, 5, ...] for n = [0, 1, 2, 3, 4, 5, ...]
        System.out.println(fibMemo(size));
        System.out.println(fibBotUp(size));
        System.out.println(fibOptimized(size));

    }

    /**
     * This method finds the nth fibonacci number using memoization technique
     *
     * @param n The input n for which we have to determine the fibonacci number
     *          Outputs the nth fibonacci number
     **/
    private static int fibMemo(int n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }

        int f;

        if (n <= 1) {
            f = n;
        } else {
            f = fibMemo(n - 1) + fibMemo(n - 2);
            map.put(n, f);
        }
        return f;
    }

    /**
     * This method finds the nth fibonacci number using bottom up
     *
     * @param n The input n for which we have to determine the fibonacci number
     *          Outputs the nth fibonacci number
     **/
    private static int fibBotUp(int n) {

        Map<Integer, Integer> fib = new HashMap<>();

        for (int i = 0; i <= n; i++) {
            int f;
            if (i <= 1) {
                f = i;
            } else {
                f = fib.get(i - 1) + fib.get(i - 2);
            }
            fib.put(i, f);
        }

        return fib.get(n);
    }


    /**
     * This method finds the nth fibonacci number using bottom up
     *
     * @param n The input n for which we have to determine the fibonacci number
     *          Outputs the nth fibonacci number
     *          <p>
     *          This is optimized version of Fibonacci Program. Without using Hashmap and recursion.
     *          It saves both memory and time.
     *          Space Complexity will be O(1)
     *          Time Complexity will be O(n)
     *          <p>
     *          Whereas , the above functions will take O(n) Space.
     * @author Shoaib Rayeen (https://github.com/shoaibrayeen)
     **/
    private static int fibOptimized(int n) {
        if (n == 0) {
            return 0;
        }
        int prev = 0, res = 1, next;
        for (int i = 2; i <= n; i++) {
            next = prev + res;
            prev = res;
            res = next;
        }
        return res;
    }
}