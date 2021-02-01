import java.util.*;
import java.util.stream.IntStream;

class Solution{
    public static void main(String[] args) {
        int out = IntStream
        .rangeClosed(1, 9)
        .reduce(0, (acc, cur) -> acc+cur);

        System.out.println(out);
    }

}
