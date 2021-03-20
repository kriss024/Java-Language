import java.util.*;

public class JavaCollections {

    public static void main(String[] args) {

        ArrayList<Integer> arrlist = new ArrayList<Integer>();
        arrlist.add(14);
        arrlist.add(7);
        arrlist.add(39);
        arrlist.add(40);

        /* Advanced For Loop*/
        System.out.println("Advanced For Loop");
        for (Integer num : arrlist) {
            System.out.println(num);
        }

        /* While Loop for iterating ArrayList*/
        System.out.println("While Loop");
        int count = 0;
        while (arrlist.size() > count) {
            System.out.println(arrlist.get(count));
            count++;
        }

        /*Looping Array List using Iterator*/
        System.out.println("Iterator");
        Iterator iter = arrlist.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

        //-----------------------------------

        Vector<String> vector = new Vector<String>();

        vector.add("Item1");
        vector.add("Item2");
        vector.add("Item3");
        vector.add("Item4");
        vector.add("Item5");
        vector.add("Item6");

        List subList = vector.subList(2,5);

        System.out.println("Sub list elements :");
        for(int i=0; i < subList.size() ; i++){
            System.out.println(subList.get(i));
        }

        //-----------------------------------
        List<String> list = Arrays.asList("iPhone", "Ubuntu", "Android", "Mac OS X");
        list.sort(null);

        System.out.println("Sorting with natural order");
        for (String str : list) {
            System.out.println(str);
        }

        //-----------------------------------

        HashSet<String> hset = new HashSet<String>();

        hset.add("Apple");
        hset.add("Mango");
        hset.add("Grapes");
        hset.add("Orange");
        hset.add("Fig");
        hset.add("Apple");
        hset.add("Mango");
        hset.add(null);
        hset.add(null);

        System.out.println("HashSet contains : "+ hset);

        String[] array = new String[hset.size()];
        hset.toArray(array);

        System.out.println("Array elements: ");
        for(String temp : array){
            System.out.println(temp);
        }
        //-----------------------------------

        HashMap<Integer, String> hmap = new HashMap<Integer, String>();

        hmap.put(12, "Chaitanya");
        hmap.put(2, "Rahul");
        hmap.put(7, "Singh");
        hmap.put(49, "Ajeet");
        hmap.put(3, "Anuj");

        System.out.println("HashMap key and values :");
        Set set = hmap.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry)iterator.next();
            System.out.print("key is: "+ mentry.getKey() + " & Value is: ");
            System.out.println(mentry.getValue());
        }

        HashMap<Integer, String> hmap2 = new HashMap<Integer, String>();

        hmap2.put(11, "Hello");
        hmap2.put(22, "Hi");
        hmap2.putAll(hmap);

        System.out.println("HashMap 2 contains: "+ hmap2);


    }
}
