package com.jpeony.jvm.main;//package com.lanhuigu.jvm.main;

/**
 * java MainBoot会触发如下main方法执行过程：
 * 1、根据JVM内存配置要求，为JVM申请特定大小的内存空间；
 * 2、创建一个引导类加载器实例，初步加载系统类到内存元空间区域中；
 * 3、创建JVM启动器实例Launcher，并取得类加载器ClassLoader；
 * 4、使用上述获取的ClassLoader实例加载我们定义的MainBoot类；
 * 5、加载完成时候JVM会执行Main类的main方法入口，执行Main类的main方法；
 * 6、结束，java程序运行结束，JVM销毁。
 *
 * @author yihonglei
 */
public class MainBoot {
    public static void main(String[] args) {
        System.out.println("****** main ******");
    }
}
