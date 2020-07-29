package com.jpeony.jvm.loadclass;

/**
 * 肢解整个类演示！
 * 1）只有同时被final和static修饰的字段才有ConstantValue属性，且限于基本类型和String。
 *
 * @author yihonglei
 */
public class ClassLoadPosition {
    /*
     * 【类加载机制】static代码块
     * 准备阶段加载到常量池中，ConstantValue属性，类初始化时进行加载；
     */
    static {
        System.out.println("ConstClass init!");
    }

    /**
     * 【类加载机制】static final修饰
     *
     * static final修饰的字段在javac编译时生成comstantValue属性，在类加载的准备阶段直接把constantValue的值赋给该字段。
     * 可以理解为在编译期即把结果放入了常量池中。使用时进行建立引用。
     */
    public static int HELLO = 10000;

    /**
     * 【类加载机制】static修饰
     *
     * 准备阶段加载到常量池中，ConstantValue属性；
     * 变量值在准备阶段过后的初始值为0，而不是10000；
     * 因为这个时候尚未开始执行任何Java方法，而把HELLO赋值为250的putstatic指令是程序被编译后，
     * 存放于类构造器<clinit>方法之中，所以把HELLO赋值为1250的动作将在初始化阶段才会执行；
     */
    public static int value = 250;

    /**
     * 【类加载机制】final修饰
     * final修饰的字段在运行时被初始化，可以直接赋值，也可以在实例构造器中赋值，赋值后不可修改。
     */
    public final int i = 520;

    /**
     * 【类加载机制】普通非String变量
     * 字段在运行时被初始化，可以直接赋值，也可以在实例构造器中赋值，可以修改。
     */
    public int j = 1314;

    /**
     * 【类加载机制】String变量
     * 编译时确定，存在Constant_String_info里面，表示常量对象；
     * 如果是new的对象，在类初始化时堆里创建，如果字面量一样，都指向同一个内存地址，避免重复。
     *
     * 1）变量相加，会在常量池中重新开辟一个空间。
     * 2）常量相加，会在常量池寻找，有就返回，没有就创建
     * 3）String a = new  String("ABC");  这样会有两个引用，a指向的是堆内存。
     */
    private static final String str = "哥，别这么看着我，好尴尬！";
    private static String a = "ABC"; // final
    private static String b = "ABC";
    private static String c = "AB" + "C";
    private static String d = a + "";
    private static String e = a;
    private static String f = new String("ABC");
    private static String g = new String("ABC");

    public void love() {
        System.out.println("爱上爱笑的她...");
    }

    private static void firstLove() {
        String y = "想多了吧!";
        System.out.println("first-do-love");
    }

    private static class Person {
        /*
         * 存储在线程方法对应虚拟机栈的局部变量表里面
         */
        private String userName = "村里的哪个小芳";
        private int age = 18;
    }

    public static void main(String[] args) {
        Person p = new Person();

        firstLove();

        System.out.println("a=b:" + (a == b));
        System.out.println("a=c:" + (a == c));
        System.out.println("a=d:" + (a == d));
        System.out.println("a=e:" + (a == e));
        System.out.println("a=f:" + (a == f));
        System.out.println("a=g:" + (a == g));
    }
}
