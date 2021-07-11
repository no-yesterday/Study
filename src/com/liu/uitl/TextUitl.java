package com.liu.uitl;
/**
 * 文本信息工具类
 * 以后修改文本信息在这里修改
 */
public class TextUitl {
    //welcome界面
    //static 修饰方法   1.可以直接被类名.方法名调用()  2.在内存中只有一份，其他修改，他也会跟着修改
    //    static {
    //        //静态代码块
    //    }
    public static void welcome() {
        System.out.println("********************");
        System.out.println("欢迎使用ATM取款机");
        System.out.println("********************");
        System.out.println("请输入卡号：");
    }
}
