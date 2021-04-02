package com.jpeony.reflect.spi;

/**
 * @author yihonglei
 */
public class SPIServiceImplTwo implements SPIService {

    @Override
    public void execute() {
        System.out.println("SPIServiceImplTwo.execute()");
    }
}
