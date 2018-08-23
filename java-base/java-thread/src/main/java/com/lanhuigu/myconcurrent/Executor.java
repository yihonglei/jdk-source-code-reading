package com.lanhuigu.myconcurrent;

/**
 *
 * @author yihonglei
 * @date 2018/8/23 17:06
 */
public interface Executor {
    void execute(Runnable command);
}
