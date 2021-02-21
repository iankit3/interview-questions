/**
 * HackerRank - https://www.hackerrank.com/challenges/crush/problem
 */
public class CumulativeSum {

    static long arrayManipulation(int n, int[][] queries) {
        long[] arr = new long [n+1];
        
        for(int[] q : queries){
            int a = q[0], b = q[1], k= q[2];
            
            // Build slope array - so later we can find cumulated sum
            arr[a] += k;
            if(b+1 <= n){
                arr[b+1] -= k;
            }

            /**
             * Or simply
             * // Build slope array - so later we can find cumulated sum
                    arr[a-1] += k;
                arr[b] -= k;
             */
        }

        long  MAX = 0, cumulatedSum = 0;;
        
        for(long a : arr){
            cumulatedSum += a;
            MAX = Math.max(MAX, cumulatedSum);
        }
        
        return MAX;
    }

    public static void main(String[] args){
        int n = 10;
        int[][] queries = {{1,5,3}, {4,8,7}, {6,9,1}};
        // Expected ans = 10; - visit https://www.hackerrank.com/challenges/crush/problem for explanation

        long result = arrayManipulation(n, queries); 

        System.out.println(result);
    }

    /***
     * My O(n^2) TLE Solution
     * 
     * 
        static long arrayManipulation(int n, int[][] queries) {
            int[] arr = new int[n+1];
            
            for(int[] q : queries){
                int a = q[0], b = q[1], k= q[2];
                
                for(int i=a; i<=b; ++i){
                    arr[i] += k; 
                }
            }

            int MAX = Integer.MIN_VALUE;
            
            for(int a : arr){
                MAX = Math.max(MAX, a);
            }
            
            return MAX;
        }
     */
}
