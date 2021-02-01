package practice.codeforces.contest593;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public final class A_Stones {
    static Map<String, Integer> map = new HashMap<>();
    static final PrintWriter out = new PrintWriter(System.out, true);

    public static int stones(int heap1, int heap2, int heap3, int count) {
        String key = heap1 + "," + heap2 + "," + heap3;

        if(map.containsKey(key)){
            return map.get(key);
        }

        int heap12 = count;
        if(heap1-1 >=0 && heap2-2 >= 0){
            heap12 += 3 + stones(heap1-1, heap2-2, heap3, count);
        }

        int heap23 = count;
        if(heap2-1 >= 0 && heap3-2 >= 0){
            heap23 += 3 +  stones(heap1, heap2-1, heap3-2, count);
        }
        
        
        count = Math.max(heap12, heap23);
        map.put(key, count);

        return count;
    }

    public static void main(String[] args) {
        
        try(Scanner s = new Scanner(System.in);){
            int testCases = s.nextInt();
            for(int i=0; i<testCases; ++i){
                out.println(stones(s.nextInt(), s.nextInt(), s.nextInt(), 0));
            }
        }

    }
}