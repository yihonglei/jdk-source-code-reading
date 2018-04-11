package com.lanhuigu.others.enums;

/**
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: Burrito
 * @Package: com.lanhuigu.others.enums
 * @date 2018/4/9 11:41
 */
public class Burrito {
    Spiciness degree;
    public Burrito(Spiciness degree) { this.degree = degree;}
    public void describe() {
        System.out.print("This burrito is ");
        switch(degree) {
            case NOT: System.out.println("not spicy at all.");
                break;
            case MILD:
            case MEDIUM: System.out.println("a little hot.");
                break;
            case HOT:
            case FLAMING:
            default: System.out.println("maybe too hot.");
        }
    }
    public static void main(String[] args) {
        Burrito
                plain = new Burrito(Spiciness.NOT),
                greenChile = new Burrito(Spiciness.MEDIUM),
                jalapeno = new Burrito(Spiciness.HOT);
        plain.describe();
        greenChile.describe();
        jalapeno.describe();
    }
}
