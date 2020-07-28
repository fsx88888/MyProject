package com.tedu.collection;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * java 集合新增加Stream操作
 */
public class Collection04 {
    //Stream 类
    public static void test01() {
        IntStream iS = IntStream.builder().add(18).add(14).add(25).add(1).add(25).build();
        /**末端方法*/
        //forEach(IntConsumer action)  遍历流中每一个元素，对流执行action操作
        //iS.forEach(x -> System.out.println(x));

        //toArray 将流中所有元素转为一个数组
        // int[] array = iS.toArray();
        //System.out.println(Arrays.toString(array));

        //按照某种规则 对流中元素进行合并
        //OptionalInt reduce = iS.reduce(Math :: max );
        //System.out.println(reduce.getAsInt());

        //返回流中所有元素的数量
        //long count = iS.count();
        // System.out.println(count);

        //返回元素在是否所以元素都不符合条件
        boolean b = iS.noneMatch(x -> x > 5);
        System.out.println(b);
        //System.out.println("最大值："+iS.max().getAsInt());
        //System.out.println("最小值："+iS.min().getAsInt());
        //System.out.println("平均数" + iS.average().getAsDouble());
        //System.out.println("和" + iS.sum());
        //System.out.println("元素平方是否都大于20\t" + iS.allMatch(x -> x*x >20));
        /**中间方法*/
        //filter 过滤掉不满足条件的元素
        //IntStream intStream = iS.filter(x -> x > 17);
        //intStream.forEach(x -> System.out.println(x));

        //.map 对流中元素执行一对一的转换，生成新的流
        //IntStream newIS = iS.map(x -> x * 2 + 1);
        //newIS.forEach(System.out :: println);

        //.distinct 痛过equals比较去重
        //IntStream distinct = iS.distinct();
        // distinct.forEach(x -> System.out.println(x));

        // .sorted  保证流中的元素在后续的访问状态式一个有序的
        // IntStream sorted = iS.sorted();
        //sorted.forEach(System.out :: println);

        //.limit  用于限制后续访问元素的个数
        //IntStream limit = iS.limit(2);
        // limit.forEach(x -> System.out.println(x));
    }

    public static void main(String[] args) {
        test01();
    }
}
