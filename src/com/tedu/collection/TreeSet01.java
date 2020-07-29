package com.tedu.collection;

import java.util.TreeSet;
class D{
    int a ;
}
public class TreeSet01 {
    public static void test01(){
        TreeSet treeSet = new TreeSet();
        treeSet.add(0);
        treeSet.add(5);
        treeSet.add(9);
        treeSet.add(-9);
        System.out.println(treeSet.first());
        System.out.println(treeSet.last());
        System.out.println(treeSet.subSet(3,6));
        System.out.println(treeSet.headSet(5));
        System.out.println(treeSet.tailSet(5));
        new TreeSet<>((o1,o2)->{return 1;});
    }
    public static void main(String[] args) {
        D d1 = new D();
        D d2 = new D();
        TreeSet treeSet = new TreeSet((o1,o2)->{
            return  ((D)o1).a > ((D)o2).a ?  1 :(((D)o1).a < ((D)o2).a ? -1 : 0);
        });
        d1.a =1 ;
        treeSet.add(d1);
        System.out.println(treeSet.add(d2));
        System.out.println(treeSet.remove(d2));
        System.out.println(treeSet);
        //test01();


    }


}

