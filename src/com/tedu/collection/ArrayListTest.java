package com.tedu.collection;

import java.util.Arrays;
import java.util.List;

public class ArrayListTest {
    public static void main(String[] args) {
        int[] arrays = {1,2,3,4,5,6,7};
        List<int[]> ints = Arrays.asList(arrays);
        int[] remove = ints.remove(1);

        System.out.println(remove);
    }
}
