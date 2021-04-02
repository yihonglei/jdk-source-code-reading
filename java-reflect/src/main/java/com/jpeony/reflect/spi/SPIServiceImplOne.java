package com.jpeony.reflect.spi;

/**
 * @author yihonglei
 */
public class SPIServiceImplOne implements SPIService {

    @Override
    public void execute() {
        System.out.println("SPIServiceImplOne.execute()");
    }
}
