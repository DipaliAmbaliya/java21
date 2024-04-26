import java.util.*;

public class SequencedCollection {
  public static void main(String[] args) {

    // SequencedCollection Interface used for List
    ArrayList<Integer> arrayList = new ArrayList<>();
    arrayList.add(1);
    arrayList.addFirst(0);
    arrayList.addLast(2);
    System.out.println(arrayList.getFirst());
    System.out.println(arrayList.getLast());

    List<Integer> reversed = arrayList.reversed();
    System.out.println(reversed); // Prints [2, 1, 0]

    arrayList.add(3);

    System.out.println( arrayList );	  //[0, 1, 2, 3]
    System.out.println( arrayList.reversed() );	//[3, 2, 1, 0]
    System.out.println(reversed.getLast());

// SequencedSet extends SequencedCollection for Set
    LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>(List.of(1, 2, 3));

    Integer firstElement = linkedHashSet.getFirst();
    Integer lastElement = linkedHashSet.getLast();

    linkedHashSet.addFirst(0);
    linkedHashSet.addLast(4);

    System.out.println(linkedHashSet.reversed());

// SequencedMap Interface
    LinkedHashMap<Integer, String> map = new LinkedHashMap<>();

    map.put(1, "One");
    map.put(2, "Two");
    map.put(3, "Three");

    map.firstEntry();
    map.lastEntry();

    System.out.println(map);

    Map.Entry<Integer, String> first = map.pollFirstEntry();   //1=One
    Map.Entry<Integer, String> last = map.pollLastEntry();    //3=Three

    System.out.println(map);

    map.putFirst(1, "One");
    map.putLast(3, "Three");

    System.out.println(map);
    System.out.println(map.reversed());

    SequencedSet<Integer> unmodifiableSequencedSet = Collections.unmodifiableSequencedSet(new LinkedHashSet<>(List.of(1, 2, 3)));
    System.out.println(unmodifiableSequencedSet.reversed());
    unmodifiableSequencedSet.add(4); //java.lang.UnsupportedOperationException


    //Collections Class
    //Collections.unmodifiableSequencedCollection(sequencedCollection);
    //Collections.unmodifiableSequencedSet(sequencedSet);
    //Collections.unmodifiableSequencedMap(sequencedMap);
  }
}
