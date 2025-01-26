package com.qy.coreconcept;

import com.qy.order.A;
import com.qy.order.B;
import org.springframework.core.OrderComparator;

import java.util.ArrayList;
import java.util.List;

public class OrderComparatorTest {
    public static void main(String[] args) {

    }

    public void testCompareOrder() {
        A a = new A(); // order=3
        B b = new B(); // order=2

        OrderComparator comparator = new OrderComparator();
        System.out.println(comparator.compare(a, b));  // 1
        List<Object> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        // 按order值升序排序
        list.sort(comparator);
        System.out.println(list);  // B，A
    }
}
