import java.util.*;

//https://www.hackerearth.com/submission/49976799/
//https://www.hackerearth.com/submission/key/22868ff6b1154189b9bffbc27e36773c
// https://leetcode.com/discuss/general-discussion/1072418/disjoint-set-union-dsuunion-find

/**
 *  Sample input below 
5 4
1 2
3 4
4 5
1 3

 */

/**
 * Sample output
    1 1 1 2
    1 2 2
    2 3
    5
 */

class DSU {
    int[] list;

    DSU(int n) {
        list = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            list[i] = i;
        }
        list[0] = -1;
    }

    public int root(int i) {
        while (list[i] != i) {
            i = list[i];
        }

        return i;
    }

    public void union(int x, int y) {
        int lx = list[x];
        for (int i = 0; i < list.length; ++i) {
            if (list[i] == lx) {
                list[i] = list[y];
            }
        }
    }

    public boolean find(int x, int y) {
        return root(x) == root(y);
    }

    public void countConnectedComponents() {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i < list.length; ++i) {
            if (map.containsKey(list[i])) {
                map.put(list[i], map.get(list[i]) + 1);
            } else {
                map.put(list[i], 1);
            }
        }
        List<Integer> values = new ArrayList<>(map.values());
        Collections.sort(values);
        for (int v : values) {
            System.out.print(v + " ");
        }
        System.out.println("");
    }
}

public class DisjointSetUnion {
    public static void main(String args[]) throws Exception {

        Scanner s = new Scanner(System.in);
        int N = s.nextInt(), M = s.nextInt();
        s.nextLine();

        DSU dsu = new DSU(N);

        while (M-- > 0) {
            String[] str = s.nextLine().split(" ");
            int x = Integer.valueOf(str[0]), y = Integer.valueOf(str[1]);
            dsu.union(x, y);

            dsu.countConnectedComponents();
        }

    }
}
