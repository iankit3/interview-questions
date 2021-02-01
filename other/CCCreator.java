import java.util.*;

class CCCreator{
    List<Integer> marked = new ArrayList<>();
    List<Integer> unMarked = new ArrayList<>();
    //int[] um = new int[]{0,1,2,3,4,5,6,7,8,9,10,11,12};
    int[] um = new int[]{ 1,2,3,4,5,6,7,8,9,10 }; 

    CCCreator(){
        for(int i : um){
            unMarked.add(i);
        }
    }

    int[][] edges = new int[][]{{0,1},{0,2},{0,5},{0,6},{5,3},{5,4},{6,4},{7,8},{9,10},{9,11},{9,12}};

    void dfs(int edge, int[][] edges){
        System.out.print(edge);
    }

    public static void main(String[] args) {
        CCCreator cc = new CCCreator();
        for(int v : cc.unMarked){
            if(!cc.marked.contains(v)){
                cc.dfs(v, cc.edges);
            }
        }
    }
}