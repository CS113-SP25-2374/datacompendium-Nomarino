package CS113;

import CS113.interfaces.ListInterface;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
         ListInterface<Integer> ourList = new LinkedListNM<>();
         List<Integer> javaList = new LinkedList<>();
         ArrayStackNM<Integer> stack = new ArrayStackNM<>();
         ArrayQueueNM<Integer> queue = new ArrayQueueNM<>();
         ArrayListNM<Integer> nameList = new ArrayListNM<>();


//        for (int i = 1; i <= 12; i++) {
//            ourList.add(i);
//            javaList.add(i);
//            stack.push(i);
//            System.out.println(stack);
//            queue.add(i);

//        }






        // Printing the Default ArrayList
        System.out.println("Default Array: " + nameList);
        // Adding and Printing Elements to the ArrayList
        nameList.add(1);
        nameList.add(2);
        nameList.add(3);
        nameList.add(4);
        nameList.add(5);
        nameList.add(6);

        System.out.println("ArrayList after adding elements: " + nameList);

        // Removing and Reprinting the Elements of the ArrayList
        nameList.remove(1);
        nameList.remove(2);
        nameList.remove(3);

        System.out.println("Arraylist after removing elements: " + nameList);

        // Iterating through the ArrayList
        System.out.println("Iterating through the ArrayList:");
        for (int i = 0; i < nameList.size(); i++)
        {
            System.out.println(nameList.get(i));
        }

        // Finding an Element in the ArrayList
        System.out.println("Finding an Element in the ArrayList (Index 0): " + nameList.get(0));
        System.out.println("Finding a Specific Element in the ArrayList (Index 1): " + nameList.get(1));
        System.out.println("Finding a Specific Element in the ArrayList (Index 2): " + nameList.get(2));








//        ourList.add(4, null);
//        javaList.add(4, null);

//         stack.pop();
//         queue.poll();
//         queue.poll();

//         System.out.println("Our Stack:" + stack);
//         System.out.println("Our Queue:" + queue);

//        System.out.println("Our List:");
//        System.out.println(ourList);

//        System.out.println("Java List:");
//        System.out.println(javaList);

//        System.out.println("Testing the Iterator:");
//        System.out.print("[");
//        ListIterableInterface<Integer> iterList = (ListIterableInterface<Integer>) ourList;
//        ListIteratorInterface<Integer> it = iterList.iterator();//       while (it.hasNext()) {
//            System.out.print(it.next());
//            if (it.hasNext()) { System.out.print(", "); }
//        }
//        System.out.println("]");
//
//        System.out.println("Cleared List:");
//        ourList.clear();
//        System.out.println(ourList);

        // HashMapNM<String, Integer> myHashTableNM = new HashMapNM<>();
        // myHashTableNM.put("One", 1);
        // myHashTableNM.put("Two", 2);
        // myHashTableNM.put("Three", 3);
        // myHashTableNM.put("Four", 4);
        // myHashTableNM.put("Five", 5);

        // myHashTableNM.remove("Three  ");
        // System.out.println(myHashTableNM.values());
        // System.out.println("Contains 'One'? " + myHashTableNM.get("One") != null ? "True" : "False");

    }
}