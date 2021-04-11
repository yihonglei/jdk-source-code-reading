package com.jpeony.concurrent.semaphore;

import java.util.concurrent.Semaphore;

/**
 * 卫生间有 5 个坑
 *
 * @author yihonglei
 */
public class Toilet {
    /**
     * 5个固定的茅坑
     */
    private static Semaphore semaphore = new Semaphore(5, true);

    /**
     * 茅坑
     */
    static class Pit {
        private String desc;

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }

    /**
     * 获取一个坑
     */
    public Pit getPit() throws InterruptedException {
        semaphore.acquire();

        Pit pit = new Pit();
        pit.setDesc("获得坑了");
        return pit;
    }

    /**
     * 释放一个坑
     */
    public Pit releasePit() {
        semaphore.release();

        Pit pit = new Pit();
        pit.setDesc("释放了坑");
        return pit;
    }
}
