import java.util.HashMap;
import java.util.Map;

/**
 * Question: Given a list of items with values and weights, as well as a max weight,
 * find the maximum value you can generate from items where the sum of the
 * weights is less than the max.
 * 
 * @author nishakk
 *
 */
public class Knapsack {
	public static void main(String[] args) {
		int[] w = {10, 20, 30};
		int[] v = {60, 100, 120};
		System.out.println(knapsack(50, w, v, 0));
		System.out.println(knapsack_cache(50, w, v, 0, new HashMap<Integer, Map<Integer, Integer>>()));
		System.out.println(knapsack_dp(50, w, v));
	}
	
	/**
	 * Naive Solution
	 */
	private static int knapsack(int W, int[] weights, int[] vals, int i) {
		if (i == weights.length) return 0;
		if (W - weights[i] < 0) return knapsack(W, weights, vals, i + 1);
		return Math.max(knapsack(W - weights[i], weights, vals, i + 1) + vals[i], knapsack(W, weights, vals, i + 1));
	}
	
	/**
	 * Recursive solution with caching to improve performance
	 */
	private static int knapsack_cache(int W, int[] weights, int[] vals, int i, Map<Integer, Map<Integer, Integer>> cache) {
		if (i == weights.length) return 0;
		
		if (!cache.containsKey(i)) cache.put(i, new HashMap<>());
		Integer cached = cache.get(i).get(W);
	    if (cached != null) return cached;
	    
	    if (W - weights[i] < 0) return knapsack(W, weights, vals, i + 1);
		
		int val = Math.max(knapsack_cache(W - weights[i], weights, vals, i + 1, cache) + vals[i], 
				knapsack_cache(W, weights, vals, i + 1, cache));
		cache.get(i).put(W, val);
		return val;
	}
	
	/**
	 * DP Solution time complexity: O(n * W)
	 */
	private static int knapsack_dp(int W, int[] weights, int[] vals) {
		int[][] cache = new int[weights.length + 1][W + 1];
		for (int i = 1; i <= weights.length; i++) {
			for (int j = 1; j <= W; j++) {
				if (weights[i - 1] > j) cache[i][j] = cache[i - 1][j];
				else cache[i][j] = Math.max(cache[i - 1][j], cache[i - 1][j - weights[i - 1]] + vals[i - 1]);
			}
		}
		return cache[weights.length][W];
	}
}
