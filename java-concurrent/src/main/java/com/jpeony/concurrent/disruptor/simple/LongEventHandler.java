package com.jpeony.concurrent.disruptor.simple;

import com.lmax.disruptor.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 事件处理器（consumer）
 *
 * @author yihonglei
 */
public class LongEventHandler implements EventHandler<LongEvent> {
    private final static Logger logger = LoggerFactory.getLogger(LongEventHandler.class);

    @Override
    public void onEvent(LongEvent event, long sequence, boolean endOfBatch) throws Exception {
        logger.info("Event：" + event);
    }
}
