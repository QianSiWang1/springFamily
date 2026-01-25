package com.qy._01_ioc._01_core_concept;

import org.springframework.core.OrderComparator;
import org.springframework.core.annotation.AnnotationAwareOrderComparator;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author qy
 * @Date 2026/1/17
 */
public class _06_OrderComparator {
    public static void main(String[] args) {
        //testOrderComparator();
        testOrderComparatorInterface();
    }

    public static void testOrderComparator(){
        // order=3
        _06_OrderedA a = new _06_OrderedA();
        // order=2
        _06_OrderedB b = new _06_OrderedB();

        OrderComparator comparator = new OrderComparator();
        // 1
        System.out.println(comparator.compare(a, b));
        List<Object> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        // 按order值升序排序
        // B，A
        list.sort(comparator);
        System.out.println(list);
    }

    public static void testOrderComparatorInterface(){
        // order=3
        _06_OrderedAA a = new _06_OrderedAA();
        // order=2
        _06_OrderedBB b = new _06_OrderedBB();
        // 注解@Order使用 AnnotationAwareOrderComparator 比较器
        AnnotationAwareOrderComparator comparator = new AnnotationAwareOrderComparator();
        System.out.println(comparator.compare(a, b));
        List<Object> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        // 按order值升序排序
        // B，A
        list.sort(comparator);
        System.out.println(list);
    }
}
