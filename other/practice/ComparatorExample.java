package practice;

import java.util.*;
import java.util.stream.Collectors;

public class ComparatorExample {

    class Card implements Comparable{
        int id;
        String name;

        Card(int id, String name){
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return this.id + " " + this.name;
        }

        @Override
        public boolean equals(Object obj) {
            Card c = (Card) obj;
            return this.id == c.id;
        }

        @Override
        public int hashCode() {
            return this.id;
        }

        @Override
        public int compareTo(Object o) {
            Card c = ((Card) o);
            if(this.id < c.id){
                return 1;
            }else if(this.id > c.id){
                return -1;
            }

            return 0;
        }

    }

    class CardCom implements Comparator<Card>{
        @Override
        public int compare(Card o1, Card o2) {
            return Integer.compare(o1.id, o2.id);
        }
    }

    public static void main(String[] args) {
        ComparatorExample ex = new ComparatorExample();
        Card c1 = ex.new Card(2, "name1");
        Card c2 = ex.new Card(1, "name2");
        Card c3 = ex.new Card(1, "name2");
        Card c4 = ex.new Card(0, "name2");
        Card c5 = ex.new Card(10, "name2");

        List<Card> l = new ArrayList<>(Arrays.asList(c1, c2, c3, c4, c5));
        Collections.sort(l);

        System.out.println(l);

        System.out.println(c1.equals(c2));
        System.out.println(c3.equals(c2));

        System.out.println(Integer.class.isPrimitive());
        int[] input = new int[]{10, 12, 16};
        List<Integer> output = Arrays.stream(input).boxed().collect(Collectors.toList());

        

            //.collect(Collectors.joining(""));
        System.out.println(Arrays.stream( new String[]{"10", "2"}).collect(Collectors.joining("")));

        System.out.println("abcd".substring(1));
    }

}
