package com.babayan.homeworks.homework_20;

import com.babayan.lectures.lecture_20.MyTimer;

import java.util.*;

/**
 * В некоторых тестах отсутствует HashSet, я не видел смысла его туда включать.
 * <p>
 * results of testing:
 * *****************************
 * Adding speed to ArrayList is:
 * 34493600 ns
 * Adding speed to LinkedList is:
 * 116543900 ns
 * Adding speed to HashSet is:
 * 239229901 ns
 * Adding speed to TreeSet is:
 * 441763700 ns
 * *****************************
 * Adding speed to the middle of ArrayList is:
 * 64115100 ns
 * Adding speed to the middle of LinkedList is:
 * 1763369001 ns
 * Adding speed to the middle of TreeSet is:
 * 13528199 ns
 * *****************************
 * Adding to the beginning of ArrayList is:
 * 124878400 ns
 * Adding speed to the beginning of LinkedList is:
 * 84900 ns
 * Adding speed to the beginning of TreeSet is:
 * 125400 ns
 * *****************************
 * Removing speed from the beginning of ArrayList is:
 * 139510999 ns
 * Removing speed from the beginning of LinkedList is:
 * 421600 ns
 * Removing speed from the beginning of HashSet is:
 * 355100 ns
 * Removing speed from the beginning of TreeSet is:
 * 685400 ns
 * *****************************
 * Removing speed from the middle of ArrayList is:
 * 41757400 ns
 * Removing speed from the middle of LinkedList is:
 * 1685802700 ns
 * Removing speed from the middle of HashSet is:
 * 166301 ns
 * Removing speed from the middle of TreeSet is:
 * 198601 ns
 * *****************************
 * Removing speed from the End of ArrayList is:
 * 42499 ns
 * Removing speed from the End of LinkedList is:
 * 148199 ns
 * Removing speed from the End of TreeSet is:
 * 751000 ns
 * *****************************
 * true Find the first element in ArrayList is:
 * 2227600 ns
 * true Find the first element in LinkedList is:
 * 102900 ns
 * true Find element in HashSet is:
 * 92700 ns
 * true Find the first element in TreeSet is:
 * 91700 ns
 * *****************************
 * true Find middle element in ArrayList is:
 * 5414800 ns
 * true Find middle element in LinkedList is:
 * 5699500 ns
 * true Find element in HashSet is:
 * 172799 ns
 * true Find middle element in TreeSet is:
 * 117700 ns
 * *****************************
 * true Find element in the end of ArrayList is:
 * 3589500 ns
 * true Find element in the end of LinkedList is:
 * 6732500 ns
 * true Find element in HashSet is:
 * 131800 ns
 * true Find element in the end of TreeSet is:
 * 112299 ns
 * *****************************
 */
public class CollectionsTests {
    static ArrayList<Integer> collAL = new ArrayList<>();
    static LinkedList<Integer> collLL = new LinkedList<>();
    static HashSet<Integer> collHS = new HashSet<>();
    static TreeSet<Integer> collTS = new TreeSet<>();
    static MyTimer timer = new MyTimer();

    private static int findMiddleValueTreeSet(TreeSet<Integer> coll) {
        int loops = (coll.size() / 2) - 1;
        Iterator<Integer> iterator = coll.iterator();
        while (loops > 0) {
            iterator.next();
            loops--;
        }
        return iterator.next();
    }

    private static void removeFromEndForTreeSet(TreeSet<Integer> coll) {
        int loops = 1000;
        while (loops > 0) {
            coll.remove(coll.last());
            loops--;
        }
    }

    private static void removeFromEndForLists(List<Integer> coll) {
        int loops = 1000;
        int index = coll.size() - 1;
        while (loops > 0) {
            coll.remove(index);
            index--;
            loops--;
        }
    }

    private static void removeFromBegin(Collection<Integer> coll) {
        int num = 1000;
        Iterator<Integer> iterator = coll.iterator();
        if (coll.getClass() == ArrayList.class) {
            while (num > 0) {
                ((ArrayList<Integer>) coll).remove(1);
                num--;
            }
        } else {
            while (num > 0) {
                iterator.next();
                iterator.remove();
                num--;
            }
        }
    }

    private static void removeFromMid(Collection<Integer> coll) {
        int num = 1000;
        Iterator<Integer> iterator = coll.iterator();
        int size = coll.size();
        if (coll.getClass() == ArrayList.class) {
            while (num > 0) {
                ((ArrayList<Integer>) coll).remove(size / 2);
                num--;
            }
        } else if (coll.getClass() == LinkedList.class) {
            while (num > 0) {
                // I put the iterator inside the loop so that a new object is removed without remembering the iterator.
                // If the iterator is in the middle position outside the loop,
                // the rate of removal of elements will be O(1).
                ListIterator<Integer> listIterator = ((LinkedList<Integer>) coll).listIterator(size / 2);
                listIterator.next();
                listIterator.remove();
                num--;
            }
        } else while (num > 0) {
            iterator.next();
            iterator.remove();
            num--;
        }
    }

    private static void add(Collection<Integer> coll) {
        int num = 1_000_000;
        while (num > 0) {
            coll.add((int) (Math.random() * 100_000_000));
            num--;
        }
    }

    private static void addToTheBeginForLists(List<Integer> coll) {
        int num = 1_000;
        while (num > 0) {
            coll.add(0, (int) (Math.random() * 100_000_000));
            num--;
        }
    }

    private static void addToTheBeginForTSet(TreeSet<Integer> coll) {
        int loops = 1000;
        Iterator<Integer> iterator = coll.iterator();
        //добавляет с второго элемента
        int num = iterator.next() + 1;
        while (loops > 0) {
            coll.add(num++);
            loops--;
        }
    }

    private static void addToTheMidForLists(List<Integer> coll) {
        int num = 1000;
        while (num > 0) {
            coll.add(coll.size() / 2, (int) (Math.random() * 100_000_000));
            num--;
        }
    }

    private static void addToTheMidForTSets(TreeSet<Integer> coll) {
        int middleValue = findMiddleValueTreeSet(coll) + 1;
        int num = 1000;
        while (num > 0) {
            coll.add(middleValue++);
            num--;
        }
    }

    public static void tests() {
        System.out.println("*****************************");
        testCollAddSpeed();
        System.out.println("*****************************");
        testCollAddSpeedTMid();
        System.out.println("*****************************");
        testCollAddSpeedTBegin();
        System.out.println("*****************************");
        testCollRemoveSpeedFB();
        System.out.println("*****************************");
        testCollRemoveSpeedFM();
        System.out.println("*****************************");
        testCollRemoveSpeedFEnd();
        System.out.println("*****************************");
        findElFromCollB();
        System.out.println("*****************************");
        findElFromCollM();
        System.out.println("*****************************");
        findElFromCollEnd();
        System.out.println("*****************************");
    }

    private static void testCollAddSpeed() {
        timer.start();
        add(collAL);
        System.out.println("Adding speed to ArrayList is:");
        timer.printResult();

        timer.start();
        add(collLL);
        System.out.println("Adding speed to LinkedList is:");
        timer.printResult();

        timer.start();
        add(collHS);
        System.out.println("Adding speed to HashSet is:");
        timer.printResult();

        timer.start();
        add(collTS);
        System.out.println("Adding speed to TreeSet is:");
        timer.printResult();
    }

    private static void testCollAddSpeedTMid() {
        timer.start();
        addToTheMidForLists(collAL);
        System.out.println("Adding speed to the middle of ArrayList is:");
        timer.printResult();

        timer.start();
        addToTheMidForLists(collLL);
        System.out.println("Adding speed to the middle of LinkedList is:");
        timer.printResult();

        timer.start();
        addToTheMidForTSets(collTS);
        System.out.println("Adding speed to the middle of TreeSet is:");
        timer.printResult();
    }

    private static void testCollAddSpeedTBegin() {
        timer.start();
        addToTheBeginForLists(collAL);
        System.out.println("Adding to the beginning of ArrayList is:");
        timer.printResult();

        timer.start();
        addToTheBeginForLists(collLL);
        System.out.println("Adding speed to the beginning of LinkedList is:");
        timer.printResult();

        timer.start();
        addToTheBeginForTSet(collTS);
        System.out.println("Adding speed to the beginning of TreeSet is:");
        timer.printResult();
    }

    private static void testCollRemoveSpeedFB() {
        timer.start();
        removeFromBegin(collAL);
        System.out.println("Removing speed from the beginning of ArrayList is:");
        timer.printResult();

        timer.start();
        removeFromBegin(collLL);
        System.out.println("Removing speed from the beginning of LinkedList is:");
        timer.printResult();

        timer.start();
        removeFromBegin(collHS);
        System.out.println("Removing speed from the beginning of HashSet is:");
        timer.printResult();

        timer.start();
        removeFromBegin(collTS);
        System.out.println("Removing speed from the beginning of TreeSet is:");
        timer.printResult();
    }

    private static void testCollRemoveSpeedFM() {
        timer.start();
        removeFromMid(collAL);
        System.out.println("Removing speed from the middle of ArrayList is:");
        timer.printResult();

        timer.start();
        removeFromMid(collLL);
        System.out.println("Removing speed from the middle of LinkedList is:");
        timer.printResult();

        timer.start();
        removeFromMid(collHS);
        System.out.println("Removing speed from the middle of HashSet is:");
        timer.printResult();

        timer.start();
        removeFromMid(collTS);
        System.out.println("Removing speed from the middle of TreeSet is:");
        timer.printResult();
    }

    private static void testCollRemoveSpeedFEnd() {
        timer.start();
        removeFromEndForLists(collAL);
        System.out.println("Removing speed from the End of ArrayList is:");
        timer.printResult();

        timer.start();
        removeFromEndForLists(collLL);
        System.out.println("Removing speed from the End of LinkedList is:");
        timer.printResult();

        timer.start();
        removeFromEndForTreeSet(collTS);
        System.out.println("Removing speed from the End of TreeSet is:");
        timer.printResult();
    }

    private static void findElFromCollB() {
        Integer integer = collAL.get(1);
        timer.start();
        boolean contains = collAL.contains(integer);
        System.out.println(contains + " Find the first element in ArrayList is:");
        timer.printResult();

        Integer first = collLL.getFirst();
        timer.start();
        boolean contains1 = collLL.contains(first);
        System.out.println(contains1 + " Find the first element in LinkedList is:");
        timer.printResult();

        Integer next = collHS.iterator().next();
        timer.start();
        boolean contains3 = collHS.contains(next);
        System.out.println(contains3 + " Find element in HashSet is:");
        timer.printResult();

        Integer first1 = collTS.first();
        timer.start();
        boolean contains2 = collTS.contains(first1);
        System.out.println(contains2 + " Find the first element in TreeSet is:");
        timer.printResult();
    }

    private static void findElFromCollM() {
        Integer integer = collAL.get(collAL.size() / 2);
        timer.start();
        boolean contains = collAL.contains(integer);
        System.out.println(contains + " Find middle element in ArrayList is:");
        timer.printResult();

        Integer first = collLL.get(collLL.size() / 2);
        timer.start();
        boolean contains1 = collLL.contains(first);
        System.out.println(contains1 + " Find middle element in LinkedList is:");
        timer.printResult();

        Iterator<Integer> iterator = collHS.iterator();
        int loops = collHS.size() / 2;
        while (loops > 0) {
            iterator.next();
            loops--;
        }
        Integer next = iterator.next();
        timer.start();
        boolean contains3 = collHS.contains(next);
        System.out.println(contains3 + " Find element in HashSet is:");
        timer.printResult();

        Integer first1 = findMiddleValueTreeSet(collTS);
        timer.start();
        boolean contains2 = collTS.contains(first1);
        System.out.println(contains2 + " Find middle element in TreeSet is:");
        timer.printResult();
    }

    private static void findElFromCollEnd() {
        Integer integer = collAL.get(collAL.size() - 1);
        timer.start();
        boolean contains = collAL.contains(integer);
        System.out.println(contains + " Find element in the end of ArrayList is:");
        timer.printResult();

        Integer last1 = collLL.getLast();
        timer.start();
        boolean contains1 = collLL.contains(last1);
        System.out.println(contains1 + " Find element in the end of LinkedList is:");
        timer.printResult();

        Iterator<Integer> iterator = collHS.iterator();
        int loops = collHS.size() - 1;
        while (loops > 0) {
            iterator.next();
            loops--;
        }
        Integer next = iterator.next();
        timer.start();
        boolean contains3 = collHS.contains(next);
        System.out.println(contains3 + " Find element in HashSet is:");
        timer.printResult();

        Integer last = collTS.last();
        timer.start();
        boolean contains2 = collTS.contains(last);
        System.out.println(contains2 + " Find element in the end of TreeSet is:");
        timer.printResult();
    }

    public static void main(String[] args) {
        tests();
    }
}