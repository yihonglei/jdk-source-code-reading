package com.lanhuigu.java8.optional;

import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;
import java.util.Properties;

/**
 * @author yihonglei
 * @version 1.0.0
 * @ClassName: $CLASS_NAME
 * @Package: com.lanhuigu.java8.optional
 * @date 2018/3/15 14:19
 */
public class OptionalAllTest {

    @Test
    public void testProperties() {
        Properties props = new Properties();
        props.setProperty("a", "5");
        props.setProperty("b", "true");
        props.setProperty("c", "-3");

        Assert.assertEquals(5, readDuration(props, "a"));
        Assert.assertEquals(0, readDuration(props, "b"));
        Assert.assertEquals(0, readDuration(props, "c"));
    }

    public int readDuration(Properties props, String name) {
        String value = props.getProperty(name);
        if (value != null) {
            try {
                int i = Integer.parseInt(value);
                if (i > 0) {
                    return i;
                }
            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();
            }
        }

        return 0;
    }
}
