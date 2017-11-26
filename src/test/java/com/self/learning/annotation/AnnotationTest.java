package com.self.learning.annotation;


import org.junit.Test;

public class AnnotationTest {
    @Test
    public void test01() throws ClassNotFoundException {
        Class<?> clazz = Class.forName("com.self.learning.entity.Person");
        System.out.println(clazz);
        MyAnnotation1 annotation = clazz.getAnnotation(MyAnnotation1.class);
        MyAnnotation2[] props = annotation.props();
        for (MyAnnotation2 prop : props) {
            System.out.println(prop.name());
            System.out.println(prop.age());
            for (String s : prop.favarite()) {
                System.out.println(s);
            }
        }
        //System.out.println(annotation);
    }
}
