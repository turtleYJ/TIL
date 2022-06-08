// memoization
// Dynamic Programming
// fibonacci
public class Fibonacci {
    long fibo(int n, HashMap<Integer, Long> memo) {
    	if (memo.containsKey(n)) return memo.get(n);
    	if (n <= 2) return 1;
    	memo.put(n, fibo(n - 1, memo) + fibo(n - 2, memo));
    	return memo.get(n);
    }
}