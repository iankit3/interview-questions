import java.util.*;

/**
 * 
 *  0 / 1
 * 
 */

/**
 * 
 *
3
3
4
1 2 3
4 5 1
3
3
1 2 3
4 5 6
58
41
57 95 13 29 1 99 34 77 61 23 24 70 73 88 33 61 43 5 41 63 8 67 20 72 98 59 46 58 64 94 97 70 46 81 42 7 1 52 20 54 81 3 73 78 81 11 41 45 18 94 24 82 9 19 59 48 2 72
83 84 85 76 13 87 2 23 33 82 79 100 88 85 91 78 83 44 4 50 11 68 90 88 73 83 46 16 7 35 76 31 40 49 65 2 18 47 55 38 75 58 86 77 96 94 82 92 10 86 54 49 65 44 77 22 81 52
Your Output is:
3
0
223
 * 
 */

class Knapsack {
    static Map<String, Integer> memo = new HashMap<>();
    
	public static void main (String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		while(T > 0){
    		int N = sc.nextInt();
    		int W = sc.nextInt();
    		sc.nextLine();
    		
    		int[] vals = new int[N];
    		String[] line1 = sc.nextLine().split(" ");
    		for(int i=0; i<vals.length; ++i){
    		    vals[i] = (int) Integer.parseInt(line1[i]);
    		}
    		
    		int[] wgts = new int[N];
    		String[] line2 = sc.nextLine().split(" ");
    	    for(int i=0; i<wgts.length; ++i){
    	        wgts[i] = (int) Integer.parseInt(line2[i]);
    	    }
    	
    	    memo = new HashMap<>();
	        System.out.println(maxVal(0, 0, 0, W, vals, wgts));
            --T;	
		}

		sc.close();
	}

	
	public static int maxVal(int index, int total, int w, int W, int[] vals, int[] wgts){
	    String key = "index" + " | " + total + " | " + w;
	    if(w >= W || index >= vals.length) return total;
	    
	    if(memo.containsKey(key)){
	        return memo.get(key);
	    }
	   
	    int with = maxVal(index+1, total+vals[index], w+wgts[index], W, vals, wgts);
	    int withOut = maxVal(index+1, total, w, W, vals, wgts);
	    
	    int max = Math.max(w+wgts[index] > W ? total-vals[index] : with, withOut);
	    
	    memo.put(key, max);
	    
	    return max;
	}
}