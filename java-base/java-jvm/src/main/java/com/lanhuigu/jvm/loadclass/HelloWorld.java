package com.lanhuigu.jvm.loadclass;

/**
 * 首先，在堆中会有一个”abc”实例，全局StringTable中存放着”abc”的一个引用值，
 * 然后在运行第二句的时候会生成两个实例，一个是”def”的实例对象，并且StringTable中存储一个”def”的引用值，
 * 还有一个是new出来的一个”def”的实例对象，与上面那个是不同的实例，当在解析str3的时候查找StringTable，
 * 里面有”abc”的全局驻留字符串引用，所以str3的引用地址与之前的那个已存在的相同，
 * str4是在运行的时候调用intern()函数，返回StringTable中”def”的引用值，如果没有就将str2的引用值添加进去，
 * 在这里，StringTable中已经有了”def”的引用值了，所以返回上面在new str2的时候添加到StringTable中的 “def”引用值，
 * 最后str5在解析的时候就也是指向存在于StringTable中的”def”的引用值，那么这样一分析之后。
 * <p>
 * 上面程序的首先经过编译之后，在该类的class常量池中存放一些符号引用，然后类加载之后，
 * 将class常量池中存放的符号引用转存到运行时常量池中，然后经过验证，准备阶段之后，在堆中生成驻留字符串的实例对象
 * （也就是上例中str1所指向的”abc”实例对象），然后将这个对象的引用存到全局String Pool中，也就是StringTable中，
 * 最后在解析阶段，要把运行时常量池中的符号引用替换成直接引用，那么就直接查询StringTable，保证StringTable里的引用值
 * 与运行时常量池中的引用值一致，大概整个过程就是这样了。
 *
 * 字符串常量池设计思想：
 * 1、字符串的分配，和其他的对象分配一样，耗费高昂的时间与空间代价，作为最基础的数据类型，大量频繁的创建 字符串，极大程度地影响程序的性能。
 *
 * 2、JVM为了提高性能和减少内存开销，在实例化字符串常量的时候进行了一些优化：
 *    1）为字符串开辟一个字符串常量池，类似于缓存区；
 *    2）创建字符串常量时，首先坚持字符串常量池是否存在该字符串；
 *    3）存在该字符串，返回引用实例，不存在，实例化该字符串并放入池中；
 */
public class HelloWorld {
    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = new String("def");
        String str3 = "abc";
        /*
         * intern用来返回常量池中的某字符串，如果常量池中已经存在该字符串，
         * 则直接返回常量池中该对象的引用。否则，在常量池中加入该对象，然后 返回引用值。
         */
        String str4 = str2.intern();
        String str5 = "def";
        //
        System.out.println(str1 == str3);
        //
        System.out.println(str2 == str4);
        //
        System.out.println(str4 == str5);
        // ========== 另外一个对象 ==========
        HelloWord2 h2 = new HelloWord2();
        //
        System.out.println(h2.str100 == str1);
        //
        System.out.println(h2.str200 == str2);
        //
        System.out.println(h2.str300 == str4);
    }
}

class HelloWord2 {
    String str100 = "abc";
    String str200 = new String("def");
    String str300 = str200.intern();
}
