import java.util.*;

/**
 * Topological Sort
 * */
public class StronglyConnectedComponents {
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        Map<String, List<String>> m = new HashMap<>();
        m.put("A", Arrays.asList("D"));
        m.put("C", Arrays.asList("A", "B"));
        m.put("E", Arrays.asList("A", "D", "F"));
        m.put("B", Arrays.asList("D"));
        m.put("D", Arrays.asList("G", "H"));
        m.put("F", Arrays.asList("J", "K"));
        m.put("G", Arrays.asList("I"));
        m.put("H", Arrays.asList("I", "J"));
        m.put("J", Arrays.asList("M", "L"));
        m.put("K", Arrays.asList("J"));
        m.put("I", Arrays.asList("L"));
        m.put("J", Arrays.asList("L", "M"));
        m.put("M", new ArrayList<>());
        m.put("L", new ArrayList<>());

        List<String> leftToExplore = new ArrayList<>(m.keySet());

        while(leftToExplore.size() > 0){
            System.out.println(leftToExplore);
            traverse(leftToExplore.get(0), m, leftToExplore);
        }

        System.out.println(list);
    }

    static void traverse(String start, Map<String, List<String>> map, List<String> leftToExplore){
        if(!map.containsKey(start)) {
            return;
        };
        for(String s : map.get(start)){
            traverse(s, map, leftToExplore);
        }

        leftToExplore.remove(start);
        if(!list.contains(start)) {
            list.add(start);
        }
    }
}
