package com.jpeony.concurrent.disruptor.simple;

import com.lmax.disruptor.EventFactory;

/**
 * 事件生产工厂
 */
public class LongEventFactory implements EventFactory<LongEvent> {
    @Override
    public LongEvent newInstance() {
        return new LongEvent();
    }
}
