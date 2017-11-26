package com.self.learning.entity;

import com.self.learning.annotation.MyAnnotation1;
import com.self.learning.annotation.MyAnnotation2;

@MyAnnotation1(props = {@MyAnnotation2(name="xieyonghong",age=31,favarite = {"basketball","football","game"})} )
public class Person {

}
