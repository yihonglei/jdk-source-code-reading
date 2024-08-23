package com.jpeony.concurrent.synchronizeds.safeprivate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 方法内部的私有变量都是线程安全的
 */
public class HasSelfPrivateNum {
    private final static Logger logger = LoggerFactory.getLogger(HasSelfPrivateNum.class);

    public void addUser(String username) {
        try {
            int num = 0;
            if ("a".equals(username)) {
                num = 500;
                logger.info("a set over!");
                Thread.sleep(2000);
            } else {
                num = 1000;
                logger.info("b set over!");
            }
            System.out.println("username = " + username + " & num = " + num);
            logger.info("username = {}, num = {}", username, num);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
