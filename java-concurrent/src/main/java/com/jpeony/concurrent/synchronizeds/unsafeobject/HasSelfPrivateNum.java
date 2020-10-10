package com.jpeony.concurrent.synchronizeds.unsafeobject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 实例变量为"非线程安全"
 *
 * @author yihonglei
 */
public class HasSelfPrivateNum {
    private final static Logger logger = LoggerFactory.getLogger(HasSelfPrivateNum.class);
    private int num = 0;

    public void addUser(String username) {
        try {
            if ("a".equals(username)) {
                num = 500;
                logger.info("a set over!");
                Thread.sleep(2000);
            } else {
                num = 1000;
                logger.info("b set over!");
            }
            logger.info("username = {}，num = {}", username, num);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
