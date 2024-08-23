package com.jpeony.base.object;

//import org.junit.Assert;
//import org.junit.Test;

public class Person {
    public String name;
    public long identity = 0L;

    public Person(String name, long identity) {
        this.name = name;
        this.identity = identity;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Person) {
            if (((Person) obj).identity == this.identity) {
                return true;
            }
        }
        return false;
    }

//    @Test
//    public void testEqual() throws Exception {
//        Person x = new Person("aa", 1234);
//        Person y = new Person("aa", 12345);
//        Person z = new Person("bb", 1234);
//        Assert.assertTrue(x.equals(x));
//        Assert.assertTrue(x.equals(z));
//        Assert.assertTrue(z.equals(x));
//        Assert.assertFalse(x.equals(y));
//        Assert.assertFalse(x.equals(null));
//    }
}
