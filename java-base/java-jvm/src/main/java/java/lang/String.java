package java.lang;

/**
 * 双亲委派模式优势
 * 沙箱安全机制：自己写的String.class类不会被加载，这样便可以防止核心API库被随意篡改
 * 避免类的重复加载：当父亲已经加载了该类时，就没有必要子ClassLoader再   加载一次
 */
public class String {
    public static void main(String[] args) {
        System.out.println("******My String Class******");
    }
}
