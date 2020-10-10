package com.jpeony.concurrent.synchronizeds.singleobject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 方法addUser上加上同步锁synchronized
 *
 * @author yihonglei
 */
public class HasSelfPrivateNum {
    private final static Logger logger = LoggerFactory.getLogger(HasSelfPrivateNum.class);
    private int num = 0;

    synchronized public void addUser(String username) {
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
