package com.liu.aa;


import java.util.ArrayList;

public class MyJava {
    public static void main(String[] args) {    //main方法快捷键    psvm
        System.out.println("hello");    //输出快捷键    sout
        String name = "zz";
        System.out.println("name = " + name);   //输出变量   soutv
        System.out.println("MyJava.main");    //输出方法的名称    soutm
        System.out.println("args = [" + args + "]");    //输出方法的参数   soutp

        int age = 20;
        if (age < 20) {    //if判断语句    ifn
            System.out.println("小于20");
        }
        ArrayList<String> strings = new ArrayList<>();
        strings.add("一");    //快速复制一行    ctrl + d
        strings.add("二");
        strings.add("三");    //多行编辑    alt + 鼠标
        strings.add("四");    //撤销一步    ctrl + z
        strings.add("四");    //撤销多步    ctrl + shift + z
        strings.add("五");    //快速删除一行    ctrl + y

        for (String string : strings) {    //遍历循环    iter
            System.out.println("string = " + string);
        }
    }
}
