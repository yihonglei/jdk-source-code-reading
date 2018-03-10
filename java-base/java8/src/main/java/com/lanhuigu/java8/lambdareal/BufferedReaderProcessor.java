package com.lanhuigu.java8.lambdareal;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * @version 1.0.0
 * @ClassName: $CLASS_NAME
 * @Package: com.lanhuigu.java8.lambdareal
 * @Author yihonglei
 * @date 2018/3/6 10:14
 */
@FunctionalInterface
public interface BufferedReaderProcessor {
    // 函数式接口抽象方法的签名基本上就是lambda表达式签名，这种抽象方法叫做函数描述符。
    String process(BufferedReader b) throws IOException;
}
