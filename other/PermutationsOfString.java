/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class PermutationsOfString {
    static final PrintWriter out  = new PrintWriter(System.out, true);
    List<String> list = new ArrayList<>();

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = (int) sc.nextInt(), t=0;
        sc.nextLine();

        String[] strs = new String[T];
        while(t < T){
            strs[t] = sc.nextLine();
            t++;
        }

        for(String s : strs){
            List<String> list = new ArrayList<>();
            permutations(s, 0, list);
            Collections.sort(list);
            print(list);
            out.println("");
        }
    }

    public static void print(List<String> list){
        for(String s : list){
            out.print(s + " ");
        }
    }
x
    public static String permutations(String original, int index, List<String> list) {
        String s = String.valueOf(original.charAt(index));

        for(int i=0; i<original.length(); ++i){
            if(i != index) {
                String str = String.valueOf(original.charAt(i));
                list.add(str.concat(permutations(original, index+1, list)));
            }
        }
    }
}